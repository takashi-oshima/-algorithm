package koganei.ex096A;

import java.util.Calendar;

import koganei.Input;

/**
 * 正しく入力できているか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JudgeDate {

	/** 始まりの年 */
	private final int START_YEAR = 2018;
	/** 終わりの月 */
	private int month = 0;
	/** 終わりの日 */
	private int day = 0;

	/**
	 * 入力された文字から月日を設定し、正しく設定できたかの判定結果を返します
	 *
	 * @param input 入力された文字
	 * @return 判定結果
	 */
	public boolean judgeConversion(Input input) {
		String[] inputString = input.getInputString();

		if (inputString.length != 2) {
			System.out.println("入力値は二つでなければなりません");
			return false;
		}

		try {
			month = Integer.parseInt(inputString[0]);
			day = Integer.parseInt(inputString[1]);
		} catch (Exception e) {
			System.out.println("数字に変換できませんでした");
			return false;
		}
		if (month < 1 || month > 12) {
			System.out.println("月の値が範囲外です");
			return false;
		}
		if (day < 1 || day > 31) {
			System.out.println("日の値が範囲外です");
			return false;
		}
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, START_YEAR);
		cal.set(Calendar.MONTH, month - 1);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		if (lastDay < day) {
			System.out.println(month + "月の末日は" + lastDay + "です");
			return false;
		}
		return true;
	}

	/**
	 * 月を返します
	 *
	 * @return month 月
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * 日を返します
	 *
	 * @return day 日
	 */
	public int getDay() {
		return day;
	}
}
