package ex0117;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 2つの試験の点数を基準に、進級可否、再試験の判定をします。
 *
 * @author 大島
 */
public class Ex0117 {

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

		int englishScore = inputNumbers[0];
		int mathScore = inputNumbers[1];
		String result = "";
		// 点数を基準に、進級可否、再試験の判定をします。
		if (englishScore < 0 || mathScore < 0 || englishScore > 100 || mathScore > 100) {
			result = "テスト結果が不正です。";
		} else if (englishScore >= 80 && mathScore >= 80) {
			result = "進級";
		} else if (englishScore < 80 && mathScore < 80) {
			result = "留年";
		} else {
			result = "再試験";
		}
		System.out.println(result);
	}
}