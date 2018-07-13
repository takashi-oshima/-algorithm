package exAd096A;

import exAd096A.Input.DateRange;

/**
 * 2018 年 1 月 1 日から 2018 年 a 月 b 日までに、 「月」と「日」の数値が一致している日は何日あるかを探すクラスです。
 *
 * @author 大島
 */
public class FindDayOfTakahashi {

	/**
	 * 「月」と「日」の数値が一致している日は何日あるかを探します。
	 *
	 * @param input Inputクラス
	 *
	 * @return 「月」と「日」の数値が一致している日の数
	 */
	public int findDayOfTakahashi(Input input) {
		int startMonth = DateRange.MinMonth.getRange();
		int startDay = DateRange.MinDay.getRange();

		int dayOfTakahashiCount = 0;
		for (int i = startMonth; i <= input.getInputMonth(); i++) {
			for (int j = startDay; j <= input.getInputDay(); j++) {

				if (i == j) {
					dayOfTakahashiCount++;
				}
			}
		}
		return dayOfTakahashiCount;
	}
}