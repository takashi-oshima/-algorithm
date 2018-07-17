package oshima.ex0110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから 2つの文字列を入力し、辞書順で小さい方から値を出力します。
 *
 * @author 大島
 */
public class Ex0110 {

	public static void main(String[] args) throws IOException {
		// 入力した文字列を格納する配列です。
		String[] characterStrings = new String[2];

		// キーボード入力を受け付け、入力内容を配列に格納します。
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("文字列1:");
		characterStrings[0] = in.readLine();
		System.out.println("文字列2:");
		characterStrings[1] = in.readLine();

		// nullと空文字チェックします。
		for (String string : characterStrings) {
			if (string == null || string.isEmpty()) {
				System.out.println("文字列がnullまたは空文字です。");
				return;
			}
		}

		// 入力された2つの文字列を比較し、辞書順で小さい方から値を出力します。
		if (characterStrings[0].compareTo(characterStrings[1]) < 0) {
			// 負数が帰ってくる場合、配列0番目の文字列の方が小さいです。
			System.out.println(characterStrings[0] + "  " + characterStrings[1]);
		} else if (characterStrings[0].compareTo(characterStrings[1]) > 0) {
			// 正数が帰ってくる場合、配列1番目の文字列の方が小さいです。
			System.out.println(characterStrings[1] + "  " + characterStrings[0]);
		} else {
			// 0が帰ってくる場合、２つの文字列は同じです。
			System.out.println("２つの文字列は同じです ->" + characterStrings[0]);
		}
	}
}
