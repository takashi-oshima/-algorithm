package ex0240;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 入力された数値が九九の表にあるかどうかを出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0240 {

	public static void main(String[] args) {
		/** 1つ目の文字列 */
		int inputNumber = 0;
		/** 合計値の格納用 */
		boolean availability = false;

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//入力値を代入します。
			System.out.println("input number：");
			inputNumber = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("不適な文字列です。整数を入力してください。");
			return;
		}
		if (inputNumber < 10 || inputNumber > 99) {
			System.out.println("入力値が不正です。2桁の整数を入力してください。");
			return;
		}

		//入力された数値が九九の表にあるかどうかを判定します。
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (inputNumber == (i * j)) {
					System.out.println("九九の表(" + i + "*" + j + ")にあります。");
					availability = true;
				}
			}
		}
		if (availability == false) {
			System.out.println("九九の表にありません。");
		}
	}
}