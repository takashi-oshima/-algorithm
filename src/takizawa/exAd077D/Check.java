package takizawa.exAd077D;

import takizawa.exAdInput.Input3;

/**
 * 入力値が正しいかを調べます。
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
		Input3 input = new Input3();
		String inputStr = input.string();

		if (!inputStr.matches("^[0-9]+$")) {
			System.out.println("全角文字が含まれています");
			return isValid;
		}

		String[] str = { inputStr };

		// 文字列の長さが1以外ならfalseを返す
		if (str.length != 1) {
			return isValid;
		}

		try {
			inputN = Integer.parseInt(str[0]);
		} catch (NumberFormatException e) {
			System.out.println("入力数値の桁が大きすぎます");
			return isValid;
		}

		// 入力値Nが範囲内かを調べます
		if (inputN < 2 || inputN > 100000 || inputStr.indexOf("0") == 0) {
			System.out.println("入力範囲外です。");
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