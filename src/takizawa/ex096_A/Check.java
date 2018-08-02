package takizawa.ex096_A;

import takizawa.exAdInput.Input;

/**
 * 入力値が正しいかを調べます
 *
 * @author 瀧澤
 */
public class Check {
	/** 入力値1つ目 */
	private int numberA;
	/** 入力値2つ目 */
	private int numberB;

	/**
	 * 入力値が必要文字数あるか、文字は含まれていないかを調べます
	 *
	 * @return isValid 正しいか
	 */
	public boolean valid() {
		boolean isValid = false;
		Input input = new Input();
		String[] str = input.string();

		if (str.length != 2) {
			System.out.println("入力値は1文字目と2文字目をスペースで\n区切った2文字で入力してください");
			return isValid;
		}

		try {
			numberA = Integer.parseInt(str[0]);
			numberB = Integer.parseInt(str[1]);
		} catch (NumberFormatException e) {
			System.out.println("入力値に文字が含まれます");
			return isValid;
		}

		// 1文字目が1以上12以下、2文字目が1以上31以下の時trueにします
		if (numberA >= 1 && numberA <= 12 && numberB >= 1 && numberB <= 31) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * 入力値1文字目を取得します
	 *
	 * @return numberA 入力値一文字目
	 */
	public int getNumberA() {
		return numberA;
	}

	/**
	 * 入力値1文字目を設定します
	 *
	 * @param numberA セットする numberA
	 */
	public void setNumberA(int numberA) {
		this.numberA = numberA;
	}

	/**
	 * 入力値2文字目を取得します
	 *
	 * @return numberB 入力値2文字目
	 */
	public int getNumberB() {
		return numberB;
	}

	/**
	 * 入力値2文字目を設定します
	 *
	 * @param numberB セットする numberB
	 */
	public void setNumberB(int numberB) {
		this.numberB = numberB;
	}
}