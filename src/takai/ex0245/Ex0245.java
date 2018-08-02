package takai.ex0245;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 二つの入力値の最大公約数を求めるクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0245 {

	public static void main(String[] args) {
		/** 一つ目の入力値 */
		int inputNumber1 = 0;
		/** 二つ目の入力値 */
		int inputNumber2 = 0;
		/** 結果の格納用 */
		int result = 0;

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

		//1つ目と2つ目の入力値の大きいほうから小さいほうの値を引き、
		//等値になるまで繰り返す(ユークリッド互除法)
		while (!(inputNumber1 == inputNumber2)) {
			if (inputNumber1 < inputNumber2) {
				inputNumber2 -= inputNumber1;
			} else if (inputNumber1 > inputNumber2) {
				inputNumber1 -= inputNumber2;
			}
		}
		result = inputNumber1;
		System.out.println("最大公約数 =" + result);
	}
}