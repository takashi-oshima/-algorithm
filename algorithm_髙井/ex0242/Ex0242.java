package ex0242;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 入力された整数値分の行数の二等辺三角形を出力します。
 *
 * @author 高井勇輝
 *
 */
public class Ex0242 {

	public static void main(String[] args) {
		/** 出力する行数 */
		int inputNumber = 0;

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//入力値を代入します。
			System.out.println("input number：");
			inputNumber = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("不適な文字列です。整数を入力してください。");
			return;
		}
		if (inputNumber < 0) {
			//入力値がマイナスの時、下向きの二等辺三角形を出力します。
			for (int i = 0; i < inputNumber * -1; i++) {
				for (int j = 1; j < i + 1; j++)
					System.out.print(" ");
				for (int j = 1; j < ((inputNumber * -1) - i) * 2; j++)
					System.out.print("*");
				System.out.println();
			}
		} else {
			//上向きの二等辺三角形を出力します。
			for (int i = 1; i <= inputNumber; i++) {
				for (int j = 1; j <= inputNumber - i; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= 2 * i - 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}
