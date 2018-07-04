package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 実行用のクラスです。
 * キーボードから2つの文字列を入力し、辞書順で小さい順に出力します
 * 同じ値の場合は、「2つの文字列は同じです」と出力します
 *
 * @author 粟野真司
 */
class Ex0110 {
	public static void main(String args[]) throws IOException {

		// 入力ストリームを生成します
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);

		// 2つの文字列入力を変数に格納します
		String str1 = br.readLine();
		String str2 = br.readLine();

		// 入力された文字列か空文字かどうか判定します
		if (str1.isEmpty() || str2.isEmpty()) {
			System.out.println("文字列が入力されておりません。");
			return;
		}

		// 入力された文字列がnullかどうか判定します
		if (str1 == null || str2 == null) {
			System.out.println("文字列が入力されておりません。");
			return;
		}

		// str1とstr2を比較し、正の値の場合、辞書順に入れ替えます
		if (str1.compareTo(str2) > 0) {
			System.out.println("文字列1:\r\n" + str2);
			System.out.println("文字列2:\r\n" + str1);
		}
		// str1とstr2を比較し、負の値の場合、入れ替えずにそのまま表示します
		else if (str1.compareTo(str2) < 0) {
			System.out.println("文字列1:\r\n" + str1);
			System.out.println("文字列2:\r\n" + str2);
		}

		// str1とstr2を比較し、同じかどうか確認します
		else if (str1.compareTo(str2) == 0) {
			System.out.println("文字列1:\r\n" + str1);
			System.out.println("文字列2:\r\n" + str2);
			System.out.println("2つの文字列は同じです" + "  " + "==>" + str1);
		}
	}
}
