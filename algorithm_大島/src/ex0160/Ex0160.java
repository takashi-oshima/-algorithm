package ex0160;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力された 0~5 の範囲の 2 つの数字を元に、占いの結果を出力します。
 *
 * @author 大島
 */
public class Ex0160 {

	public static void main(String[] args) {
		// 入力した整数を格納する配列です。
		int[] inputNumbers = new int[2];

		// キーボード入力を受け付け、入力内容を配列に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("1 つ目の数字（0~5）：");
			inputNumbers[0] = scanner.nextInt();
			System.out.println("2 つ目の数字（0~5）：");
			inputNumbers[1] = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}
		// キーボードから入力された値を元に、占いの結果を出力します。
		switch (inputNumbers[0]) {
		case 0:
			switch (inputNumbers[1]) {
			case 0:
			case 1:
			case 5:
				System.out.println("占いの結果は吉です");
				break;
			default:
				System.out.println("占いの結果は凶です");
			}
			break;
		case 1:
			switch (inputNumbers[1]) {
			case 0:
			case 1:
			case 3:
			case 5:
				System.out.println("占いの結果は吉です");
				break;
			default:
				System.out.println("占いの結果は凶です");
			}
			break;
		case 2:
			switch (inputNumbers[1]) {
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("占いの結果は吉です");
				break;
			default:
				System.out.println("占いの結果は凶です");
			}
			break;
		case 3:
			switch (inputNumbers[1]) {
			case 1:
			case 2:
			case 3:
				System.out.println("占いの結果は吉です");
				break;
			default:
				System.out.println("占いの結果は凶です");
			}
			break;
		case 4:
			switch (inputNumbers[1]) {
			case 3:
			case 4:
				System.out.println("占いの結果は吉です");
				break;
			default:
				System.out.println("占いの結果は凶です");
			}
			break;
		case 5:
			switch (inputNumbers[1]) {
			case 1:
			case 2:
				System.out.println("占いの結果は吉です");
				break;
			default:
				System.out.println("占いの結果は凶です");
			}
			break;
		default:
			System.out.println("入力値が正しくありません。");
			break;
		}
	}
}