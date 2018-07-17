package oshima.ex0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し、文字列内の半角空白で単語に分解します。 分解後、単語の出力順序が偶数と奇数でそれぞれ結合して出力します。
 *
 * @author 大島
 */
public class Ex0115 {

	public static void main(String[] args) throws IOException {
		// 入力した文字列を格納する変数です。
		String inputString = "";

		// キーボード入力を受け付け、入力内容を変数に格納します。
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("文字列:");
		inputString = in.readLine();

		// 入力した文字列を半角空白で区切り、配列に格納します。
		String[] characterStrings = inputString.split("[\\s]+", -1);

		// nullと空文字チェックします。
		for (String string : characterStrings) {
			if (string == null || string.isEmpty()) {
				System.out.println("文字列がnullまたは空文字です。");
				return;
			}
		}

		// 配列の中身を、奇数順に出力します。
		System.out.print("奇数番目 ");
		for (int i = 0; i < characterStrings.length; i += 2) {
			System.out.print(characterStrings[i] + " ");
		}

		// 配列の中身を、偶数順に出力します。
		System.out.print("\r\n偶数番目 ");
		for (int i = 1; i < characterStrings.length; i += 2) {
			System.out.print(characterStrings[i] + " ");
		}
	}
}