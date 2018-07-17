package oshima.exAd096A;

import java.util.Scanner;

/**
 * Inputクラスは、標準入力を管理するクラスです。
 *
 * @author 大島
 */
public class Input {
	/** 入力した月の値 */
	private int inputMonth = 0;
	/** 入力した日の値 */
	private int inputDay = 0;

	/**
	 * DateRangeは、年の初期値と月、日の範囲の最小と最大を表す列挙型です。
	 *
	 * @author 大島
	 */
	public enum DateRange {
		/** 月の最小範囲 */
		MinMonth(1),
		/** 月の最大範囲 */
		MaxMonth(12),
		/** 日の最小範囲 */
		MinDay(1),
		/** 日の最大範囲 */
		MaxDay(31);

		final int range;

		public int getRange() {
			return range;
		}

		private DateRange(int range) {
			this.range = range;
		}
	}

	/**
	 * 標準入力を受け付け、入力値をチェックします。
	 *
	 * @return 入力した値が適切かどうかです。
	 */
	public boolean canInput() {
		boolean canInput = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String[] inputDate = scanner.nextLine().split(" ");

		try {
			inputMonth = Integer.parseInt(inputDate[0]);
			inputDay = Integer.parseInt(inputDate[1]);
		} catch (NumberFormatException e) {
			return canInput;
		}

		if (inputDate.length != 2) {
			return canInput;
		}

		if (inputMonth < DateRange.MinMonth.getRange() || inputMonth > DateRange.MaxMonth.getRange()
				|| inputDay < DateRange.MinDay.getRange() || inputDay > DateRange.MaxDay.getRange()) {
			return canInput;
		}
		canInput = true;
		return canInput;
	}

	/**
	 * @return inputMonth
	 */
	public int getInputMonth() {
		return inputMonth;
	}

	/**
	 * @param inputMonth セットする inputMonth
	 */
	public void setInputMonth(int inputMonth) {
		this.inputMonth = inputMonth;
	}

	/**
	 * @return inputDay
	 */
	public int getInputDay() {
		return inputDay;
	}

	/**
	 * @param inputDay セットする inputDay
	 */
	public void setInputDay(int inputDay) {
		this.inputDay = inputDay;
	}
}
