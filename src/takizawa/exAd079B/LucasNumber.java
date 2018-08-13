package takizawa.exAd079B;
/**
 * 整数Nが与えられたときの、N番目のリュカ数を求めます。
 *
 * @author 瀧澤
 */
public class LucasNumber {
	/**
	 * N番目のリュカ数を求めます
	 *
	 * @param check Checkクラス
	 */
	public void lucasNumber(Check check) {
		// 入力値Nをnumberに格納
		int number = check.getInputN();
		// int型の最大値を超えてしまうため、long型配列で準備します
		long[] lucaNumber = new long[87];
		lucaNumber[0] = 2; // 0番目にあらかじめ2を入れておく
		lucaNumber[1] = 1; // 1番目にあらかじめ1を入れておく

		// リュカ数を配列に格納します
		for (int i = 2; i < lucaNumber.length; i++) {
			lucaNumber[i] = lucaNumber[i - 2] + lucaNumber[i - 1];
		}

		for (int i = 0; i < lucaNumber.length; i++) {

			// number番目の要素を取得します
			if (i == number) {
				System.out.println(lucaNumber[i]);
				return;
			}
		}
	}
}