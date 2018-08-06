package exAd088A;

/**
 * 実行用クラス
 *
 * @author 鶴田竜也
 */
public class ExAd088A {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		Payment payment = new Payment();

		// 入力の妥当性をチェックします
		if (inputNumber.isValidInput()) {
			// 支払い可能かどうかを表示します
			System.out.println(payment.calcPay(inputNumber));
		}
	}
}
