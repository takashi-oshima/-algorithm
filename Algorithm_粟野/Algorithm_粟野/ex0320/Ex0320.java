package algorithm.ex0320;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力した整数値nの階乗を計算して出力します
 * 今回は、再帰呼び出しで作成します
 *
 * @author 粟野真司
 */
public class Ex0320 {
	/**
	 * 入力された値の階乗計算結果を求めます
	 *
	 * @param inputNumber 入力された数値
	 * @return 階乗の計算結果
	 */
	public static int getFactorial(int inputNumber) {
		// 数値が0より大きければ、階乗計算結果を返します
		if (inputNumber > 0) {
			return inputNumber * getFactorial(inputNumber - 1);
			// そうでなければ、1を返します
		} else {
			return 1;
		}
	}

	/**
	 * メインメソッドです
	 * 数値入力を受け付け、階乗の計算結果を表示します
	 */
	public static void main(String[] args) {
		// 入力した数値を格納するための変数を宣言します
		int inputNumber;
		@SuppressWarnings("resource")
		// 入力ストリームを生成します
		Scanner scan = new Scanner(System.in);
		// 入力フォームを表示します
		System.out.println("input Number");

		try {
			// 入力された数値を変数に格納します
			inputNumber = scan.nextInt();
			// 入力された数値が負数でないか、確認します
			if (inputNumber < 0) {
				System.out.println("正数を入力してください。");
				return;
			}
		} catch (InputMismatchException e) {
			System.out.println("不正な文字列が入力されています。整数を入力してください。");
			return;
		}
		System.out.println(inputNumber + "の階乗は" + getFactorial(inputNumber) + "です。");
	}
}