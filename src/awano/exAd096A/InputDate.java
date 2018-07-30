package awano.exAd096A;

import java.util.Scanner;

/**
 * 入力された数値がグレゴリオ暦において、
 * 正しい日付かどうか確認するクラスです。
 *
 * @author 粟野真司
 */
public class InputDate {
	/**入力された月*/
	private int month = 0;
	/**入力された日*/
	private int day = 0;

	/**
	 * 入力された日付が2018年グレゴリオ暦において正しい日付かどうか調べます。
	 *
	 * @return 正しい日付かどうか
	 */
	public boolean checkDate() {
		boolean corecctDate = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">a  b");
		String inputStr = scanner.nextLine();
		String[] date = inputStr.split(" ", 0);

		if (date.length != 2) {
			System.out.println("月日を入力し直してください。");
			return corecctDate;
		}

		try {
			month = Integer.parseInt(date[0]);
			day = Integer.parseInt(date[1]);
		} catch (NumberFormatException e) {
			System.out.println("入力された数値に文字列が含まれています。");
			return corecctDate;
		}

		if ((month > 12 || month < 1) && (day < 1 || day > 31)) {
			System.out.println("月日が範囲外です。");
			return corecctDate;
		}

		if (month > 12 || month < 1) {
			System.out.println("月が範囲外です。");
			return corecctDate;
		}

		if (day < 1 || day > 31) {
			System.out.println("日が範囲外です。");
			return corecctDate;
		}

		//2018年グレゴリオ暦における全月の末日を配列に格納します
		int[] endDate = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		//入力された日が正しい末日を超える場合
		if (day > endDate[month - 1]) {
			System.out.println(month + "月の末日を超えています。");
			return corecctDate;
		}
		corecctDate = true;
		return corecctDate;
	}

	/**
	 * 月を返します
	 * @return 月
	 *
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * 月を設定します
	 *
	 * @param month 月
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * 日を返します
	 *
	 * @return 日
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 日を設定します
	 *
	 * @param dayn 日
	 */
	public void setDay(int day) {
		this.day = day;
	}
}