package oshima.ex0257;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 * キーボードから日付を 2 つ入力し、大きい日付から小さい日付の差を秒で出力します。
 * 日付形式は「YYYY/MM/DD」とする。日付が等しい場合はゼロを出力します。
 *
 * @author 大島
 */
public class Ex0257 {

	public static void main(String[] args) throws ParseException {
		// 入力した文字列を格納する配列です。
		String[] inputDates = new String[2];

		// キーボード入力を受け付け、入力内容を配列に格納します。
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input date1：");
		inputDates[0] = scanner.nextLine();
		System.out.println("input date2：");
		inputDates[1] = scanner.nextLine();

		// nullと空文字、指定通りの形式で入力されているかをチェックします。
		for (String string : inputDates) {
			if (string == null || string.isEmpty()) {
				System.out.println("文字列がnullまたは空文字です。");
				return;
			}
			boolean flag = string.matches(".*[0-9]{4}/[0-1]{1}[0-9]{1}/[0-3]{1}[0-9]{1}.*");
			if (flag == false) {
				System.out.println("指定した形式ではありません。");
				return;
			}
		}

		// 計算結果がマイナス値とならないよう、配列の要素を降順にソートします。
		Arrays.sort(inputDates, Collections.reverseOrder());

		// 入力した日付の型変換をします。
		Date dateTo = new SimpleDateFormat("yyyy'/'MM'/'dd").parse(inputDates[0]);
		Date dateFrom = new SimpleDateFormat("yyyy'/'MM'/'dd").parse(inputDates[1]);
		long dateTimeTo = dateTo.getTime();
		long dateTimeFrom = dateFrom.getTime();

		// 差分の日数、秒数を算出し、表示します。
		String result = "";
		long calcDays = (dateTimeTo - dateTimeFrom) / (1000 * 3600 * 24);
		long calcSeconds = (dateTimeTo - dateTimeFrom) / 1000;
		if (calcDays == 0) {
			 result = "日数の差は " + calcDays + "日です";
		} else {
			 result = "日数の差は" + calcDays + "日で " + calcSeconds + "秒です";
		}
		System.out.println(result);
	}
}