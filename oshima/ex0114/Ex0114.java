package oshima.ex0114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し、文字列内の半角空白で単語に分解します。 分解後、単語を逆順で出力する。半角空白が連続で入力された場合は無視します。
 *
 * @author 大島
 */
public class Ex0114 {

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

		// 配列の中身を、逆順に出力します。
		for (int i = characterStrings.length - 1; i >= 0; i--) {
			System.out.print(characterStrings[i] + " ");
		}
	}
}