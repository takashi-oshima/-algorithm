package algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * キーボードから日付を2つ入力し、
 * 大きい日付から小さい日付の差を秒で出力します
 * 日付け形式は「YYYY/MM/DD」とし、
 * 日付が等しい場合はゼロを出力します
 *
 *
 * @author 粟野真司
 */
public class Ex0257 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// 入力ストリームを生成します
		Scanner scan = new Scanner(System.in);
		// 入力フォームを表示し、入力された文字列をString型変数に格納します
		System.out.println("input date1:");
		String date1 = scan.nextLine();
		System.out.println("input date2:");
		String date2 = scan.nextLine();
		// 入力された文字列が空文字かどうか判定します
		if (date1.isEmpty() || date1 == null || date2.isEmpty() || date2 == null) {
			System.out.println("入力された文字列が空です");
			return;
		}
		// 日付方式を指定します
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		// 入力された文字列をDate型に変換するための変数を宣言します
		Date inputDate1 = null;
		Date inputDate2 = null;

		// 入力された文字列をDate型に変換します
		try {
			// 日時解析を厳密に行うよう設定します
			df.setLenient(false);
			inputDate1 = df.parse(date1);
			inputDate2 = df.parse(date2);
		} catch (ParseException e) {
			System.out.println("yyyy/MM/dd方式で入力してください");
			return;
		}

		// 日付をlong値に変換します。
		long second1 = inputDate1.getTime() / 1000;
		long second2 = inputDate2.getTime() / 1000;
		long seconds = 0;
		long days = 0;

		// 入力された日付を比較し、大きい日付から小さい日付の差を求めるようにします
		if (second1 - second2 > 0) {
			// 差分の日数と秒数を計算し、表示します
			seconds = second1 - second2;
			days = seconds / (60 * 60 * 24);
			System.out.println("日数の差は" + days + "日で" + seconds + "秒です");
		}
		// 小さい日付、大きい日付の順で入力された場合、大きい順に入れ替えます
		if (second1 - second2 < 0) {
			seconds = second2 - second1;
			days = seconds / (60 * 60 * 24);
			System.out.println("日数の差は" + days + "日で" + seconds + "秒です");
		}
		// 2つの日付が等しい場合かどうかを確認します
		if (second1 - second2 == 0) {
			System.out.println("日数の差は0日です");
		}
	}
}