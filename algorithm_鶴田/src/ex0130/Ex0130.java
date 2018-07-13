package ex0130;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 実行用クラスになります
 * キーボードから3つの整数値を入力し、最大値、 中央値 、平均値  (小数第3位を四捨五入 )を出力します
 *
 * @author 鶴田竜也
 */
public class Ex0130 {

	public static void main(String[] args) {
		// 入力ストリームを生成します
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		// 入力フォームを表示します
		System.out.println("input number1:");
		double number1 = scanner.nextDouble();
		System.out.println("input number2:");
		double number2 = scanner.nextDouble();
		System.out.println("input number3:");
		double number3 = scanner.nextDouble();
		System.out.println("input number4:");
		double number4 = scanner.nextDouble();
		double[] numbers = { number1, number2, number3, number4 };
		//合計値を求めます
		//合計値を0に初期化します
		double sum = 0;
		//データの個数だけ繰り返します
		for (int i = 0; i < numbers.length; i++) {
			//各値を足します
			sum += numbers[i];
		}

		//最大値を求めます
		// 最大値に最初の値を入れて初期化します
		double max = numbers[0];
		// 2つ目から最後まで繰り返します
		for (int i = 1; i < numbers.length; i++) {
			//もし最大値より値が大きければ
			if (max < numbers[i]) {
				//最大値を値で上書きします
				max = numbers[i];
			}
		}
		//小数点第2位まで出力します
		System.out.print("最大値 = " + String.format("%.2f", max) + "  ");

		//平均値を求めます
		double avarage = sum / numbers.length;
		//小数点第2位まで出力します
		System.out.print("平均値  = " + String.format("%.2f", avarage) + "  ");

		//中央値を求めます
		//配列numbersを昇順に並び替えます
		Arrays.sort(numbers);
		//奇数の場合
		if (numbers.length % 2 == 1) {
			//ローカル変数median
			double median = numbers[numbers.length / 2];
			System.out.println("中央値 = " + String.format("%.2f", median));

			//偶数の場合
		} else if (numbers.length % 2 == 0) {
			//真ん中の数字1つ目(右側)
			double middle1 = numbers[(numbers.length / 2)];
			//真ん中の数字2つ目（左側）
			double middle2 = numbers[(numbers.length / 2) - 1];
			//真ん中の数字2つの平均が中央値になります
			//ローカル変数median
			double median = (middle1 + middle2) / 2;
			System.out.println("中央値 = " + String.format("%.2f", median));
		}
	}
}