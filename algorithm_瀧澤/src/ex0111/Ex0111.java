package ex0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 入力した文字列内に、指定文字が含まれているかを
 * 確認して表示させるクラス
 *
 * @author 瀧澤
 */
public class Ex0111 {

	public static void main(String[] args) throws IOException {
		String inputString = "";
		//該当文字があるかないかを判定する変数
		boolean flag = true;
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

		//Listに検索文字列を追加します
		List<String> searchList = new ArrayList<>();
		Collections.addAll(searchList, new String[] { "①", "③", "⑤",
				"⑦", "⑨" });

		//検索文字の先頭から検索するので拡張forを使います
		for (String searchStr : searchList) {
			//resultに、検索文字列が含れているかの結果を格納します
			int result = inputString.indexOf(searchStr);

			//該当文字が見つからなかった時に-1が返ってくるため
			//if文で見つかった場合の処理をします
			if (result != -1) {
				//flagをfalseにします
				flag = false;
				System.out.println("\r\n許可しない文字(文字:" + searchStr + " " + (result + 1) +
						"桁目)が含まれます");
			}
		}
		//もしflagがtrue(該当検索文字列)でなかった場合
		if (flag == true) {
			System.out.println("\r\n許可する文字列です");
		}
	}
}