package takizawa.exAd084A;

import takizawa.exAdInput.Input;

/**
 * 入力値が正しいかを調べます
 *
 * @author 瀧澤
 */
public class Check {
	/** 入力値M */
	private int timeM;

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
			timeM = Integer.parseInt(str[0]);
		} catch (NumberFormatException e) {
			System.out.println("文字が含まれています");
			return isValid;
		}

		// 時間が範囲内かを調べます
		if (timeM < 1 || timeM > 23) {
			System.out.println("範囲外です。");
			return isValid;
		}
		isValid = true;
		return isValid;
	}

	/**
	 * 時間を取得
	 *
	 * @return timeM 時間
	 */
	public int getTimeM() {
		return timeM;
	}

	/**
	 * 時間を設定
	 *
	 * @param timeM セットする timeM
	 */
	public void setTimeM(int timeM) {
		this.timeM = timeM;
	}
}