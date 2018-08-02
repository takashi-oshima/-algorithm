package exAd096A;

import java.util.Scanner;

/**
 * 日付入力のチェックを行います
 *
 * @author 鶴田竜也
 */
public class InputDate {

	private int month = 0;
	private int day = 0;

	/**
	 * 日付けの入力チェックをします。入力内容が正しければtrue、正しくなければfalseを返します。
	 *
	 * @return 日付入力の真偽
	 */
	public boolean checkDate() {
		/** 再帰呼び出しする度に変数を初期化するために用意 */
		this.month = 0;
		this.day = 0;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println(">");

		String inputNumber = scan.nextLine();

		String[] inputDate = inputNumber.split(" ");

		if (inputDate.length != 2) {
			System.out.println("入力形式が違います。実行例（5 5）");
			return checkDate();
		}

		try {
			this.month = Integer.parseInt(inputDate[0]);
			this.day = Integer.parseInt(inputDate[1]);
		} catch (NumberFormatException e) {
			System.out.println("数字以外を入力しないでください。実行例（5 5）");
			return checkDate();
		}

		if (this.month < 1 || this.month > 12 && this.day < 1 || this.day > 31) {
			System.out.println("月日が範囲外です。実行例（5 5）");
			return checkDate();
		}

		if (this.month < 1 || this.month > 12) {
			System.out.println("月が範囲外になっています。実行例（5 5）");
			return checkDate();
		}

		if (this.day < 1 || this.day > 31) {
			System.out.println("日が範囲外になっています。実行例（5 5）");
			return checkDate();
		}

		/** 2018年の全ての月の末日を配列に格納します */
		int[] endDateOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		//入力された日が入力した月の末日を超える場合
		if (this.day > endDateOfMonth[this.month - 1]) {
			System.out.println(month + "月の末日を超えています。実行例（5 5）の形式で再入力してください");
			return checkDate();
		}
		return true;
	}

	/**
	 * 月を取得します。
	 *
	 * @return 月
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * 月を設定します。
	 *
	 * @param month 月
	　	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * 日を取得します。
	 *
	 * @return 日
	 */
	public int getDay() {
		return day;
	}

	/**
	 * 日を設定します。
	 *
	 * @param day 日
	 */
	public void setDay(int day) {
		this.day = day;
	}
}