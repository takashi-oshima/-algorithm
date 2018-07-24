package awano.ex0140;

import java.util.Scanner;

/**
 * キーボードから2つの整数値とコマンドを入力し、
 * 計算結果を出力します
 * コマンドは、0:足し算、1:引き算、2:掛け算、その他:割り算の意味を持ちます
 *
 * @author 粟野真司
 */
public class Ex0140 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		double result = 0;
		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		// 入力フォームを表示します
		System.out.println("input number1:");
		double number1 = scanner.nextDouble();
		System.out.println("input number2:");
		double number2 = scanner.nextDouble();
		System.out.println("input command:");
		int command = scanner.nextInt();
		switch (command) {

		//コマンドに0が入力されたとき、足し算結果を出力します
		case 0:
			result = number1 + number2;
			break;

		//コマンドに1が入力されたとき、引き算結果を出力します
		case 1:
			result = number1 - number2;
			break;

		// コマンドに2が入力されたとき、掛け算結果を出力します
		case 2:
			result = number1 * number2;
			break;

		// コマンドに0,1,2以外が入力されたとき、割り算結果を出力します
		default:
			result = number1 / number2;
		}
		System.out.println("計算結果 = " + result);
	}
}