package takai.ex0255;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 月始まりの曜日番号と月末日を入力し、カレンダーを作成するクラスです。
 * 月始まりの曜日番号は以下の通りになります。
 * 日曜：0 月曜：1 火曜：2 水曜：3 木曜：4 金曜：5 土曜：6
 *
 * @author 高井勇輝
 *
 */
public class Ex0255 {

	public static void main(String[] args) {
		/** 一つ目の入力値 */
		int inputNumber1 = 0;
		/** 二つ目の入力値 */
		int inputNumber2 = 0;
		/** 日付設定用 */
		int day = 1;
		/** カレンダー作成用 */
		final String[][] MONTH = new String[6][7];

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//入力値をそれぞれに代入します。
			System.out.println("input number1：");
			inputNumber1 = scan.nextInt();
			System.out.println("input number2：");
			inputNumber2 = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("不適な文字列です。整数を入力してください。");
			return;
		}
		//不適な曜日でないかのチェック
		if (inputNumber1 < 0 || inputNumber1 > 6) {
			System.out.println("不適切な数値です。0～6で入力してください。");
			return;
		}
		//不適な月末日でないかのチェック
		if (inputNumber2 < 28 || inputNumber2 > 31) {
			System.out.println("不適な数値です。28～31で入力してください。");
			return;
		}

		//以下でカレンダーを作成し、出力します。
		System.out.println("日 月 火 水 木 金 土");
		System.out.println("---------------------");

		for (int i = 0; i < MONTH.length; i++) {
			for (int j = 0; j < MONTH[i].length; j++) {
				if (i == 0 && j < inputNumber1) {
					MONTH[i][j] = "  ";
				} else {
					MONTH[i][j] = String.format("%02d", day);
					day++;
				}
				System.out.print(MONTH[i][j] + " ");
				if (day == inputNumber2 + 1) {
					System.out.println();
					System.out.println("---------------------");
					return;
				}
			}
			System.out.println();
		}
	}
}