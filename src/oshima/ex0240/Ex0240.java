package oshima.ex0240;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 2 桁の数字を入力すると、九九の表に値があるかどうか出力します。
 *
 * @author 大島
 */
public class Ex0240 {

	public static void main(String[] args) {
		// 入力した整数を格納する変数です。
		int inputNumber = 0;
		// 入力値が九九表にあるかどうかを判定します。
		boolean flag = false;

		// キーボード入力を受け付け、入力内容を変数に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("2桁の範囲の数字：");
			inputNumber = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}
		if (inputNumber < 10 || inputNumber > 99) {
			System.out.println("指定された範囲の数字ではありません。");
			return;
		}

		// 九九の計算をし、入力した値と一致するかを確認します。
		int result = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				result = (i * j);
				if (inputNumber == result) {
					flag = true;
					System.out.println("九九の表（" + i + " * " + j + "）にあります。");
				}
			}
		}
		if (flag == false) {
			System.out.println("九九の表にありません。");
		}
	}
}