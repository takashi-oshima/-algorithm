package exAd080B;

/**
 * 実行用クラスになります。
 *
 * @author 鶴田竜也
 */
public class ExAd080B {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		HarshadNumber harshadNumber = new HarshadNumber();

		// 入力チェックをします
		if (inputNumber.isValidInput()) {
			// 入力値がシャーハッド数か否かを表示します
			System.out.println(harshadNumber.calcHarshadNumber(inputNumber));
		}
	}
}
