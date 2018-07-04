package ex0320;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 入力された値を階乗して返すクラスです
 *
 * @author 高井勇輝
 *
 */
public class Ex0320 {
	/** ループカウント用 */
	static int count = 0;

	public static void main(String[] args) {
		/** 階乗する数 */
		int inputValue = 0;
		/** 階乗した数 */
		long factorialValue = 0;

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//入力値を代入します。
			System.out.println("input number：");
			inputValue = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("不適な文字列です。整数を入力してください。");
			return;
		}
		if (inputValue < 0) {
			System.out.println("入力値が不正です。0以上で入力してください");
		}
		System.out.println(inputValue + "の階乗は" + multiply(inputValue, factorialValue) + "です。");
	}

	/**
	 * 入力値を階乗します。
	 *
	 * @param inputValue 入力値
	 * @return factorialValue 階乗値
	 */
	public static long multiply(int inputValue, long factorialValue) {
		if(count == 0) {
			factorialValue = 1;
		}
		if (inputValue == 0) {
			return 1;
		}
		if (inputValue > count) {
			count++;
			factorialValue = factorialValue * count;
			return multiply(inputValue, factorialValue);
		}
		return factorialValue;
	}
}