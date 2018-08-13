package takizawa.exAd085C;

import takizawa.exAdInput.Input;

/**
 * 入力値が正しいかを調べます
 *
 * @author 瀧澤
 */
public class Check {
	/** 入力値N */
	private int inputN;
	/** 入力値Y */
	private int inputY;

	/**
	 * 入力値が必要文字数あるか、文字が含まれていないか、範囲内かを調べます
	 *
	 * @return isValid 入力値が正しいか
	 */
	public boolean valid() {
		boolean isValid = false;
		Input input = new Input();
		String[] str = input.string();

		// 文字列の長さが2以外ならfalseを返す
		if (str.length != 2) {
			return isValid;
		}

		try {
			inputN = Integer.parseInt(str[0]);
			inputY = Integer.parseInt(str[1]);
		} catch (NumberFormatException e) {
			System.out.println("文字が含まれています");
			return isValid;
		}

		// 入力値N、入力値Yが範囲内かを調べます
		if (inputN < 1 || inputN > 2000 || inputY < 1000 || inputY > 20000000) {
			System.out.println("範囲外です。");
			return isValid;
		}
		isValid = true;
		return isValid;
	}

	/**
	 * 札の枚数を取得します
	 *
	 * @return count 札の枚数
	 */
	public int getInputN() {
		return inputN;
	}

	/**
	 * 札の枚数を設定します
	 *
	 * @param inputN セットする numberN
	 */
	public void setInputN(int inputN) {
		this.inputN = inputN;
	}

	/**
	 * 金額を取得します
	 *
	 * @return money 2つ目の整数
	 */
	public int getInputY() {
		return inputY;
	}

	/**
	 * 金額整数を設定します
	 *
	 * @param inputY セットする numberY
	 */
	public void setInputY(int inputY) {
		this.inputY = inputY;
	}
}