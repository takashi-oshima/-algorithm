package takai.exAd079A;

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
	/** 入力値が適切かどうか */
	private boolean canScan = false;

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
			System.out.println("1000～9999の整数を入力してください。");
			return;
		}

		//入力された値が指定した形式と一致しているかを確認します
		if (!inputTxt[0].matches("[1-9]{1}[0-9]{3}")) {
			System.out.println("不適な文字列です。");
			System.out.println("1000～9999の整数を入力してください。");
			return;
		}

		setInputNumber(inputTxt[0]);
		setCanScan(true);
		return;
	}
}