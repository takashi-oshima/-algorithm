package takizawa.exAd079A;

import takizawa.exAdInput.Input;

/**
 * 入力値をチェックします
 *
 * @author 瀧澤
 */
public class Check {
	/** 入力値N */
	private int inputN;

	/**
	 * 入力値が必要文字数あるか、文字が含まれていないか、範囲内かを調べます
	 *
	 * @return isValid 入力値が正しいか
	 */
	public boolean valid() {
		boolean isValid = false;
		Input input = new Input();
		String[] str = input.string();

		// 文字列の長さが1以外ならfalseを返す
		if (str.length != 1) {
			return isValid;
		}

		try {
			inputN = Integer.parseInt(str[0]);
		} catch (NumberFormatException e) {
			System.out.println("文字が含まれています");
			return isValid;
		}

		// 入力値Nが範囲内かを調べます
		if (inputN < 1000 || inputN > 9999) {
			System.out.println("範囲外です。");
			return isValid;
		}
		isValid = true;
		return isValid;
	}

	/**
	 * 入力値Nの取得
	 *
	 * @return inputN 入力値N
	 */
	public int getInputN() {
		return inputN;
	}

	/**
	 * 入力値Nの設定
	 *
	 * @param inputN セットする inputN
	 */
	public void setInputN(int inputN) {
		this.inputN = inputN;
	}
}
