package exAd090B;

import exAdInput.Input;

public class IntegrityConfiration {

	String fromNumber = "";
	String toNumber = "";

	/**
	 * @return fromNumber
	 */
	public String getFromNumber() {
		return fromNumber;
	}

	/**
	 * @return toNumber
	 */
	public String getToNumber() {
		return toNumber;
	}

	/**
	 * @param fromNumber セットする fromNumber
	 */
	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}

	/**
	 * @param toNumber セットする toNumber
	 */
	public void setToNumber(String toNumber) {
		this.toNumber = toNumber;
	}

	public void scanString() {
		Input input = new Input();
		String[] inputTxt = input.scan();

		if (inputTxt.length != 2 || !inputTxt[0].matches("[1-9]{1}[0-9]{4}")
				|| !inputTxt[1].matches("[1-9]{1}[0-9]{4}")) {
			System.out.println("入力文字列が不正です");
			return;
		}
		setFromNumber(inputTxt[0]);
		setToNumber(inputTxt[1]);
	}
}