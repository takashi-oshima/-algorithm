package takizawa.ex0241;

import java.util.Scanner;

/**
 * 整数値を入力し、その行数分の左下直角三角形を出力します
 *
 * @author 瀧澤
 */
public class Ex0241 {

	public static void main(String[] args) {
		String inputNumber = " ";
		int number = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number:");
		// 文字列の入力処理を受け付ける
		inputNumber = scanner.nextLine();

		// 文字列がnull,空文字だった場合の処理
		if (inputNumber == null || inputNumber.isEmpty()) {
			System.out.println("\r\n数字が確認できませんでした\n" +
					"処理を終了します");
			return;
		}
		try {
			// inputNumberをint型に直して負数チェックをする
			number = Integer.parseInt(inputNumber);
			if (number < 0) {
				System.out.println("\r\n負数が入力されました\n"
						+ "処理を終了します");
			}
			// try-catchで数字以外の入力をチェックする
		} catch (NumberFormatException e) {
			System.out.println("\r\n数字以外が入力されました\n"
					+ "処理を終了します");
			return;
		}

		System.out.println("\r\n");
		// 通常forを使い、number分の行数を出力します
		for (int i = 1; i <= number; i++) {
			// 行数に比例する列を、*で出力します
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			// 改行処理
			System.out.println();
		}
	}
}