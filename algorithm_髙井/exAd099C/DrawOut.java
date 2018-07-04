package exAd099C;

import exAd099C.ExAd099C.Amount;

/**
 * 格納された変数から、何回操作が必要になるか求めるクラスです。
 *
 * @author 高井勇輝
 *
 */
public class DrawOut {

	public int actCount(IntegrityConfirmation integrityConfirmation) {
		double inputNumber = integrityConfirmation.getInputNumber();
		double amount = integrityConfirmation.getInputNumber();
		int actCount = 0;

		while (amount != 0) {
			for (int i = 1; amount >= Math.pow(Amount.Nine.getAmount(), i); i++) {
				amount = inputNumber - Math.pow(Amount.Nine.getAmount(), i);
			}

			if (inputNumber != amount) {
				actCount++;
			}
			inputNumber = amount;

			for (int i = 1; amount >= Math.pow(Amount.Six.getAmount(), i); i++) {
				amount = inputNumber - Math.pow(Amount.Six.getAmount(), i);
			}

			if (inputNumber != amount) {
				actCount++;
			}
			inputNumber = amount;

			if (amount > Amount.Six.getAmount()) {
				continue;
			}

			while (amount != 0) {
				amount--;
				actCount++;
			}
		}
		return actCount;
	}
}