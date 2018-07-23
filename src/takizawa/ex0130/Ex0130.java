package takizawa.ex0130;

import java.util.Scanner;

/**
 * 整数を3つ入力して、最大値・中央値・平均値
 * を求めます
 *
 * @author 瀧澤
 */
public class Ex0130 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number1:");
		//maxNumberに整数を読み込む
		int maxNumber = scanner.nextInt();
		System.out.println("input number2:");
		//medianに整数を読み込む
		int median = scanner.nextInt();
		System.out.println("input number3:");
		//averageに整数を読み込む
		int average = scanner.nextInt();

		int values[] = { maxNumber, median, average };
		int max = values[0];
		//配列の先頭から調べて最大値を探し出します
		for (int i = 1; i < values.length; i++) {
			max = Math.max(max, values[i]);
		}
		System.out.print("\r\n最大値 = " + max);
		//中央値を算出します
		System.out.print(" " + "中央値 =" + values[(values.length / 2) +1]);
		//平均値を算出します
		double sum = 0;
		for(int i = 0;i < values.length;i++) {
			sum += values[i];
		}
		double ave = sum / values.length;
		System.out.println(" " + "平均値 =" + String.format("%.2f", ave));
	}
}