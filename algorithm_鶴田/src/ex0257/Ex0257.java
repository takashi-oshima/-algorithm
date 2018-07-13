package ex0257;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * キーボードから日付を2つ入力し、大きい日付から小さい日付の差を秒で出力します
 * 日付が等しい場合はゼロを出力する
 *
 * @author 鶴田竜也
 */
public class Ex0257 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println("input date1");
		String inputDate1 = scan.nextLine();
		System.out.println("input date2");
		String inputDate2 = scan.nextLine();

		//空文字、nullチェックをします
		if (inputDate1.isEmpty() || inputDate1 == null || inputDate2.isEmpty() || inputDate2 == null) {
			System.out.println("空文字またはnullが含まれています");
			return;
		}

		// SimpleDateFormatを使用して、パターンを設定します
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		Date date1 = null;
		Date date2 = null;
		// 存在しない日付を入力した時、ParseExceptionの内容を出力します
		sdf.setLenient(false);

		try {
			// 入力文字列を日付に変換、date1に代入
			date1 = sdf.parse(inputDate1);
			date2 = sdf.parse(inputDate2);

		} catch (ParseException e) {
			//  Date型へ正しく変換できなかった場合
			System.out.println("正しい日付ではありません");
			return;
		}

		// 日付をミリ秒に変換します
		long dateTime1 = date1.getTime();
		long dateTime2 = date2.getTime();

		// 日数の差を格納します
		long days = 0;

		// 1日の秒数を格納します
		int dailySeconds = (60 * 60 * 24);

		// 日付の比較をし、差の秒数を算出します
		if (dateTime1 < dateTime2) {
			// ミリ秒を1000で割り算して秒に直します
			long dayDiff = (dateTime2 - dateTime1) / 1000;
			days = dayDiff / dailySeconds;
			System.out.println("日数の差は" + days + "で" + dayDiff + "です");

		} else if (dateTime1 > dateTime2) {
			long dayDiff = (dateTime1 - dateTime2) / 1000;
			days = dayDiff / dailySeconds;
			System.out.println("日数の差は" + days + "日で" + dayDiff + "です");

		} else if (dateTime1 - dateTime2 == 0) {
			System.out.println("日数の差は0日です");
		}
	}
}