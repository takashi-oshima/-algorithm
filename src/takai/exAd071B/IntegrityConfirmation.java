package takai.exAd071B;

import takai.exAdInput.Input;

public class IntegrityConfirmation {
	private String inputString = "";
	private boolean canScan = false;

	public enum TxtLength {
		Min(1),Max(100000);

		final int length;

		public int getLength() {
			return length;
		}

		private TxtLength(int length) {
			this.length = length;
		}
	}

	/**
	 * @return inputString
	 */
	public String getInputString() {
		return inputString;
	}

	/**
	 * @return canScan
	 */
	public boolean isCanScan() {
		return canScan;
	}

	/**
	 * @param inputString セットする inputString
	 */
	public void setInputString(String inputString) {
		this.inputString = inputString;
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
			System.out.println("2～100000の整数を入力してください。");
			return;
		}

		//入力された配列を数値に変換できるか試し、変換できた場合に値が適切なものか判定します。
		if (!isTxt(inputTxt[0])) {
			System.out.println("不適な文字列です。");
			System.out.println("2～100000の整数を入力してください。");
			return;
		}

		setInputString(inputTxt[0]);
		setCanScan(true);
		return;
	}

	private boolean isTxt(String inputTxt) {
		String[] splitTxt = inputTxt.replaceAll("[^a-z]", "").split("");

		if(splitTxt.length < TxtLength.Min.getLength() || splitTxt.length > TxtLength.Max.getLength()) {
			return false;
		}
		return true;
	}
}
