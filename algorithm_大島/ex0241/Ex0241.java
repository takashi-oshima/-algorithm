package ex0241;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 整数値を入力し、その行数分直角三角形を出力します。
 *
 * @author 大島
 */
public class Ex0241 {

	public static void main(String[] args) {
		// 入力した整数を格納する変数です。
		int inputNumber = 0;

		// キーボード入力を受け付け、入力内容を変数に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("input number：");
			inputNumber = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}
		// 入力値に応じて直角三角形を出力します。
		for (int i = 0; i < inputNumber; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		// 入力値がマイナス値であった場合、逆順に直角三角形を出力します。
		for (int i = 0; i > inputNumber; i--) {
			for (int j = 0; j > inputNumber - i; j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}