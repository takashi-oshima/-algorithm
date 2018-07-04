package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し、入力された文字列内に全角数字が含まれる場合、
 * 半角数字に置き換えて出力します
 *
 * @author 粟野真司
 */
public class Ex0113 {
	public static void main(String args[]) throws IOException {

		// 入力ストリームを生成します
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("文字列:");

		// 入力文字列をinputCharに格納します
		String inputStr = br.readLine();

		// 入力された文字列が空文字かどうか判定します
		if (inputStr.isEmpty() || inputStr == null) {
			System.out.println("空です。文字列を入力してください。");
			return;
		}

		// 入力された数字が全角の場合、半角に置き換えるようにします
		StringBuffer sb = new StringBuffer(inputStr);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= '０' && c <= '９') {
				sb.setCharAt(i, (char) (c - '０' + '0'));
			}
		}
		inputStr = sb.toString();
		System.out.println("結果：" + inputStr);
	}
}
