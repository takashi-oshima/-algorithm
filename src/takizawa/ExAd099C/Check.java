package takizawa.ExAd099C;

import takizawa.exAdInput.Input;

/**
 * 入力値をチェックします
 *
 * @author 瀧澤
 */
public class Check {
	private int number;

	/**
	 * 入力値に文字が含まれているか、範囲内かなどを調べます
	 *
	 * @return
	 */
	public boolean valid() {
		boolean isValid = false;
		Input input = new Input();
		String[] str = input.string();

		if (str.length != 1) {
			return isValid;
		}

		try {
			number = Integer.parseInt(str[0]);
		} catch (NumberFormatException e) {
			System.out.println("文字が含まれています");
		}

		if (number < 1 || number > 100000) {
			System.out.println("入力値が範囲外です");
			return isValid;
		}
		isValid = true;
		return isValid;
	}

	/**
	 * 数値を取得します
	 *
	 * @return number 数値
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 数値を設定します
	 *
	 * @param number1 セットする number1
	 */
	public void setNumber(int number1) {
		this.number = number1;
	}
}