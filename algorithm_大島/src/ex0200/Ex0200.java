package ex0200;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから 1つの整数値 n を入力し、1 から n までの和を求め、結果を出力します。
 *
 * @author 大島
 */
public class Ex0200 {

	public static void main(String[] args) {
		// 入力した整数を格納する変数です。
		int inputNumber = 0;

		// キーボード入力を受け付け、入力内容を変数に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("input number：");
			inputNumber = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}
		// 1 から n までの和を求め、結果を出力します。
		int sum = 0;
		if (inputNumber < 0) {
			sum = (inputNumber * (inputNumber - 1)) / -2 + 1;
		} else {
			sum = (inputNumber * (inputNumber + 1)) / 2;
		}
		System.out.println(sum);
	}
}