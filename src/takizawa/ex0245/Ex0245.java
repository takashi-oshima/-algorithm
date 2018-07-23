package takizawa.ex0245;

import java.util.Scanner;

/**
 * 2つの整数値を入力し、最大公約数を出力します
 *
 * @author 瀧澤
 */
public class Ex0245 {

	public static void main(String[] args) {
		String inputNumber1 = "";
		String inputNumber2 = "";
		int number1 = 0;
		int number2 = 0;

		// 入力処理とエラー処理を行います
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number1:");
		inputNumber1 = scanner.nextLine();
		if (inputNumber1 == "" || inputNumber1.isEmpty()) {
			System.out.println("\r\n文字列を確認できませんでした。\n"
					+ "処理を終了します");
			return;
		}
		System.out.println("input number2:");
		inputNumber2 = scanner.nextLine();
		if (inputNumber2 == "" || inputNumber2.isEmpty()) {
			System.out.println("\r\n文字列を確認できませんでした。\n"
					+ "処理を終了します");
			return;
		}
		try {
			number1 = Integer.parseInt(inputNumber1);
			number2 = Integer.parseInt(inputNumber2);
		} catch (NumberFormatException e) {
			System.out.println("\r\n数字以外が入力されました。\n"
					+ "処理を終了します");
			return;
		}
		if (number1 < 0 || number2 < 0) {
			System.out.println("\r\n負数が入力されました。\n"
					+ "正数を記入してください");
			return;
		}

		int max = Math.max(number1, number2);
		int min = Math.min(number1, number2);
		int remainder = 1;

		while (remainder != 0) {
			remainder = max % min;
			if (remainder == 0) {
				System.out.println("最大公約数 =" + min);
			}
			max = min;
			min = remainder;
		}

		// number1とnumber2の余りの数が0でない時に処理を続けます
		//		while (remainder != 0) {
		//
		//			//number1とnumber2を更新します
		//			number1 = number2;
		//			number2 = remainder;
		//		}
		//		// number2を最大公約数として結果を表示します
		//		System.out.println("最大公約数 =" + number2);
	}
}