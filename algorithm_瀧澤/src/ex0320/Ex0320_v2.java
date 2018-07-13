package ex0320;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * わざと、for文を使って解いた場合
 *
 * @author 瀧澤
 */
public class Ex0320_v2 {

	public static void main(String[] args) {
		int inputNumber = 0;
		int result = 1;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number:");

		try {
		inputNumber = scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("\r\n数字以外が入力されました。\n処理を終了します");
			return;
		}
		for(int i = 1; i <= inputNumber; i++) {
			result = result * i;
		}
		System.out.println("\r\n" + inputNumber + "の階乗は" + result + "です");
	}
}