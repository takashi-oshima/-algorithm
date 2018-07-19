package oshima.ex0215;

import java.util.Scanner;

/**
 * キーボードから複数の数字を入力し、足して 10 になる 2 つの数値をペアとして出力します。
 *
 * @author 大島
 */
public class Ex0215 {

	public static void main(String[] args) {
		// 入力した文字列を格納する変数です。
		String inputString = "";
		// 足して10になるペアが存在するかどうかを判定します。
		boolean flag = false;

		// キーボード入力を受け付け、入力内容を変数に格納します。
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number：");
		inputString = scanner.nextLine();

		// 入力した文字列を半角空白で区切り、配列に格納します。
		String[] characterStrings = inputString.split("[\\s]+", -1);

		// nullと空文字チェックします。
		for (String string : characterStrings) {
			if (string == null || string.isEmpty()) {
				System.out.println("文字列がnullまたは空文字です。");
				return;
			}
		}
		// 配列に格納されている文字列をInteger型に変換します。
		int[] inputNumber = new int[characterStrings.length];
		for (int i = 0; i < characterStrings.length; i++) {
			try {
				inputNumber[i] = Integer.parseInt(characterStrings[i]);
			} catch (NumberFormatException e) {
				System.out.println("入力値が不正です。");
				return;
			}
		}
		// 足して 10 になる 2 つの数値をペアとして出力します。
		int result = 0;
		for (int i = 0; i < inputNumber.length - 1; i++) {
			for (int j = i + 1; j < inputNumber.length; j++) {
				result = inputNumber[i] + inputNumber[j];
				if (result == 10) {
					flag = true;
					System.out.print(inputNumber[i] + " と " + inputNumber[j] + "、");
				}
			}
		}
		if (flag == true) {
			System.out.println("は足して10となるペアです。");
		} else {
			System.out.println("ペアとなる数字はありません。");
		}
	}
}