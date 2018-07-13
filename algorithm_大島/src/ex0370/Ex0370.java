package ex0370;

import java.util.Scanner;

/**
 * 起動時引数として正解の 4 桁の数字を与えます。 999 を入力してギブアップするか、正解を入力するまで予想数字の入力と当たり判定の結果を出力し続けます。
 * ヒット：位置も数字も一致している数 ブロー：位置は一致していないが、数字が一致している数
 *
 * @author 大島
 */
public class Ex0370 {

	// ギブアップするときの入力値です。
	public static final String GIVEUP = "999";

	public static void main(String[] args) {
		String answer = "";

		// コマンドライン引数に設定されている値を確認します。
		if (args.length > 0 && args[0].matches("[0-9]{4}")) {
			answer = args[0];
		} else {
			System.out.println("答えには半角数字で4つの数字を設定してください。");
			return;
		}

		// 正解か999が入力されるまでカウント数を保持したままループ処理します。
		int tryCount = 0;
		while (true) {
			tryCount++;
			System.out.print("(" + tryCount + " 回目)予測数字を入力してください：");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String expectedNumber = scanner.nextLine();

			if (expectedNumber.equals(GIVEUP)) {
				System.out.println("正解は " + answer + " でした。");
				break;
			}

			if (!expectedNumber.matches("[0-9]{4}")) {
				System.out.println("4つの半角数字かギブアップとして999を入力してください。\r\n");
				continue;
			}

			if (checkAnswer(expectedNumber, answer)) {
				break;
			}
		}
	}

	/**
	 * 答えと入力した数字とを比較します。
	 *
	 * @param answer 答え
	 * @param expectedNumber 答えと比較される予想数字
	 *
	 * @return 答えと予想数字が完全に一致しているかどうか
	 */
	public static boolean checkAnswer(String answer, String expectedNumber) {
		int hitCount = 0;
		int blowCount = 0;

		// 答えと予想数字の位置と数字がいくつ合っているか検索します。
		for (int i = 0; i < answer.length(); i++) {

			if (expectedNumber.charAt(i) == answer.charAt(i)) {
				hitCount++;
			}

			if (answer.indexOf(expectedNumber.charAt(i)) != -1) {
				blowCount++;
			}
		}
		System.out.println("ヒット" + hitCount + " ブロー" + (blowCount - hitCount) + "\r\n");

		if (hitCount == answer.length()) {
			System.out.println("正解");
			return true;
		}
		return false;
	}
}
