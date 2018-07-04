package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し、文字列内の半角空白で単語に分解し、単語を逆順で出力します
 * 半角空白が連続で入力された場合は無視します
 *
 * @author 粟野真司
 */
public class Ex0114 {
	public static void main(String[] args) throws IOException {
		// 入力ストリームを生成します
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);

		// 入力フォームを表示します
		System.out.println("文字列:");

		// 入力文字列をinputCharに格納します
		String inputStr = br.readLine();

		// 入力された文字列が空文字かどうか判定します
		if (inputStr.isEmpty() || inputStr == null) {
			System.out.println("空です。文字列を入力してください。");
			return;
		}

		// 入力された文字列に半角空白が連続で入力された場合、半角空白1つに置換します。
		String convertHalfSpace = inputStr.replaceAll(" {2,}", " ");

		// 文字列内の半角空白で単語に分解し、配列に格納します。
		String[] strArray = convertHalfSpace.split(" ");

		// 配列の要素を逆順に表示します
		for (int i = strArray.length-1; i >=0; i--) {
			System.out.print(strArray[i] + " ");
		}
	}
}