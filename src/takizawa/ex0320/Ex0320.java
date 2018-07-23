package takizawa.ex0320;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex0320 {
	public static void main(String[] args) {
		int inputNumber = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number:");

		try {
		inputNumber = scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("\r\n数字以外が入力されました。\n処理を終了します");
			return;
		}
		System.out.println("\r\n" + inputNumber + "の階乗は" + func(inputNumber) + "です");
	}
	public static int func(int i) {
		if(i > 1) {
			int result = i * func(i -1);
			return result;
		}
		else {
			return 1;
		}
	}
}