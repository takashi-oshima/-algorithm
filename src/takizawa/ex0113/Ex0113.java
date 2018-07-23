package takizawa.ex0113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文字列内に全角数字が含まれる場合に
 * 半角数字に置き換えるクラスです
 *
 * @author 瀧澤
 */
public class Ex0113 {

	public static void main(String[] args) throws IOException {
		String inputString = "";
		String result = "";
		//キーボード入力の処理をします
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("文字列 :");
		inputString = reader.readLine();
		//文字列のnullと空文字をチェックします
		if (inputString == null || inputString.isEmpty()) {
			System.out.println("\r\n文字列が確認できませんでした\n" +
					"処理を終了します");
			return;
		}
		//セットしたStringクラスの値を変更するためにStringBuilderを使います
		StringBuilder sb = new StringBuilder(inputString);
			//全角文字と半角文字を置き換えます
			for (int i = 0; i < sb.length(); i++) {
				int c = sb.charAt(i);
				if (c >= 0xFF10 && c <= 0xFF19) {
					sb.setCharAt(i,(char) (c - 0xFEE0));
				}
			}
			//結果に、半角数字を代入し表示します
			result = sb.toString();
			System.out.println("\r\n結果:" + result);
		}
	}