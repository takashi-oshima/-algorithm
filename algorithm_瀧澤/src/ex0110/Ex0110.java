package ex0110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * コンソールから文字列を入力して
 * 辞書順に表示させるクラスです
 * @author 瀧澤
 */
public class Ex0110 {

	public static void main(String[] args) {
		//文字列１と文字列２にnullを代入します
		String str1 = "";
		String str2 = "";
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("文字列１:");
			//文字列１をコンソール入力します
			str1 = reader.readLine();
			//文字列１に何も入力されなかったときに処理を終了させます
			if (str1 == null || str1.isEmpty()) {
				System.out.println("文字列１が確認できませんでした\n" +
						"処理を終了します\r\n");
				return;
			}
			System.out.println("文字列２:");
			//文字列２をコンソール入力します
			str2 = reader.readLine();
			//文字列２に何も入力されなかったときに処理を終了させます
			if (str2 == null || str2.isEmpty()) {
				System.out.println("文字列２が確認できませんでした\n" +
						"処理を終了します\r\n");
				return;
			}

			//文字列１と文字列２を比べて１の方が大きかった場合
			if (str1.compareTo(str2) > 0) {
				System.out.println(str2 + " " + str1);
				//文字列２と文字列１を比べて２の方が大きかった場合
			} else if (str1.compareTo(str2) < 0) {
				System.out.println(str1 + " " + str2);
				//文字列1と文字列2が等しい時の処理
			} else {
				System.out.println("２つの文字列は同じです ->" + str1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}