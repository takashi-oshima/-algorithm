package oshima.ex0113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し、文字列内に全角数字が含まれる場合は半角数字に置換して出力します。
 *
 * @author 大島
 */
public class Ex0113 {

	public static void main(String[] args) throws IOException {
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

		// 文字列に全角数字が含まれていれば、半角数字に変換します。
		String result = "";
		StringBuilder sb = new StringBuilder(inputString);
		for (int i = 0; i < sb.length(); i++) {
			char inputChar = inputString.charAt(i);
			if ('０' <= inputChar && inputChar <= '９') {
				sb.setCharAt(i, (char) (inputChar - '０' + '0'));
			}
		}
		result = sb.toString();
		System.out.println(result);
	}
}