package ex0130;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから３つの整数値を入力し、
 * 最大値、中央値、平均値（小数第3位を四捨五入）を出力します
 *
 * @author 小金井 広輝
 */
public class Ex0130 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		final int COUNT = 3;
		//入力された数字の取得用配列
		double[] inputInt = new double[COUNT];

		//キーボードから入力された文字列を取得します
		try {
			for (int i = 0; i < inputInt.length; i++) {
				System.out.println("input number" + (i + 1) + ":");
				inputInt[i] = scanner.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//最大値、中央値、平均値を求めます
		double max = getMax(inputInt);
		double median = getMedian(inputInt);
		double average = getAverage(inputInt);

		//結果を表示します
		System.out.println("最大値=" + max + "  中央値=" + median + "  平均値=" + average);
	}

	/**
	 * 最大値を求め結果を返します
	 *
	 * @param inputInt 入力された数字配列
	 * @return 最大値
	 */
	public static double getMax(double[] inputInt) {
		double max;
		Arrays.sort(inputInt);
		max = inputInt[inputInt.length - 1];
		return max;
	}

	/**
	 * 平均値を求め結果を返します
	 *
	 * @param inputInt 入力された数字配列
	 * @return 平均値
	 */
	public static double getAverage(double[] inputInt) {
		double total = 0;
		double average = 0;
		for (int i = 0; i < inputInt.length; i++) {
			total = total + inputInt[i];
		}
		average = total / inputInt.length;
		return average;
	}

	/**
	 * 中央値を求め結果を返します
	 *
	 * @param inputInt 入力された数字配列
	 * @return 中央値
	 */
	public static double getMedian(double[] inputInt) {
		double median;
		Arrays.sort(inputInt);
		median = inputInt[1];
		return median;
	}
}
