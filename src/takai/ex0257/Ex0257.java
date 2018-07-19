package takai.ex0257;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 入力された文字列が、指定した日付形式か否か出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0257 {

	public static void main(String[] args) {
		/** 1つ目の文字列 */
		Date inputDayDate1 = null;
		/** 2つ目の文字列 */
		Date inputDayDate2 = null;
		/** 1つ目の文字列を変換し格納するもの */
		long inputDayLong1 = 0;
		/** 2つ目の文字列を変換し格納するもの */
		long inputDayLong2 = 0;
		/** 日付差分 */
		long diffDays = 0;
		/** 秒差分 */
		long diffTime = 0;
		/** 日付差分算出用の定数 */
		final long DATE_TIME = 1000 * 60 * 60 * 24;

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//指定した形式かの判定をします。
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			format.setLenient(false);
			//入力値を代入します。
			System.out.println("input date1：");
			inputDayDate1 = format.parse(scan.nextLine());
			System.out.println("input date2：");
			inputDayDate2 = format.parse(scan.nextLine());
		} catch (ParseException e) {
			System.out.println("文字列が指定した形式ではありません。");
			return;
		}

		//NULLチェック
		if (inputDayDate1 == null) {
			System.out.println("文字列1が空白、もしくはnull値になっています");
			return;
		}
		if (inputDayDate2 == null) {
			System.out.println("文字列2がnull値になっています");
			return;
		}

		//long型に変換して、日数としての差分と、秒としての差分を求めます。
		inputDayLong1 = inputDayDate1.getTime();
		inputDayLong2 = inputDayDate2.getTime();
		diffDays = (inputDayLong1 - inputDayLong2) / DATE_TIME;
		diffTime = (inputDayLong1 - inputDayLong2) / 1000;
		if (diffTime == 0) {
			System.out.println("日数の差は0日です");
			return;
		}
		if (diffDays < 0) {
			diffDays = diffDays * -1;
			diffTime = diffTime * -1;
		}
		System.out.println("日数の差は" + diffDays + "日で" + diffTime + "秒です。");
	}
}