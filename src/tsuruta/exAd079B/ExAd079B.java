package exAd079B;

/**
 * 実行用クラスになります。
 * 入力値N番目の時のリュカ数を表示します。
 *
 * @author 鶴田竜也
 */
public class ExAd079B {

	public static void main(String[] args) {
		InputNumber inputNumber =  new InputNumber();
		CalcLuca calcLuca = new CalcLuca();

		// 入力値のチェックをします
		if(inputNumber.isValidInput()) {
			// 結果を表示します
			calcLuca.calcLucasNumber(inputNumber);
		}
	}
}
