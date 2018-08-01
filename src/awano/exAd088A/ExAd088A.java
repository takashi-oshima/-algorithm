package awano.exAd088A;
/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd088A {
	public static void main(String[] args) {
		InputMoney inputMoney = new InputMoney();
		Payment payment = new Payment();

		//正しい金額が入力されていた場合
		if (inputMoney.checkMoney()) {

			//支払いができるかどうか
			if (payment.canPayment(inputMoney)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}