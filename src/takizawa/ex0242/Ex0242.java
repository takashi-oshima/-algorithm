package takizawa.ex0242;

import java.util.Scanner;

/**
 * 整数値を入力し、その行数分の三角形を出力します
 *
 * @author 瀧澤
 */
public class Ex0242 {

	public static void main(String[] args) {
		String inputNumber = "";
		int number = 0;

		// 入力処理の準備
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number:");
		inputNumber = scanner.nextLine();

		// nullと空文字チェック
		if (inputNumber == null || inputNumber.isEmpty()) {
			System.out.println("\r\n数字が確認できませんでした。\n"
					+ "処理を終了します");
			return;
		}
		try {
			//inputNumberをnumberに直し、各エラー処理を行う
			number = Integer.parseInt(inputNumber);
		} catch (NumberFormatException e) {
			System.out.println("\r\n数字以外が入力されました。\n"
					+ "処理を終了します");
			return;
		}
		if (number < 0) {
			System.out.println("\r\n負数が入力されました\n"
					+ "処理を終了します");
			return;
		}

		System.out.println("\r\n");
		// 入力した数字分の行数を表示する
		for (int i = 1; i <= number; i++) {

			// 左側の空白を表示する
			for (int j = number; j > i; j--) {
				System.out.print(" ");
			}

			// 行数に比例する列を、*で表示する
			for (int k = 1; k <= i; k++) {
				System.out.print('*');
			}
			// 2行目から行数に比例する列を、*で表示する
			for (int l = 0; l < i - 1; l++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}