package oshima.ex0245;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから 2つの整数値を入力し、最大公約数を出力します。
 *
 * @author 大島
 */
public class Ex0245 {

	public static void main(String[] args) {
		// 入力した整数を格納する配列です。
		Integer[] inputNumbers = new Integer[2];

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
		// 配列の数値を降順にソートします。
		Arrays.sort(inputNumbers, Collections.reverseOrder());
		int bigNumber = inputNumbers[0];
		int smallNumber = inputNumbers[1];

		// 最大公約数を計算するメソッドを呼び出し、結果を表示します。
		System.out.println("\r\n最大公約数 = " + calcCommonDivisor(bigNumber, smallNumber));
	}

	/**
	 * 最大公約数が算出されるまで、メソッドを再帰呼び出しし続けます。
	 *
	 * @param bigNumber 入力された数値の大きい方
	 * @param smallNumber 入力された数値の小さい方
	 * @return 公約数
	 */
	public static int calcCommonDivisor(int bigNumber, int smallNumber) {
		if (smallNumber == 0) {
			return bigNumber;
		}
		return calcCommonDivisor(smallNumber, bigNumber % smallNumber);
	}
}