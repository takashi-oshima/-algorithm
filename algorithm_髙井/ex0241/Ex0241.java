package ex0241;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 入力された整数値分の行数の直角三角形を出力します。
 *
 * @author 高井勇輝
 *
 */
public class Ex0241 {

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
			//入力値がマイナスの時、右上直角三角形を出力します。
			for (int i = 0 ; i < (inputNumber * -1); i++) {
				for (int j = (inputNumber * -1) -i ; j > 0; j--) {
					System.out.print("*");
				}
				System.out.println("");
			}
		} else {
			//左下直角三角形を出力します。
			for (int i = 1; i < inputNumber + 1; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		}
	}
}