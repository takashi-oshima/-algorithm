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
	/** 一つ目の入力値 */
	private int fromNumber = 0;
	/** 二つ目の入力値 */
	private int toNumber = 0;
	/** 入力値が適切かどうか */
	private boolean isRightness = false;

	/**
	 * @return fromNumber
	 */
	public int getFromNumber() {
		return fromNumber;
	}

	/**
	 * @return toNumber
	 */
	public int getToNumber() {
		return toNumber;
	}

	/**
	 * @return isRightness
	 */
	public boolean isRightness() {
		return isRightness;
	}

	/**
	 * @param fromNumber セットする fromNumber
	 */
	public void setFromNumber(int fromNumber) {
		this.fromNumber = fromNumber;
	}

	/**
	 * @param toNumber セットする toNumber
	 */
	public void setToNumber(int toNumber) {
		this.toNumber = toNumber;
	}

	/**
	 * @param isRightness セットする isRightness
	 */
	public void setRightness(boolean isRightness) {
		this.isRightness = isRightness;
	}

	/**
	 * 入力値の確認を行います。
	 */
	public void scanString() {
		Input input = new Input();
		String[] inputTxt = input.scan();

		if (inputTxt.length != 2 || !inputTxt[0].matches("[1-9]{1}[0-9]{4}")
				|| !inputTxt[1].matches("[1-9]{1}[0-9]{4}")) {
			System.out.println("入力値が不正です。入力値2が入力値1以上となるようにしてください");
			return;
		}

		if (inputTxt[0].compareTo(inputTxt[1]) > 0) {
			System.out.println("入力値が不正です。入力値2が入力値1以上となるようにしてください");
		}
		setFromNumber(Integer.parseInt(inputTxt[0]));
		setToNumber(Integer.parseInt(inputTxt[1]));
		setRightness(true);
	}
}