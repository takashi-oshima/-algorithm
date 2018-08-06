package exAd086B;

/**
 * 実行用クラスになります。
 *
 * 入力された2つの数字を繋げて読んだものが平方数か判定し、
 * 結果を表示します
 *
 * @author 鶴田竜也
 */
public class ExAd086B {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		CalcSqrt a = new CalcSqrt();

		// 入力チェックをします
		if (inputNumber.isValidInput()) {
			// 平方数かどうかを表示します
			System.out.println(a.calcSquareNumber(inputNumber));
		}
	}
}
