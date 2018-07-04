package ex0241;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 整数値を入力し、その行数分の直角三角形を出力します
 *
 * @author 鶴田竜也
 */
public class Ex0241 {

	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int inputInt;

		//キーボードから入力された整数を取得します
		System.out.println("input number：");
		try {
			inputInt = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//直角三角形を出力します
		for (int i = 1; i <= inputInt; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}