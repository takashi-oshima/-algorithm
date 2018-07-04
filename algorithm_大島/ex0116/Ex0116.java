package ex0116;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 2つの整数値 i1、i2 を入力します。 i1、i2がそれぞれ偶数、奇数の場合で表示文を変更します。
 *
 * @author 大島
 */
public class Ex0116 {

	public static void main(String[] args) {
		// 入力した整数を格納する配列です。
		int[] inputNumbers = new int[2];
		// キーボード入力を受け付け、入力内容を配列に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("input number1：");
			inputNumbers[0] = scanner.nextInt();
			System.out.println("input number2：");
			inputNumbers[1] = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}

		int i1 = inputNumbers[0];
		int i2 = inputNumbers[1];
		String result = "";
		// i1、i2がそれぞれ偶数、奇数の場合で表示文を変更します。
		if (i1 % 2 == 0 && i2 % 2 == 0) {
			result = "2つの値ともに偶数です";
		} else if (i1 % 2 == 1 && i2 % 2 == 0) {
			result = "i1 は奇数です。i2 は偶数です";
		} else if (i1 % 2 == 0 && i2 % 2 == 1) {
			result = "i1 は偶数です。i2 は奇数です";
		} else {
			result = "2つの値ともに奇数です";
		}
		System.out.println(result);
	}

}