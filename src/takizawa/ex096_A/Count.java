package takizawa.ex096_A;

/**
 * 王国では、5月5日のような月の数と日の数が同じ日を「高橋」といいます。
 * 2018年1月1日から2018年a月b日までに、「高橋」は何日あるかを求めます。
 *
 * @author
 */
public class Count {
	/**
	 * 1月1日から入力値までの高橋を探します
	 *
	 * @param check checkのgetNumberAとgetNumberBを呼び出す
	 * @return takahashiCount 高橋の数
	 */
	public int takahashi(Check check) {

		// Checkで指定したnumberAを入力月とする
		int inputMonth = check.getNumberA();
		// Checkで指定したnumberBを入力日とする
		int inputDay = check.getNumberB();
		// countに入力月を代入
		int takahashiCount = inputMonth;

		// 入力月が入力日より値が大きいとき、入力月-1をする。
		if (inputMonth > inputDay) {
			takahashiCount--;
		}
		return takahashiCount;
	}
}