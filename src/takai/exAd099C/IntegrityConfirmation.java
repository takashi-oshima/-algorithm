package takai.exAd099C;

import takai.exAd099C.ExAd099C.IntLength;
import takai.exAdInput.Input;

/**
 * 入力値の整合性を判定し、適切であれば変数に格納するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfirmation {

	double inputNumber = 0;

	/**
	 * @return inputNumber
	 */
	public double getInputNumber() {
		return inputNumber;
	}

	/**
	 * @param inputNumber セットする inputNumber
	 */
	public void setInputNumber(double inputNumber) {
		this.inputNumber = inputNumber;
	}

	/**
	 * 入力値を取得し、適切か判定を行います。
	 * 適切であれば変数に格納します。
	 */
	public void scanString() {
		Input input = new Input();
		String[] inputTxt = input.scan();

		//数値が2つ入力されているかを確認します。
		if (inputTxt.length != 1) {
			System.out.println("入力された文字列が不正です。");
			System.out.println("1～100000の整数を入力してください。");
			return;
		}

		//入力された配列を数値に変換できるか試し、変換できた場合に値が適切なものか判定します。
		if (!isIntNumber(inputTxt[0])) {
			System.out.println("不適な文字列です。");
			System.out.println("1以上、100000以下の整数を入力してください。");
			return;
		}
		setInputNumber(Double.parseDouble(inputTxt[0]));
	}

	/**
	 * 入力値を整数に変換できるか判定します。
	 * 変換できた際には1～100の数値であるかも判定します。
	 *
	 * @param inputTxt 入力文字列
	 * @return isInt 判定結果
	 */
	private static boolean isIntNumber(String inputTxt) {
		boolean isInt = false;
		int i = 0;
		try {
			i = Integer.parseInt(inputTxt);
		} catch (NumberFormatException e) {
			return isInt;
		}
		if (IntLength.Min.getLength() <= i && IntLength.Max.getLength() >= i) {
			isInt = true;
		}
		return isInt;
	}
}
