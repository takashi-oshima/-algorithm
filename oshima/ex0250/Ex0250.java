package oshima.ex0250;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから 2 桁の数値を入力し,その数値が 100 以下の素数か判断し出力します。
 * 数値が素数か否かの判断は,100以下の素数を要素に持つ配列の中から二分探索を使用して行います。
 *
 * @author 大島
 */
public class Ex0250 {

	public static void main(String[] args) {
		// 100以下の素数を要素に持つ配列を設定します。
		final int[] PRIME_NUMBERS = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
				79, 83, 89, 97 };
		// 入力された値が素数かどうかを判定します。
		boolean flag = false;
		// 配列をソートします。
		Arrays.sort(PRIME_NUMBERS);
		// 入力した整数を格納する配列です。
		int inputNumber = 0;

		// キーボード入力を受け付け,入力内容を配列に格納します。
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

		// 二分探索の下限と上限を設定します。
		int low = 0;
		int high = PRIME_NUMBERS.length - 1;
		// 二分探索を行います。
		while (low <= high) {
			int mid = (high + low) / 2;
			if (PRIME_NUMBERS[mid] == inputNumber) {
				flag = true;
				break;
			} else if ((PRIME_NUMBERS[mid] > inputNumber)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}if(flag == true) {
			System.out.println("素数です。");
		}else
		System.out.println("素数ではありません。");
	}
}