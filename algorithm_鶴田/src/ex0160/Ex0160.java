package ex0160;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力された0～5の範囲の２つの数字をもとに占いの結果を出力します。
 * @author 鶴田竜也
 */
public class Ex0160 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int inputNumber1 = 0;
		int inputNumber2 = 0;
		System.out.println("文字列：");
		System.out.println("1つ目の数字（0～5）");
		try {
			inputNumber1 = scan.nextInt();
			System.out.println("2つ目の数字（0～5）");
			inputNumber2 = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字以外を入力しないでください");
		}
		if (inputNumber1 < 0 || inputNumber1 > 5 || inputNumber2 < 0 || inputNumber2 > 5) {
			System.out.println("0から5までの数字を入力してください");
		}

		//二次元配列に占いの結果を入れます
		String[][] array = {
				{ "吉", "吉", "凶", "凶", "凶", "吉" },
				{ "吉", "吉", "凶", "吉", "凶", "吉" },
				{ "凶", "凶", "吉", "吉", "吉", "吉" },
				{ "凶", "吉", "吉", "吉", "凶", "凶" },
				{ "凶", "凶", "凶", "吉", "吉", "凶" },
				{ "凶", "吉", "吉", "凶", "凶", "凶" } };
		System.out.println("占いの結果は" + array[inputNumber1][inputNumber2] + "です");
	}
}