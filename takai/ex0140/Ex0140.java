package takai.ex0140;

import java.util.Scanner;

/**
 * コマンドによって、四則演算を切り替えて計算するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0140 {

	public static void main(String[] args) {
		/** 1つ目の文字列 */
		double inputNumber1 = 0;
		/** 2つ目の文字列 */
		double inputNumber2 = 0;
		/** コマンド */
		int command = 0;
		/** 計算結果を格納 */
		double calculationResult = 0;

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//入力値をそれぞれに代入します。
			System.out.println("input number1：");
			inputNumber1 = scan.nextDouble();
			System.out.println("input number2：");
			inputNumber2 = scan.nextDouble();
			System.out.println("input command：");
			command = scan.nextInt();
		} catch (NumberFormatException e) {
			System.out.println("不適な文字列です。整数を入力してください。");
			return;
		}

		//コマンドによって計算式を変化させます。
		switch (command) {
		case 0:
			calculationResult = inputNumber1 + inputNumber2;
			break;
		case 1:
			calculationResult = inputNumber1 - inputNumber2;
			break;
		case 2:
			calculationResult = inputNumber1 * inputNumber2;
			break;
		default:
			calculationResult = inputNumber1 / inputNumber2;
		}
		System.out.println("計算結果 = " + calculationResult);
	}
}