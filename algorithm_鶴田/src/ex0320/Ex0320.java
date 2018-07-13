package ex0320;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力された整数(16まで)の階乗値を出力します
 *　
 * @author 鶴田竜也
 */
public class Ex0320 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int inputNumber = 0;

		try {
			System.out.println("input number");
			inputNumber = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("正の整数を入力してください");
			return;
		}

		// マイナスの値を受け付けないようにします
		if (inputNumber < 0) {
			System.out.println("正数を入力してください");
			return;
		}
		// 13以上を入力した(結果の階乗値がint型の限界値を超える)場合の処理になります
		if(inputNumber > 12) {
			System.out.println("int型の限界値を超えています");
			return;
		}
		// 階乗の結果を出力します
		System.out.println(inputNumber + "の階乗は" + factrial(inputNumber) + "です");
	}

	/**
	 * 再帰処理(整数値nの階乗値の返却)を行います
	 *
	 * @param inputNumber 入力された数値
	 * @return 入力された数値の階乗値
	 */
	public static int factrial(int inputNumber) {

		if (inputNumber > 0) {
			return inputNumber * factrial(inputNumber - 1);
		} else {
			return 1;
		}
	}
}