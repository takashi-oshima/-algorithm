package takizawa.exAd086B;

import java.math.BigDecimal;
/**
 * 正整数a,bを順に繋げて読んだものが平方数かどうかの判定をします
 *
 * @author 瀧澤
 */
public class SquareNumber {
	/**
	 * 平方数かどうかの判定
	 *
	 * @param check Checkクラス
	 */
	public void squareNumber(Check check) {

		// 入力数字1番目と2番目を文字列として読み込みます
		String regularIntegerA = String.valueOf(check.getNumberA());
		String regularIntegerB = String.valueOf(check.getNumberB());

		// 文字列を結合した後にint型の合計値とします
		int total = Integer.parseInt(regularIntegerA + regularIntegerB);

		// 合計値の平方根をBigDecimal型で返します。
		BigDecimal bdSquareRoot = new BigDecimal(Math.sqrt(total));
		// 平方根 * 平方根をして平方数を出します
		BigDecimal squareNumber = bdSquareRoot.multiply(bdSquareRoot);

		// 平方数と合計値を比較するためにBigDecimal型からint型に直します
		int squareRoot = squareNumber.intValue();

		// 合計値と平方数が等しければYES、違っていたらNOを表示します
		if(squareRoot == total) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}