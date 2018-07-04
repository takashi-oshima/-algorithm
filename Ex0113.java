package ex0113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し、文字列内に全角数字が含まれる場合は
 * 半角数字にして出力します。
 *
 * @author 鶴田竜也
 */
public class Ex0113 {
	public static void main(String[] args) throws IOException {

		// 入力ストリームを生成します
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("文字列:");
		// 入力文字列をinputStrに格納します
		String inputStr = br.readLine();
		// 入力された文字列が空文字かどうか判定します
		if (inputStr.isEmpty() || inputStr == null) {
			System.out.println("空もしくはnullです。文字列を入力してください。");
			return;
		}

		// ループ内で文字列の操作を行うため、文字列操作に適したStringBuilderを使用します
		// 入力された数字が全角の場合、半角に置き換えるようにします
		StringBuilder sb = new StringBuilder(inputStr);
		for (int i = 0; i < sb.length(); i++) {
			// i番目の文字列を抜き出してcに代入します
			int c = (int) sb.charAt(i);
			// 0xFF10はユニコードの全角数字０、0xFF19はユニコードの全角数字９
			if (c >= 0xFF10 && c <= 0xFF19) {
				// cから0xFEE0（ユニコード上の半角数字までの距離）を引き半角数字に変換(c - 0xFEE0)
				// setCharAtで指定した1文字（i）を置換します。
				sb.setCharAt(i, (char) (c - 0xFEE0));
			}
		}
		// 文字列に変換し、出力します
		inputStr = sb.toString();
		System.out.println("結果：" + inputStr);
	}
}