package tsuruta.ex0240;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 2桁の数字を入力すると、九九の表に値があるかどうか出力します
 *
 * @author 鶴田竜也
 */
public class Ex0240 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("input number");

		int inputNumber = 0;
		try {
			inputNumber = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
		}

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				// 掛け算の結果が2桁の場合
				if (inputNumber == i * j) {
					System.out.println("九九の表(" + (i + "*" + j + ")にあります。"));
					// 入力された数字が九九以外の場合
				} else if ( inputNumber < 10 && inputNumber > 0 || inputNumber >= 100) {
					System.out.println("九九の表にありません");
					return;
				}
			}
		}
	}
}