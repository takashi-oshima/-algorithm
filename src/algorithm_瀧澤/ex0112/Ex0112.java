package ex0112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 入力文字に、半角カナが含まれているかを
 * 判別します
 *
 * @author 瀧澤
 */
public class Ex0112 {

	public static void main(String[] args) throws IOException {
		//半角文字を用意
		final String HALF_KANA = ".*[\\uFF65-\\uFF9F].*";
		String inputString = "";
		//キーボード入力の処理をします
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("文字列 :");
		inputString = reader.readLine();
		//nullと空文字のチェック
		if (inputString == null || inputString.isEmpty()) {
			System.out.println("文字列が確認できませんでした\n" +
					"処理を終了します");
			return;
		}

		//入力文字に半角カナがあるかを判別する
		if (inputString.matches(HALF_KANA)) {
			System.out.println("\r\n半角カナが含まれています");
		} else {
			System.out.println("\r\n許可する文字列です");
		}
	}
}