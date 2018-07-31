package awano.ex0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 実行用クラスです。
 * キーボードから文字列を入力し、入力された文字列に禁止文字が
 * 含まれているかどうかの判定をします。
 *
 * @author 粟野真司
 */
public class Ex0111 {
	public static void main(String args[]) throws IOException {
		// 禁止文字を配列に格納します
		final String[] PROHIBIT_CHAR = { "①", "③", "⑤", "⑦", "⑨" };

		// 入力ストリームを生成します
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("文字列:");

		// 許可する文字列かどうかの処理をするための変数を宣言します
		boolean judgement = true;

		// 文字列入力をinputCharに格納します
		String inputChar = br.readLine();

		// 入力された文字列か空文字かどうか判定します
		if (inputChar.isEmpty() || inputChar == null) {
			System.out.println("空です。文字列を入力してください。");
			return;
		}

		// 入力された文字列に禁止文字が含まれているかどうか判定します
		for (int i = 0; PROHIBIT_CHAR.length > i; i++) {
			int result = inputChar.indexOf(PROHIBIT_CHAR[i]);
			if (result != -1) {
				System.out.println("許可しない文字(文字:" + PROHIBIT_CHAR[i] + (result + 1) + "桁目)が含まれます");
				judgement = false;
			}
		}
		// 入力された文字列に禁止文字が含まれていない場合、許可する文字列と判定します
		if (judgement == true) {
			System.out.println("許可する文字列です");
		}
	}
}
