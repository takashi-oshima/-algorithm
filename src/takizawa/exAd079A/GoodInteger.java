package takizawa.exAd079A;

/**
 * 1118のような、３つ以上の同じ数字が連続して並んだ４桁の数値を良い数値とします。
 * ４桁の整数Nが与えられたとき、Nが良い整数かどうかを判定します。
 *
 * @author 瀧澤
 */
public class GoodInteger {
	/**
	 * 入力した数字に、３つ以上の連続した数字があるか調べます
	 *
	 * @param check Checkクラス
	 */
	public void goodInteger(Check check) {
		String number = String.valueOf(check.getInputN());
		for (int i = 0; i <= 9; i++) {

			// numberに部分一致する3桁以上の連続数字があればYESを表示します
			if (number.matches(".*" + i + i + i + ".*")) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
}