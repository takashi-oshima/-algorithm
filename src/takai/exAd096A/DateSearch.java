package takai.exAd096A;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import takai.exAd096A.IntegrityConfirmation.Days;

/**
 * カレンダーの初期値を設定し、指定日までにある高橋の探索と、出力用文字列の生成を行うクラスです。
 *
 * @author 高井勇輝
 *
 */
public class DateSearch {
	Calendar calendar = Calendar.getInstance();
	int count = 0;
	/** 出力用の文字列を格納します */
	List<String> outputTxt = new ArrayList<>();

	/**
	 * (YYYY/01/01)に日付をセットします。
	 */
	public void setCalendar() {
		calendar.get(Calendar.YEAR);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, Days.First.getDay());
	}

	/**
	 * 初期値から日付を増やしていき、指定した日付までに高橋が何日あるかを調べます。
	 *
	 * @param input Inputクラス
	 */
	public void setInputDate(IntegrityConfirmation input) {
		while (calendar.before(input.inputDate)) {
			//(YYYY/01/01)にセットしたものから月の数値と日の数値が同じ日があれば
			//出力用配列に格納し、countを1増やします。
			if (calendar.get(Calendar.MONTH) + 1 == calendar.get(Calendar.DATE)) {
				outputTxt.add(getCalendarString(calendar));
				count++;
			}

			//日を増やしていくので、整合性の確認を行います。
			input.inputDate.setLenient(false);
			try {
				calendar.add(Calendar.DATE, 1);
			} catch (Exception e) {
				//整合性が取れなくなったら、次の月に進み、日を1日に戻します。
				calendar.add(Calendar.MONTH, 1);
				calendar.set(Calendar.DATE, Days.First.getDay());
			}
		}
	}

	/**
	 * 出力文字列を返します。
	 *
	 * @return 出力文字列
	 */
	public String getDate() {
		//1日しかなかった時の出力文です。
		if (count == 1) {
			return getCalendarString(calendar) + "のみが「高橋」です。";
		}

		//数日あった時の出力文です。
		for (int i = 0; i < outputTxt.size(); i++) {
			System.out.print(outputTxt.get(i));
			if (i == outputTxt.size() - 1) {
				System.out.print("。");
			} else {
				System.out.print("、");
			}
		}
		return "合計" + count + "日が「高橋」です。";
	}

	/**
	 * 出力用文字列を生成します。
	 *
	 * @param tmpCal 月と日の値が同じだったカレンダーの日
	 * @return 出力用文字列
	 */
	private String getCalendarString(Calendar tmpCal) {
		/** 出力月 */
		int month = tmpCal.get(Calendar.MONTH) + 1;
		/** 出力日 */
		int date = tmpCal.get(Calendar.DATE);
		return String.valueOf(month + "月" + date + "日");
	}
}