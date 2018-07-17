package koganei.ex0257;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * キーボードから日付を2 つ入力し、大きい日付から小さい日付の差を秒で出力します。
 * 日付形式は「YYYY/MM/DD」とします。日付が等しい場合はゼロを出力します。
 *
 * @author 小金井 広輝
 */
public class Ex0257 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		//キーボードから入力された日付を取得します。
		System.out.println("input date1：");
		String date1 = scanner.nextLine();
		System.out.println("input date2：");
		String date2 = scanner.nextLine();

		//日付形式で入力されているかチェックします
		if (!judgeDateFormat(date1) || !judgeDateFormat(date2)) {
			System.out.println("正しく入力されていません");
			return;
		}

		//差の日数と秒数を取得します
		String ans = getDayDiff(date1, date2);
		//結果を表示します
		System.out.println(ans);
	}

	/**
	 * //日付形式で入力されているかチェックし、その真偽を返します
	 *
	 * @param date 入力された日付
	 * @return 正しく入力されているかの真偽
	 */
	public static boolean judgeDateFormat(String date) {
		boolean dateCheck = true;
		if (date.matches(".*[0-9]{4}/[0-1]{1}[0-9]{1}/[0-3]{1}[0-9]{1}.*")) {
			String month = date.substring(5, 7);
			String day = date.substring(8);
			//月の値が範囲内（1～12）かの判別
			int monthInt = Integer.parseInt(month);
			if (monthInt < 1 || monthInt > 12) {
				dateCheck = false;
			}
			//日付の値が範囲内（1～31）かの判別
			int dateInt = Integer.parseInt(day);
			if (dateInt < 1 || dateInt > 31) {
				dateCheck = false;
			}
		} else {
			//○○○○/○○/○○の形式で入力されていない場合
			dateCheck = false;
		}
		return dateCheck;
	}

	/**
	 * 差の日数とその秒数を求め結果を返します
	 *
	 * @param date1 入力されたひとつめの日付
	 * @param date2 入力されたふたつめの日付
	 * @return 結果の詳細
	 */
	public static String getDayDiff(String date1, String date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date dateTo = null;
		Date dateFrom = null;
		String ansText = "";
		try {
			dateTo = sdf.parse(date1);
			dateFrom = sdf.parse(date2);
		} catch (ParseException e) {
			ansText = "日付形式にフォーマットできませんでした";
			return ansText;
		}
		//入力されたふたつの日付からミリ秒数を取得します
		long dateTimeTo = dateTo.getTime();
		long dateTimeFrom = dateFrom.getTime();
		//ふたつの日付からミリ秒数の差を求め、秒数に直します
		long daySeconds = Math.abs(dateTimeTo - dateTimeFrom) / 1000;
		long dayDiff = Math.abs(dateTimeTo - dateTimeFrom) / (1000 * 60 * 60 * 24);
		//結果を返します
		if (dayDiff == 0) {
			ansText = "日数の差は" + dayDiff + "日です";
		} else {
			ansText = "日数の差は" + dayDiff + "日で" + daySeconds + "秒です";
		}
		return ansText;
	}
}
