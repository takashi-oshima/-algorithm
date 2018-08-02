package takai.ex0116;

import java.util.Scanner;

/**
 * ２つの数値を偶数か奇数かを判定し、結果を表示するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0116 {

	public static void main(String[] args) {
		/** 一つ目の文字列 */
		String inputTxt1 = "";
		/** 二つ目の文字列 */
		String inputTxt2 = "";

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		//入力値をそれぞれに代入します。
		System.out.println("整数を2つ入力してください");
		System.out.println("input number1：");
		inputTxt1 = scan.nextLine();
		System.out.println("input number2：");
		inputTxt2 = scan.nextLine();

		//NULL・空文字チェック
		if (inputTxt1 == null || inputTxt1.isEmpty()) {
			System.out.println("i1が空白、もしくはnull値になっています");
			return;
		}
		if (inputTxt2 == null || inputTxt2.isEmpty()) {
			System.out.println("i2が空白、もしくはnull値になっています");
			return;
		}
		System.out.println(numberDecision(inputTxt1, inputTxt2));
	}

	/**
	 * それぞれの入力値が整数であれば偶数か奇数かを判定し、その結果を返します。
	 *
	 * @param inputTxt1 入力された文字列1
	 * @param inputTxt2 入力された文字列2
	 * @return 判定結果の文字列を返します
	 */
	private static String numberDecision(String inputTxt1, String inputTxt2) {
		try {
			int inputNumber1 = Integer.parseInt(inputTxt1);
			int inputNumber2 = Integer.parseInt(inputTxt2);

			if (inputNumber1 % 2 == 0 && inputNumber2 % 2 == 0) {
				return "2つの値ともに偶数です";
			} else if (inputNumber1 % 2 == 0 && inputNumber2 % 2 == 1) {
				return "i1は偶数です。i2は奇数です";
			} else if (inputNumber1 % 2 == 1 && inputNumber2 % 2 == 0) {
				return "i1は奇数です。i2は偶数です";
			} else {
				return "2つの値ともに奇数です";
			}
		} catch (NumberFormatException e) {
			return "整数以外のものが入力されています。";
		}
	}
}