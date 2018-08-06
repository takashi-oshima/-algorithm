package exAd086B;

/**
 * 入力された数字が平方数か判定するクラスになります。
 *
 * @author 鶴田竜也
 */
public class CalcSqrt {

	/**
	 * 入力された文字列AとBを繋げて読んだものが平方数かどうか確かめます。
	 * 平方数であれば"Yes"を、平方数でなければ"No"返します。
	 *
	 * @param inputNumber
	 * @return 平方数の可否
	 */
	public String calcSquareNumber(InputNumber inputNumber) {

		// 入力された値を文字列に変換します
		String strNumberA = String.valueOf(inputNumber.getNumberA());
		String strNumberB = String.valueOf(inputNumber.getNumberB());

		double ab = Double.parseDouble(strNumberA + strNumberB);

		// abが平方数なら"Yes"、平方数でなければ"No"を返します
		if (ab == (int) (Math.sqrt(ab) * (int) Math.sqrt(ab))) {
			return "yes";
		} else {
			return "No";
		}
	}
}
