package takai.ex0130;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 3つの数値から最大値、中央値、平均値を算出するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0130 {

	public static void main(String[] args) {
		/** 1つ目の文字列 */
		int inputNumber1 = 0;
		/** 2つ目の文字列 */
		int inputNumber2 = 0;
		/** 3つ目の文字列 */
		int inputNumber3 = 0;

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//入力値をそれぞれに代入します。
			System.out.println("input number1：");
			inputNumber1 = Integer.parseInt(scan.nextLine());
			System.out.println("input number2：");
			inputNumber2 = Integer.parseInt(scan.nextLine());
			System.out.println("input number3：");
			inputNumber3 = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("不適な文字列が入力されています。整数を入力してください。");
			return;
		}

		System.out.println(valueDecision(inputNumber1, inputNumber2, inputNumber3));
	}

	/**
	 * 入力された数値をint型に変換してListに格納し、昇順にソートします。
	 *
	 * @param inputNumber1 入力値1
	 * @param inputNumber2 入力値2
	 * @param inputNumber3 入力値3
	 * @return mainメソッドの出力文字列
	 */
	private static String valueDecision(int inputNumber1, int inputNumber2, int inputNumber3) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(inputNumber1);
		numbers.add(inputNumber2);
		numbers.add(inputNumber3);

		for (int i = 0; i < numbers.size() - 1; i++) {
			for (int j = i + 1; j < numbers.size(); j++) {
				if (numbers.get(i) > numbers.get(j)) {
					int tmp = numbers.get(i);
					numbers.set(i, numbers.get(j));
					numbers.set(j, tmp);
				}
			}
		}
		return "最大値 = " + determineMaxValue(numbers) + "　中央値 = " + determineMedian(numbers) + "　平均値 = "
				+ determineAvg(numbers);
	}

	/**
	 * Listの中の最大値を返します
	 *
	 * @param numbers ソートされた入力値を格納したList
	 * @return maxValue 最大値
	 */
	private static int determineMaxValue(List<Integer> numbers) {
		int maxValue = numbers.get(numbers.size() - 1);
		return maxValue;
	}

	/**
	 * Listの中央値を返します
	 *
	 * @param numbers ソートされた入力値を格納したList
	 * @return median 中央値
	 */
	private static int determineMedian(List<Integer> numbers) {
		int median = 0;

		if (numbers.size() % 2 == 0) {
			median = numbers.get((numbers.size() / 2) + 1);
		} else {
			median = numbers.get(numbers.size() / 2);
		}
		return median;
	}

	/**
	 * Listの平均値を返します。
	 *
	 * @param numbers ソートされた入力値を格納したList
	 * @return avg 平均値
	 */
	private static String determineAvg(List<Integer> numbers) {
		double avg = 0;
		double total = 0;

		for (Integer number : numbers) {
			total += number;
		}
		avg = total / numbers.size();
		return String.format("%.2f", avg);
	}
}