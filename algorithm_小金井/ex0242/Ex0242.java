package ex0242;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 整数値を入力し、その数分の二等辺三角形を出力します
 *
 * @author 小金井 広輝
 */
public class Ex0242 {
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

		//二等辺三角形を出力します
		for (int i = 1; i <= inputInt; i++) {
			for (int j = inputInt - i; 0 < j; j--) {
				System.out.print(" ");
			}
			for (int k = 0; k < i * 2 - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
