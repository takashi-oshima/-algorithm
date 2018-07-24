package takai.exAd080B;

import takai.exAdInput.Input;

/**
 * 入力値の判定を行います。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfirmation {
	/** 入力値 */
	private String inputNumber = "";
	private boolean canScan = false;

	public enum NumberLength {
		Start(1), End(100000000);

		final int length;

		public int getLength() {
			return length;
		}

		private NumberLength(int length) {
			this.length = length;
		}
	}

	/**
	 * @return inputNumber
	 */
	public String getInputNumber() {
		return inputNumber;
	}

	/**
	 * @return canScan
	 */
	public boolean isCanScan() {
		return canScan;
	}

	/**
	 * @param inputNumber セットする inputNumber
	 */
	public void setInputNumber(String inputNumber) {
		this.inputNumber = inputNumber;
	}

	/**
	 * @param canScan セットする canScan
	 */
	public void setCanScan(boolean canScan) {
		this.canScan = canScan;
	}

	/**
	 * 入力値が適切かを判定し、適切であれば変数に格納します。
	 */
	public void scanTxt() {
		Input input = new Input();
		String[] inputTxt = input.scan();

		if (inputTxt.length != 1) {
			System.out.println("不適な文字列です。");
			System.out.println("1～23の整数を入力してください。");
			return;
		}

		//入力された配列を数値に変換できるか試し、変換できた場合に値が適切なものか判定します。
		if (!isIntMonth(inputTxt[0])) {
			System.out.println("不適な文字列です。");
			System.out.println("1～23の整数を入力してください。");
			return;
		}

		setInputNumber(inputTxt[0]);
		setCanScan(true);
		return;
	}

	/**
	 * 入力値が数値に変換できるかを判定します
	 *
	 * @param inputTxt 入力値
	 * @return 判定結果
	 */
	private boolean isIntMonth(String inputTxt) {
		boolean isInt = false;
		int i = 0;

		try {
			i = Integer.parseInt(inputTxt);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (NumberLength.Start.getLength() <= i && NumberLength.End.getLength() >= i) {
			isInt = true;
		}
		return isInt;
	}
}