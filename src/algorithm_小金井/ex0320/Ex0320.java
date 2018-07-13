package ex0320;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力した整数値ｎの階乗を再起呼び出しで計算して出力します
 *
 * @author 小金井 広輝
 */
public class Ex0320 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int inputInt;

		//キーボードから入力された整数を取得します。
		System.out.println("input number：");
		try {
			inputInt = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//入力された数字が範囲内（10～99）かの判別を行います
		if (inputInt < 0) {
			System.out.println("正数を入力してください");
			return;
		}
		//再起呼び出しで階乗を計算し結果を取得します
		int ans = getFactorial(inputInt);
		//結果を表示します
		System.out.println(inputInt + "の階乗は" + ans + "です");
	}

	/**
	 * 再起呼び出しで階乗を計算し結果を返します
	 *
	 * @param inputInt 入力された数字から1までの連続する自然数
	 * @return inputInt×inputInt!の結果
	 */
	public static int getFactorial(int inputInt) {
		if (inputInt == 0) {
			return 1;
		} else {
			return inputInt * getFactorial(inputInt - 1);
		}
	}
}
