package ex0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し、文字列内に「①,③,⑤,⑦,⑨」が含まれるか判定する。
 *
 * @author 大島
 */
public class Ex0111 {

	public static void main(String[] args) throws IOException {
		// 禁止文字を設定し、変数を初期化します。
		final String[] PROHIBITED_CHARACTERS_ARRAY = { "①", "③", "⑤", "⑦", "⑨" };

		// キーボード入力を受け付け、入力内容を変数に格納します。
		String inputString = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("文字列（１）:");
		inputString = in.readLine();

		// nullと空文字チェックします。
		if (inputString == null || inputString.isEmpty()) {
			System.out.println("文字列がnullまたは空文字です。");
			return;
		}

		// 文字列に禁止文字が含まれていた場合、どの文字で何桁目かを検索し、表示します。
		int result = 0;
		boolean permit = true;
		for (int i = 0; PROHIBITED_CHARACTERS_ARRAY.length > i; i++) {
			result = inputString.indexOf(PROHIBITED_CHARACTERS_ARRAY[i]);
			if (result != -1) {
				System.out.println("許可しない文字(文字:" + PROHIBITED_CHARACTERS_ARRAY[i] + "  " + (result + 1) + "桁目)が含まれます");
				permit = false;
			}
		}
		if (permit = true) {
			System.out.println("許可する文字列です");
		}
	}
}
