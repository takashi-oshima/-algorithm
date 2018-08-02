package exAd096A;

/**
 * 高橋（月と日が同じ数字）が何日あるかカウントし、高橋の合計を表示します。
 * 例：1月1日(高橋)
 *
 * @author 鶴田竜也
 */
public class CountTakahashi {

	/**
	 * 高橋をカウントして、高橋の合計を表示します。
	 *
	 * @param inputDate InputDateクラス
	 */
	public void showTakahshi(InputDate inputDate) {

		int count = inputDate.getMonth();
		if (count > inputDate.getDay()) {
			count--;
		}

		/** 高橋の合計を格納します */
		int total = count;
		System.out.println("合計" + total + "日が「高橋」です");
	}
}