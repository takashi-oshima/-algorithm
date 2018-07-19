package takai.ex0250;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 入力された値が素数かどうかを二分探索を用いて判定するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0250 {

	public static void main(String[] args) {
		/** 1つ目の文字列 */
		int inputNumber = 0;
		/** 素数 */
		int[] primeNumber = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 53, 59, 61, 67, 71, 73, 79, 83, 89,
				97 };

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

		//以下で二分探索を行います
		/** 配列の左端を取得 */
		int left = 0;
		/** 配列の長さを取得 */
		int right = primeNumber.length;

		while (left < right) {
			/** 配列の中央を取得 */
			final int CENTER = (left + right) / 2;
			if (primeNumber[CENTER] == inputNumber) {
				System.out.println("素数です");
				return;
			} else if (primeNumber[CENTER] > inputNumber) {
				right = CENTER;
			} else if (primeNumber[CENTER] < inputNumber) {
				left = CENTER + 1;
			}
		}
		System.out.println("素数ではありません。");
	}
}