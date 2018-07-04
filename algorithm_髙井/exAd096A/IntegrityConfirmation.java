package exAd096A;

import java.util.Calendar;

import exAdInput.Input;

/**
 * 入力値および日付の整合性を確認するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfirmation {
	/** 一つ目の入力値 */
	int inputMonth = 0;
	/** 二つ目の入力値 */
	int inputDay = 0;
	/** */
	Calendar inputDate = Calendar.getInstance();

	public enum Days {
		StartDay(0), First(1), EndDay(32);

		final int day;

		public int getDay() {
			return day;
		}

		private Days(int day) {
			this.day = day;
		}
	}

	public enum Month {
		StartMonth(0), EndMonth(13);

		final int month;

		public int getMonth() {
			return month;
		}

		private Month(int month) {
			this.month = month;
		}
	}

	/**
	 * キーボードから入力値を取得し、入力値が正しいものか判定します。
	 */
	public void scanTxt() {
		Input input = new Input();
		String[] inputTxt = input.scan();

		//数値が2つ入力されているかを確認します。
		if (inputTxt.length != 2) {
			System.out.println("入力された文字列が不正です。");
			System.out.println("2つの正数を半角空白区切りで入力してください。");
			return;
		}

		//入力された配列を数値に変換できるか試し、変換できた場合に値が適切なものか判定します。
		if (!isIntMonth(inputTxt[0]) || !isIntDays(inputTxt[1])) {
			System.out.println("不適な文字列です。");
			System.out.println("半角空白区切りで1～12の整数と、1～31の整数を入力してください。");
			return;
		}

		//Calendarクラスの月は0が1月のため、数値を合わせるために入力された値から1引きます。
		inputMonth = Integer.parseInt(inputTxt[0]);
		inputMonth -= 1;
		inputDay = Integer.parseInt(inputTxt[1]);

		//日付の整合性を確認し、(YYYY/入力値1/入力値2)に日付をセットします。
		inputDate.get(Calendar.YEAR);
		dateCheck(inputDate);
	}

	/**
	 * 入力月が数値に変換できるか試します。
	 * 変換できたときは1～12の数値が入力されているか確認します。
	 *
	 * @param inputTxt	入力文字列
	 * @return isInt 判定結果
	 */
	private boolean isIntMonth(String inputTxt) {
		boolean isInt = false;
		int i = 0;
		try {
			i = Integer.parseInt(inputTxt);
		} catch (NumberFormatException e) {
			return isInt;
		}
		if (Month.StartMonth.getMonth() < i && Month.EndMonth.getMonth() > i) {
			isInt = true;
		}
		return isInt;
	}

	/**
	 * 入力日が数値に変換できるか試します。
	 * 変換できたときは1～31の数値が入力されているか確認します。
	 *
	 * @param inputTxt	入力文字列
	 * @return isInt 判定結果
	 */
	private boolean isIntDays(String inputTxt) {
		boolean isInt = false;
		int i = 0;
		try {
			i = Integer.parseInt(inputTxt);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (Days.StartDay.getDay() < i && Days.EndDay.getDay() > i) {
			isInt = true;
		}
		return isInt;
	}

	/**
	 * 入力された値が適切な日付かを判定し、inputDateとして格納します。
	 *
	 * @param inputDate 指定した日付
	 */
	private void dateCheck(Calendar inputDate) {
		inputDate.setLenient(false);
		try {
			inputDate.set(Calendar.MONTH, inputMonth);
			inputDate.set(Calendar.DATE, inputDay);
		} catch (Exception e) {
			System.out.println("入力された日付は存在しません。");
			return;
		}
	}
}