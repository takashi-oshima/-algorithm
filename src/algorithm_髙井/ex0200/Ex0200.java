package ex0200;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 1から入力値までの和を算出し出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0200 {

	public static void main(String[] args) {
		/** 1つ目の文字列 */
		int inputNumber = 0;
		/** 合計値の格納用 */
		int sum = 0;

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

		//1からnまでの和を求めて出力します。
		if (inputNumber < 0) {
			sum = (inputNumber * (inputNumber - 1)) / -2 + 1;
		} else {
			sum = (inputNumber * (inputNumber + 1)) / 2;
		}
		System.out.println("合計値 =  " + sum);
	}
}