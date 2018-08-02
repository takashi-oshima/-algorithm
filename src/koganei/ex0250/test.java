package koganei.ex0250;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから2桁の数字を入力し、その数値が素数か判断(二分探索法を使用)し、出力します
 *
 * @author 鶴田竜也
 */
public class test {

	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int inputInt;

		//キーボードから入力された整数を取得します
		System.out.println("input number：");
		try {
			inputInt = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 49, 53, 59, 61, 67, 71, 73, 77, 79, 83,
				89, 91, 97 };

		//配列の先頭、末尾、真ん中の要素をそれぞれ格納します
		int head = 0;
		int tail = prime.length - 1;
		int center = 0;

		while (head <= tail) {
			//
			center = (head + tail) / 2;

			//入力した数字がcenterと一致すれば
			if (inputInt == prime[center]) {
				System.out.println("素数です");
				return;
				//入力した値が配列の真ん中
			} else if (inputInt < prime[center]) {
				tail = center - 1;

			} else if (inputInt > prime[center]) {
				head = center + 1;
			}
		}
		System.out.println("NO");
	}
}