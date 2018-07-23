package koganei.ex096A;

/**
 * 「高橋」の数をカウントするクラスです
 *
 * @author 小金井 広輝
 */
public class TakahashiCount {

	/** 始まりの月*/
	final int START_MONTH = 2;
	/** 始まりの日*/
	final int START_DAY = 2;

	/**
	 * 始まりの年月日から指定された日付までに「高橋」は何日あるかを求めます
	 * ※高橋は5月5日のようなaとbが同じ数字のものをさします
	 *
	 * @param inputJudge
	 * @return 「高橋」の数
	 */
	public int getTakahashiCount(JudgeDate inputJudge) {
		int endMonth = inputJudge.getMonth();
		int endDay = inputJudge.getDay();
		int count = 0;

		if(START_MONTH > endMonth || START_DAY > endDay) {
			return count;
		}

		if (START_DAY <= START_MONTH) {
			count++;
		}

		if (START_MONTH != endMonth) {
			count = count + (endMonth - 1) - START_MONTH;
			if (endMonth <= endDay) {
				count++;
			}
		}
		return count;
	}
}
