package algorithm.ex0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し、文字列内の半角空白で単語に分解します
 *単語の出力順序が偶数と奇数でそれぞれ結合して出力します
 *
 * @author 粟野真司
 */
public class Ex0115 {
	public static void main(String[] args) throws IOException {
		// 入力ストリームを生成します
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);

		// 入力フォームを表示します
		System.out.println("文字列:");

		// 入力文字列をinputCharに格納します
		String inputStr = br.readLine();

		// 文字列内の半角空白で単語に分解し、配列に格納します
		String[] strArray = inputStr.split(" ");

		// 配列の奇数番目を表示します
		System.out.print("奇数番目:");
		for (int i = 0; i < strArray.length; i++) {
			if (i % 2 == 0) {
				System.out.print(strArray[i] + " ");
			}
		}
		// 配列の偶数番目を表示します
		System.out.print("\r\n偶数番目：");
		for (int i = 0; i < strArray.length; i++) {
			if (i % 2 != 0) {
				System.out.print(strArray[i] + " ");
			}
		}
	}
}