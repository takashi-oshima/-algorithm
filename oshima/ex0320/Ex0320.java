package oshima.ex0320;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力した整数値の階乗を計算して出力します。
 * 再帰呼び出しで作成します。
 *
 * @author 大島
 */
public class Ex0320 {

	public static void main(String[] args) {
		// 入力した整数を格納する変数です。
		long inputNumber = 0;

		// キーボード入力を受け付け、入力内容を変数に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("input number：");
			inputNumber = scanner.nextLong();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}
		// 入力の範囲をチェックします。
		// 21の階乗でlong型が扱える値の範囲を超えるため、20を上限値とします。
		if (inputNumber < 0 || inputNumber > 20) {
			System.out.println("入力値が正しい範囲ではありません。");
			return;
		}
		System.out.println(inputNumber + "の階乗は" + calcFactorial(inputNumber));
	}

	/**
	 * 階乗が算出されるまで、メソッドを再起呼び出しし続けます。
	 *
	 * @param inputNumber 入力した整数値
	 * @return 階乗
	 */
	public static long calcFactorial(long inputNumber) {
		if (inputNumber == 0) {
			return 1;
		}
		return calcFactorial(inputNumber - 1) * inputNumber;
	}
}