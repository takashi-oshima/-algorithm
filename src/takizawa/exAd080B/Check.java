package takizawa.exAd080B;

import takizawa.exAdInput.Input;

/**
 * 入力値をチェックします
 *
 * @author 瀧澤
 */
public class Check {
	/** 入力値X */
	private int inputX;

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
			inputX = Integer.parseInt(str[0]);
		} catch (NumberFormatException e) {
			System.out.println("文字が含まれています");
			return isValid;
		}

		// 入力値Xが範囲内かを調べます
		if (inputX < 1 || inputX > 100000000) {
			System.out.println("範囲外です。");
			return isValid;
		}
		isValid = true;
		return isValid;
	}

	/**
	 * 入力値Xの取得
	 *
	 * @return inputX 入力値X
	 */
	public int getInputX() {
		return inputX;
	}

	/**
	 * 入力値Xの設定
	 *
	 * @param inputX セットする inputX
	 */
	public void setInputX(int inputX) {
		this.inputX = inputX;
	}
}