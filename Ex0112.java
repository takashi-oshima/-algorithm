package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 実行用クラスです
 * キーボードから文字列を入力し、入力された文字列に半角カナが
 * 含まれているかどうかの判定をします
 *
 * @author 粟野真司
 */
public class Ex0112 {
	public static void main(String args[]) throws IOException {
		// 禁止文字として半角カナを宣言します
		final String PROHIBIT_CHAR = "^[\\uFF65-\\uFF9F]+$";

		// 入力ストリームを生成します
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("文字列:");

		// 文字列入力をinputCharに格納します
		String inputChar = br.readLine();

		// 入力された文字列か空文字かどうか判定します
		if (inputChar.isEmpty() || inputChar == null) {
			System.out.println("空です。文字列を入力してください。");
			return;
		}

		// 入力された文字列に半角カナが含まれているかどうか判定します
		if (inputChar.matches(PROHIBIT_CHAR)) {
			System.out.println("半角カナが含まれます");
		} else {
			System.out.println("許可する文字列です");
		}
	}
}