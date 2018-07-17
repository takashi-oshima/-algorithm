package oshima.ex0130;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから 3 つの整数値を入力し、 最大値、中央値、平均値(小数第 3 位を四捨五入)を出力します。
 *
 * @author 大島
 */
public class Ex0130 {

	public static void main(String[] args) {
		// 入力した整数を格納する配列です。
		int[] inputNumbers = new int[3];

		// キーボード入力を受け付け、入力内容を配列に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("input number1：");
			inputNumbers[0] = scanner.nextInt();
			System.out.println("input number2：");
			inputNumbers[1] = scanner.nextInt();
			System.out.println("input number3：");
			inputNumbers[2] = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}

		// 計算結果を表示します。
		int max = maximumValue(inputNumbers);
		System.out.println("最大値 = " + max);
		int median = medianValue(inputNumbers);
		System.out.println("中央値 = " + median);
		double avg = averageValue(inputNumbers);
		System.out.print("平均値 = ");
		System.out.println(String.format("%.2f", avg));
	}

	/**
	 * 配列に格納されている整数の最大値を求めます。
	 *
	 * @param inputNumbers 整数が格納されている配列
	 * @return 最大値
	 */
	public static int maximumValue(int[] inputNumbers) {
		int max = 0;
		for (int value : inputNumbers) {
			if (max < value) {
				max = value;
			}
		}
		return max;
	}

	/**
	 * 配列に格納されている整数の中央値を求めます。
	 *
	 * @param inputNumbers 整数が格納されている配列
	 * @return 中央値
	 */
	public static int medianValue(int[] inputNumbers) {
		// 配列の数値を昇順にソートします。
		Arrays.sort(inputNumbers);
		int median = 0;

		if (inputNumbers.length % 2 == 1) {
			// 要素数が奇数の場合は真ん中の値を返します。
			median = inputNumbers[inputNumbers.length / 2];
			return median;
		} else {
			// 要素数が偶数の場合は真ん中2つの値の平均値を返します。
			median = (inputNumbers[inputNumbers.length / 2] + inputNumbers[inputNumbers.length / 2 - 1]) / 2;
			return median;
		}
	}

	/**
	 * 配列に格納されている整数の平均値を求めます。
	 *
	 * @param inputNumbers 整数が格納されている配列
	 * @return 平均値
	 */
	private static double averageValue(int[] inputNumbers) {
		// 配列に格納されている整数の合計値
		double sum = 0;
		for (double value : inputNumbers) {
			sum += value;
		}
		double avg = sum / inputNumbers.length;
		return avg;
	}
}