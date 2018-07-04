package ex0241;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 整数値を入力し、その数分の直角三角形を出力します
 *
 * @author 小金井 広輝
 */
public class Ex0241 {
	public static void main(String[] args) {
		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int inputInt;

		//キーボードから入力された整数を取得します。
		System.out.println("input number：");
		try {
			inputInt = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//正数が入力されているかの確認
		if (inputInt < 0) {
			System.out.println("正数を入力して下さい");
			return;
		}

		//直角三角形を出力します
		for (int i = 0; i < inputInt; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
