package algorithm.ex0256;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * キーボードから文字列を入力し、その文字列が
 * 「yyyy/mm/dd」の日付形式か否かを出力します
 *
 * @author 粟野真司
 */
public class Ex0256 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// 入力ストリームを生成します
		Scanner scan = new Scanner(System.in);
		// 入力フォームを表示します
		System.out.println("input date:");
		// 入力された文字列をString型変数に格納します
		String date = scan.nextLine();

		// 入力された文字列が空文字かどうか判定します
		if (date.isEmpty() || date == null) {
			System.out.println("入力された文字列が空です。");
			return;
		}

		// 入力された文字列が指定した日付方式かを判定します
		try {
			// 日付方式を指定します
			DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
			// 日時解析を厳密に行うよう設定します
			df.setLenient(false);
			// 入力された文字列を指定した日付方式に変換します
			String dateFormat = df.format(df.parse(date));

			//入力された文字列と変換後の日付方式の文字列が一致しているかどうか確認します
			if (date.equals(dateFormat)) {
				System.out.println("指定した形式です。");
			} else {
				System.out.println("指定した形式ではありません。");
			}
		} catch (ParseException e) {
			System.out.println("不正な入力です。日付を入力してください。");
		}
	}
}