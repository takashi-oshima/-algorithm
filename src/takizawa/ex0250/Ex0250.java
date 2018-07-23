package takizawa.ex0250;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ２桁の数値を入力し、その数値が100以下の素数か判断し出力します
 *
 * @author 瀧澤舞香
 */
public class Ex0250 {

	public static void main(String[] args) {
		String inputNumber = "";
		int number = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number:");
		inputNumber = scanner.nextLine();
		if (inputNumber == null || inputNumber.isEmpty()) {
			System.out.println("\r\n数字を確認できませんでした。"
					+ "\n処理を終了します");
			return;
		}
		if (!(inputNumber.length() == 2)) {
			System.out.println("\r\n範囲外の数字が入力されました。\n"
					+ "処理を終了します");
			return;
		}
		try {
			number = Integer.parseInt(inputNumber);
		} catch (NumberFormatException e) {
			System.out.println("\r\n数字以外が入力されました。\n"
					+ "処理を終了します");
			return;
		}
		if (number < 0) {
			System.out.println("\r\n負数が入力されました。"
					+ "\n処理を終了します");
			return;
		}

		// 素数格納用primeを用意
		List<Integer> prime = new ArrayList<>();

		int min = 0;
		int max = 100;

		// 1とその数字でしか割ることのできない数字（素数）を探します
		for (int i = min; i <= max; i++) {
			int j = 0;
			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (i == j) {
				prime.add(i);
			}
		}

		int n = prime.size();
		int left = 0;
		int right = n - 1;
		int middle = (left + right) / 2;

		// 探索する左側の数字が右側の数字を超すまで続けます
		while (left <= right) {
			if (prime.get(middle) <= number) {
				left = middle + 1;
				middle = (left + right) / 2;
			} else if (prime.get(middle) > number) {
				right = middle - 1;
				middle = (left + right) / 2;
			}
		}

		// リストprimeの真ん中と入力文字を比べる
		if (prime.get(middle) != number) {
			System.out.println("\r\n素数ではありません");
		} else {
			System.out.println("\r\n素数です");
		}
	}
}