package takai.exAd086B;

import takai.exAdInput.Input;

/**
 * 入力値が適切かの判定を行うクラスです。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfiration {
	/** 二つの入力値を繋げた値 */
	private int answer;
	/** 入力値が適切かどうか */
	private boolean canScan = false;

	/**
	 * @return answer
	 */
	public int getAnswer() {
		return answer;
	}

	/**
	 * @return canScan
	 */
	public boolean isCanScan() {
		return canScan;
	}

	/**
	 * @param answer セットする answer
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}

	/**
	 * @param canScan セットする canScan
	 */
	public void setCanScan(boolean canScan) {
		this.canScan = canScan;
	}

	public enum IntLength {
		Min(1), Max(100);

		final int number;

		public int getNumber() {
			return number;
		}

		private IntLength(int number) {
			this.number = number;
		}
	}

	/**
	 * 入力値が適切か判定します。
	 */
	public void scanString() {
		final int TEXT_LENGTH = 2;
		Input input = new Input();
		String[] inputTxt = input.scan();

		if (inputTxt.length != TEXT_LENGTH) {
			System.out.println("入力文字列が不正です。");
			System.out.println("2つの整数を入力してください。");
			return;
		}

		if (!isIntNumber(inputTxt[0]) || !isIntNumber(inputTxt[1])) {
			System.out.println("入力値が不正です。");
			System.out.println("2つの整数を入力してください。");
			return;
		}
		String number = inputTxt[0] + inputTxt[1];
		setAnswer(Integer.parseInt(number));
		setCanScan(true);
	}

	/**
	 * 入力されたものが数値かどうか、また、指定範囲内かどうかを判定します。
	 *
	 * @param amount 支払う金額
	 * @return 判定結果
	 */
	private boolean isIntNumber(String number) {
		boolean isInt = false;
		int i;

		try {
			i = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (IntLength.Min.getNumber() <= i && i <= IntLength.Max.getNumber()) {
			isInt = true;
		}
		return isInt;
	}
}