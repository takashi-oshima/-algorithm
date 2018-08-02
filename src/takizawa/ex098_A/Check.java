package takizawa.ex098_A;

import takizawa.exAdInput.Input;

/**
 * 入力値が正しいかを調べます
 *
 * @author 瀧澤
 */
public class Check {
	/** 入力値A */
	private int numberA;
	/** 入力値B */
	private int numberB;

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
			numberA = Integer.parseInt(str[0]);
			numberB = Integer.parseInt(str[1]);
		} catch (NumberFormatException e) {
			System.out.println("文字が含まれています");
			return isValid;
		}

		// 入力値A、入力値Bが範囲内かを調べます
		if (numberA < -1000 || numberA > 1000 || numberB < -1000 || numberB > 1000) {
			System.out.println("範囲外です");
			return isValid;
		}
		isValid = true;
		return isValid;
	}

	/**
	 * 1つ目の整数を取得します
	 *
	 * @return numberA 1つ目の整数
	 */
	public int getNumberA() {
		return numberA;
	}

	/**
	 * 1つ目の整数を設定します
	 *
	 * @param numberA セットする numberA
	 */
	public void setNumberA(int numberA) {
		this.numberA = numberA;
	}

	/**
	 * 2つ目の整数を取得します
	 *
	 * @return numberB 2つ目の整数
	 */
	public int getNumberB() {
		return numberB;
	}

	/**
	 * 2つ目の整数を設定します
	 *
	 * @param numberB セットする numberB
	 */
	public void setNumberB(int numberB) {
		this.numberB = numberB;
	}
}