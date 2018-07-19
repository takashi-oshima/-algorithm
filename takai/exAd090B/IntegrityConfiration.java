package takai.exAd090B;

import takai.exAdInput.Input;

/**
 * 入力値が適切なものか判定を行うクラスです。
 * 適切であれば変数に格納します。
 *
 * @author 高井勇輝
 *
 */
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

	/**
	 * 入力値の確認を行います。
	 */
	public void scanString() {
		Input input = new Input();
		String[] inputTxt = input.scan();

		if (inputTxt.length != 2 || !inputTxt[0].matches("[1-9]{1}[0-9]{4}")
				|| !inputTxt[1].matches("[1-9]{1}[0-9]{4}")) {
			System.out.println("入力文字列が不正です。");
			return;
		}

		if (!(inputTxt[0].compareTo(inputTxt[1]) < 0)) {
			System.out.println("入力値が不正です。入力値2が入力値1以上となるようにしてください");
		}
		setFromNumber(inputTxt[0]);
		setToNumber(inputTxt[1]);
	}
}