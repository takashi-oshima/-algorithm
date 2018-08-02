package awano.ex0130;

import java.util.Scanner;

/**
 * キーボードから3つの整数値を入力し、
 * 最大値、中央値、平均値(小数第3位を四捨五入)を出力します
 *
 * @author 粟野真司
 */
public class Ex0130 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		// 入力フォームを表示します
		System.out.println("input number1:");
		double number1 = scanner.nextDouble();
		System.out.println("input number2:");
		double number2 = scanner.nextDouble();
		System.out.println("input number3:");
		double number3 = scanner.nextDouble();

		// 入力された数値を配列に格納します
		double[] numbers = { number1, number2, number3 };

		// 入力された3つの数値の最大値、中央値、平均値を出力します
		System.out.print("最大値 =" + String.format("%.2f", getMax(numbers)) + "  ");
		System.out.print("中央値 = " + String.format("%.2f", getMiddle(numbers)) + "  ");
		System.out.print("平均値 = " + String.format("%.2f", getAverage(numbers)) + "  ");
	}

	/**
	 * numbers配列の中で最大値を取得します
	 *
	 * @param numbers
	 * @return  max 最大値を返します
	 */
	public static double getMax(double[] numbers) {
		double max = 0;
		for (int i = 0; i < numbers.length; i++) {
			max = Math.max(max, numbers[i]);
		}
		return max;
	}

	/**
	 * numbers配列の中で中央値を返します
	 *
	 * @param numbers
	 * @return middle 中央値を返します
	 */
	public static double getMiddle(double[] numbers) {

		for (int i = 0; i < numbers.length - 1; i++) {
			// 比較元の1つ次の要素から最後の要素までを比較します
			for (int j = i + 1; j < numbers.length; j++) {
				// 比較元の要素より大きいものがあれば内容を交換します
				if (numbers[j] > numbers[i]) {
					double temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

		// 要素数が奇数か偶数かをチェックします
		if (numbers.length % 2 == 1) {
			// 要素数が奇数の場合は真ん中の値を返します
			return numbers[numbers.length / 2];
		} else {
			// 要素数が偶数の場合は真ん中2つの値の平均値を返します
			return (numbers[numbers.length / 2] + numbers[numbers.length / 2 - 1]) / 2;
		}
	}

	/**
	 * numbers配列の中で平均値を取得します
	 *
	 * @param numbers
	 * @return average 平均値
	 */
	public static double getAverage(double[] numbers) {
		double sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum / numbers.length;
	}
}
