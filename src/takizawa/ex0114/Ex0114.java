package takizawa.ex0114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * キーボードから文字列を入力し文字列内の
 * 半角空白で単語に分解して逆順に表示するクラスです
 *
 * @author 瀧澤
 */
public class Ex0114 {

	public static void main(String[] args) throws IOException {
		//キーボード入力の処理をします
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("文字列 :");
		String str = reader.readLine();
		//文字列のnullと空文字をチェックします
		if (str == null || str.isEmpty()) {
			System.out.println("文字列が確認できませんでした\n" +
					"処理を終了します");
			return;
		}
		//入力文字列から空白を削除したものをresultに代入します
		String[] result = str.split("[\\s]+");

		System.out.print("\r\n結果:");
		//resultを逆順に表示します
		for (int i = result.length; i > 0; i--) {
			System.out.print(result[i - 1] + " ");
		}
	}
}