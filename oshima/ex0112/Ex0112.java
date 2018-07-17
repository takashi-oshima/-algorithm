package oshima.ex0112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し、文字列内に半角カナが含まれるか判定します。
 *
 * @author 大島
 */
public class Ex0112 {

	public static void main(String[] args) throws IOException {
		// 禁止文字を設定し、変数を初期化します。
		final String HALFWIDTH_KANA = ".*[\\uff61-\\uff9f]+.*";

		// キーボード入力を受け付け、入力内容を変数に格納します。
		String inputString = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("文字列:");
		inputString = in.readLine();

		// nullと空文字チェックします。
		if (inputString == null || inputString.isEmpty()) {
			System.out.println("文字列がnullまたは空文字です。");
			return;
		}

		// 文字列に禁止文字が含まれているかどうかで表示文を変更します。
		if (inputString.matches(HALFWIDTH_KANA)) {
			System.out.println("半角カナが含まれます");
		}else {
			System.out.println("許可する文字列です");
		}
	}
}