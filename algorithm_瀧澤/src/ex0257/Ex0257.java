package ex0257;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 大きい日付から小さい日付の差を秒で出力する。
 *
 * @author 瀧澤
 */
public class Ex0257 {

	public static void main(String[] args) {
		String inputDate1 = "";
		String inputDate2 = "";
		Date date1 = null;
		Date date2 = null;

		// キーボード入力処理とエラー処理
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input date1:");
		inputDate1 = scanner.nextLine();

		if (inputDate1 == null || inputDate1.isEmpty()) {
			System.out.println("\r\n文字列が確認できませんでした\n処理を終了します");
			return;
		}
		System.out.println("input date2:");
		inputDate2 = scanner.nextLine();

		if (inputDate2 == null || inputDate2.isEmpty()) {
			System.out.println("\r\n文字列が確認できませんでした\n処理を終了します");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		try {
			// 日付の妥当性チェック
			String dateConfirm = sdf.format(sdf.parse(inputDate1));
			String dateConfirm2 = sdf.format(sdf.parse(inputDate2));
			if (!(dateConfirm.equals(inputDate1)) || !(dateConfirm2.equals(inputDate2))) {
				System.out.println("正しく入力してください");
			}
			// String→Date型に直す
			date1 = DateFormat.getDateInstance().parse(dateConfirm);
			date2 = DateFormat.getDateInstance().parse(dateConfirm2);
		} catch (ParseException e) {
			System.out.println("日数として認識できない文字が含まれています");
			return;
		}

		// Date型に直した日付を、long型でミリ秒表示に直します
		long lgDate1 = date1.getTime();
		long lgDate2 = date2.getTime();

		// ミリ秒表示にした日付同士で減算をし、それを
		// 1日をミリ秒表示にしたもので割って日数の差を出します
		long dayDiff = (lgDate1 - lgDate2) / (1000 * 60 * 60 * 24);

		// ミリ秒表示で表示していたものを、秒に直して表示するます
		long secDisp = (lgDate1 - lgDate2) / 1000;

		// 最初に入力した値が2番目に入力した値よりも大きかった時
		if (dayDiff > 0) {
			System.out.println("\r\n日数の差は" + dayDiff + "日で" + secDisp + "秒です");

			// 2番目に入力した値が大きかった時に、負数で表示されるのを正の数に直す
		} else if (dayDiff < 0) {
			System.out.println("\r\n日数の差は" + (-1) * dayDiff + "日で" + (-1) * secDisp + "秒です");

			// 日数の差が0の時
		} else {
			System.out.println("\r\n日数の差は" + dayDiff + "日です");
		}
	}
}