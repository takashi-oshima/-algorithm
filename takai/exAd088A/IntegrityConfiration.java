package takai.exAd088A;

import takai.exAdInput.Input;

/**
 * 入力値が適切か判定し、変数に格納するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfiration {
	/** 支払う金額 */
	int payment;
	/** 1円硬貨の枚数 */
	int coinCount;

	/**
	 * @return payment
	 */
	public int getPayment() {
		return payment;
	}

	/**
	 * @return coinCount
	 */
	public int getCoinCount() {
		return coinCount;
	}

	/**
	 * @param payment セットする payment
	 */
	public void setPayment(int payment) {
		this.payment = payment;
	}

	/**
	 * @param coinCount セットする coinCount
	 */
	public void setCoinCount(int coinCount) {
		this.coinCount = coinCount;
	}

	public enum AmountLength {
		Min(1), Max(10000);

		final int length;

		public int getLength() {
			return length;
		}

		private AmountLength(int length) {
			this.length = length;
		}
	}

	public enum CoinCountLength {
		Min(0), Max(1000);

		final int count;

		public int getCount() {
			return count;
		}

		private CoinCountLength(int count) {
			this.count = count;
		}
	}

	/**
	 * 入力値を受け取り、判定を行います。
	 */
	public void scanString() {
		final int TEXT_LENGTH = 2;
		Input input = new Input();
		String[] inputTxt = input.scan();

		if (inputTxt.length != TEXT_LENGTH) {
			System.out.println("入力文字列が不正です。");
			return;
		}

		if (!isIntPayment(inputTxt[0]) || !isInt1yenCount(inputTxt[1])) {
			System.out.println("入力値が不正です。");
			return;
		}
		setPayment(Integer.parseInt(inputTxt[0]));
		setCoinCount(Integer.parseInt(inputTxt[1]));
	}

	/**
	 * 支払う金額の入力が数値かどうか、また、指定範囲内かどうかを判定します。
	 *
	 * @param amount 支払う金額
	 * @return 判定結果
	 */
	private boolean isIntPayment(String amount) {
		boolean isInt = false;
		int i;

		try {
			i = Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (AmountLength.Min.getLength() <= i && i <= AmountLength.Max.getLength()) {
			isInt = true;
		}
		return isInt;
	}

	/**
	 * 1円硬貨の枚数が数値かどうか、また、指定範囲内かどうかを判定します。
	 *
	 * @param count 1円硬貨の枚数
	 * @return 判定結果
	 */
	private boolean isInt1yenCount(String count) {
		boolean isInt = false;
		int i;

		try {
			i = Integer.parseInt(count);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (CoinCountLength.Min.getCount() <= i && i <= CoinCountLength.Max.getCount()) {
			isInt = true;
		}
		return isInt;
	}
}