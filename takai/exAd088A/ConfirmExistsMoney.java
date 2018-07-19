package takai.exAd088A;

/**
 * 指定された金額を支払うことができるかを判定するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class ConfirmExistsMoney {
	public void canPayment(int payment, int coinCount) {
		final int FIVE_HUNDRED_YEN = 500;
		boolean canPayment = false;

		int remainingMoney = payment % FIVE_HUNDRED_YEN;

		if (0 == remainingMoney) {
			canPayment = true;
			return;
		}

		if (0 >= remainingMoney - coinCount) {
			canPayment = true;
		}

		if (canPayment) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		return;
	}
}