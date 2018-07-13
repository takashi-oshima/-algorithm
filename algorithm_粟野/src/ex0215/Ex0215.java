package algorithm.ex0215;

import java.util.Scanner;

/**
 * キーボードから複数の数字を入力し、
 * 足して10になる２つの数値をペアとして出力します
 *
 * @author 粟野真司
 */
public class Ex0215 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		// 入力フォームを表示します
		System.out.println("input number:");
		String number = scanner.nextLine();

		// 入力された文字列が空文字かどうか判定する
		if (number.isEmpty() || number == null) {
			System.out.println("複数の数字が入力されておりません。");
			return;
		}

		// 配列に格納されいる複数の数値の中で
		// 2数を足して10になるペアとなる数値が含まれているかどうかのための変数を宣言します
		boolean judgement = false;

		// 入力された値を配列に格納します
		String[] numbers = { number };

		// 文字列内の半角空白で単語に分解し、配列に格納します
		numbers = number.split(" ");

		//int型の配列にnumbers配列の要素数を取得します
		int[] inputNumbers = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			try {
				// String型の配列要素をint型の配列要素に変換します
				inputNumbers[i] = Integer.parseInt(numbers[i]);
			} catch (NumberFormatException e) {
				System.out.println("入力値が不正です。複数の数値を入力してください。");
				return;
			}
		}
		// 配列の2つの要素を足すと、resultになるための変数を宣言します
		int result = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				result = inputNumbers[i] + inputNumbers[j];

				// 2数を足して10になるペアとなる数値が配列に含まれているかどうか判定します
				if (result == 10) {
					System.out.println(inputNumbers[i] + "と" + inputNumbers[j] + "は足して10となるペアです");
					judgement = true;
				}
			}
		}
		if (judgement == false) {
			System.out.println("ペアとなる数字はありません");
		}
	}
}