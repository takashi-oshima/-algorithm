package takizawa.ex0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文字列を入力し、文字列内の半角空白で
 * 単語に分解し出力順序が偶数と奇数でそれぞれ結合して出力する。
 *
 * @author 瀧澤
 */
public class Ex0115 {

	public static void main(String[] args) throws IOException {
		String inputString = "";
		//キーボード入力の処理をします
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("文字列 :");
		inputString = reader.readLine();
		//文字列のnullと空文字をチェックします
		if (inputString == null || inputString.isEmpty()) {
			System.out.println("文字列が確認できませんでした\n" +
					"処理を終了します");
			return;
		}
		System.out.print("\r\n奇数番目:");
		//入力文字列から空白を削除したものをoddNumberに代入します
		String[] oddNumber = inputString.split("[\\s]+");
		for (int i = 0; i < oddNumber.length; i += 2) {
			//奇数番目の文字列を取得して表示
			System.out.print(oddNumber[i] + " ");
		}
		System.out.print("\r\n偶数番目:");
		//入力文字列から空白を削除したものをevenNumberに代入します
		String[] evenNumber = inputString.split("[\\s]+");
		for (int i = 1; i < evenNumber.length; i += 2) {
			//偶数番目の文字列を取得して表示
			System.out.print(evenNumber[i] + " ");
		}
	}
}