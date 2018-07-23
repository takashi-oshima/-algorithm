package oshima.exAd088A;

/**
 * 1 円硬貨を A 枚と 500 円硬貨を無限枚持っているとします。
 * これらの硬貨だけを使うことによって、ちょうど N 円支払うことができるか判定します。
 *
 * @author 大島
 */
public class CanPayOnly500And1Yen {

	/**
	 * 指定した額が、500円と指定した数の1円を使って丁度支払えるかを判定します。
	 *
	 * @param input Inputクラス
	 * @return 支払いできるかどうか
	 */
	public boolean canPayment(Input input) {
		boolean canPayment = false;
		final int FIVE_HANDRED_YEN = 500;
		int paymentN = input.getIntegerN();
		int remainingOneYen = input.getIntegerA();

		// 支払額が0円になるか所持1円がなくなるまでループします。
		while (paymentN != 0) {

			if(paymentN % FIVE_HANDRED_YEN == 0) {
				break;
			}

			if (paymentN >= FIVE_HANDRED_YEN) {
				paymentN -= FIVE_HANDRED_YEN;
			}

			if (remainingOneYen != 0 && paymentN < FIVE_HANDRED_YEN) {
				remainingOneYen--;
				paymentN--;
			}

			if (remainingOneYen == 0) {
				break;
			}
		}

		if (paymentN % FIVE_HANDRED_YEN == 0) {
			canPayment = true;
		}
		return canPayment;
	}
}
