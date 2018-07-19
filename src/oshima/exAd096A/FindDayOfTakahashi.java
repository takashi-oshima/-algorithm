package oshima.exAd096A;

import oshima.exAd096A.Input.DateRange;

/**
 * 2018 年 1 月 1 日から 2018 年 a 月 b 日までに、 「月」と「日」の数値が一致している日は何日あるかを探すクラスです。
 *
 * @author 大島
 */
public class FindDayOfTakahashi {

	/**
	 * 1 月 1 日から a 月 b 日までに、「月」と「日」の数値が一致している日は何日あるかを探します。 年度は2018年から変わらないものとします。
	 *
	 * @param input Inputクラス
	 * @return 「月」と「日」の数値が一致している日の数
	 */
	public int findDayOfTakahashi(Input input) {
		int startMonth = DateRange.StartMonth.getRange();
		int startDay = DateRange.StartDay.getRange();
		int endMonth = input.getInputMonth();
		int endDay = input.getInputDay();
		int dayOfTakahashiCount = 0;

		// 年度が変わっている場合、処理を終了します。
		if (endMonth < startMonth || endMonth == startMonth && endDay < startDay) {
			return -1;
		}

		if (startMonth <= startDay) {
			dayOfTakahashiCount = endMonth - startMonth;

			if (startMonth == startDay) {
				dayOfTakahashiCount++;
			}

			if (endMonth > endDay) {
				dayOfTakahashiCount--;
			}
		}

		if (startMonth > startDay) {
			dayOfTakahashiCount = endMonth - startMonth;

			if (endMonth <= endDay) {
				dayOfTakahashiCount++;
			}
		}
		return dayOfTakahashiCount;
	}
}