package ex0140;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから 2 つの整数値とコマンドを入力し、計算結果を出力します。 複数分岐(switch 文)を使用します。
 *
 * @author 大島
 */
public class Ex0140 {

	public static void main(String[] args) {
		// 入力した整数を格納する配列です。
		double[] inputNumbers = new double[2];
		int inputCommand = 0;

		// キーボード入力を受け付け、入力内容を配列に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("input number1：");
			inputNumbers[0] = scanner.nextDouble();
			System.out.println("input number2：");
			inputNumbers[1] = scanner.nextDouble();
			System.out.println("input number3：");
			inputCommand = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}

		// inputCommandの値によって、計算方法を選択します。
		String result = "";
		switch (inputCommand) {
		case 0:
			result = "計算結果 = " + (inputNumbers[0] + inputNumbers[1]);
			break;
		case 1:
			result = "計算結果 = " + (inputNumbers[0] - inputNumbers[1]);
			break;
		case 2:
			result = "計算結果 = " + (inputNumbers[0] * inputNumbers[1]);
			break;
		default:
			result = "計算結果 = " + (inputNumbers[0] / inputNumbers[1]);
		}
		System.out.println(result);
	}
}