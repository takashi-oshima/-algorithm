package tsuruta.ex0250;

import java.util.Scanner;

/**
 * キーボードから2桁の数字を入力し、その数値が素数か判断(二分探索法を使用)し、出力します
 *
 * @author 鶴田竜也
 */
public class Ex0250 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String inputString;

		int inputInt = 0;

		System.out.println("input number：");
		try {
			// キーボードから入力された整数を取得し、Integer型に変換します
			inputString = scanner.nextLine();
			inputInt = Integer.parseInt(inputString);
		} catch (NumberFormatException e) {
			System.out.println("数字を入力してください");
			return;
		}

		// 2桁以外の値を受け付けないようにします。digitsは文字列の桁数（2桁）を表します
		int digits = 2;
		if (inputString.length() != digits) {
			System.out.println("2桁の数字を入力してください");
			return;
		}
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 49, 53, 59, 61, 67, 71, 73, 77, 79, 83,
				89, 91, 97 };

		// 配列の先頭、末尾、真ん中の要素をそれぞれ格納します
		int head = 0;
		int tail = prime.length - 1;
		int center = 0;

		// 二分探索を行ないます
		while (head <= tail) {
			center = (head + tail) / 2;

			if (inputInt == prime[center]) {
				// 入力した数字がcenterと一致すれば
				System.out.println("素数です");
				return;

			} else if (inputInt < prime[center]) {
				// 入力した値が配列の真ん中より前にある場合、
				// 中央より前の探索を繰り返します
				tail = center - 1;

			} else if (inputInt > prime[center]) {
				// 入力した値が配列の真ん中より後ろにある場合
				// 中央より後の探索を繰り返します
				head = center + 1;
			}
		}

		// 入力された値が素数でなかった場合(while文を抜けた場合)
		System.out.println("素数ではありません");
	}
}