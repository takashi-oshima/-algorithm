package awano.exAd096A;

/**
 * 2018年1月1日から入力された2018年a月b日まで、
 * 「高橋」の日は何日あるかカウントするクラスです。
 * 5月5日のような月の数と日の数が同じ日を「高橋」とします。
 *
 * @author 粟野真司
 *
 */
public class CountTakahashi {
	/**スタートの月*/
	int startMonth = 1;
	/**「高橋」の日をカウントする変数*/
	int count = 0;

	/**
	 * スタートの月日から入力された月日まで
	 *「高橋」の日が何日あるかカウントします。
	 *
	 * @param inputDate InputDateクラス
	 */
	public void countWhatDate(InputDate inputDate) {
		//入力された月と日が同じ場合
		if (inputDate.getMonth() == inputDate.getDay()) {
			showResult(inputDate);
		}

		//入力された月が日より小さい場合
		if (inputDate.getMonth() < inputDate.getDay()) {
			//入力された月と日が同じになるようにします。
			inputDate.setDay(inputDate.getMonth());
			showResult(inputDate);
		}

		//入力された月が日より大きい場合
		if (inputDate.getMonth() > inputDate.getDay()) {
			//同月日になるのは前月のため、月を-1します。
			inputDate.setMonth(inputDate.getMonth() - 1);
			//入力された月と日が同じになるようにします
			inputDate.setDay(inputDate.getMonth());
			showResult(inputDate);
		}
	}

	/**
	 * スタートの月日から入力された月日まで
	 * 「高橋」の日がが何日あるか表示します。
	 *
	 * @param inputDate InputDateクラス
	 */
	public void showResult(InputDate inputDate) {
		for (startMonth = 1; startMonth <= inputDate.getMonth(); startMonth++) {
			count++;
			System.out.print(count + "月" + count + "日");
		}

		if (count == 1) {
			System.out.println("のみが「高橋」です。");
		} else {
			System.out.println("。合計" + count + "日が「高橋」です。");
		}
	}
}