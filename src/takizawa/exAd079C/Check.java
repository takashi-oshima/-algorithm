package takizawa.exAd079C;

import takizawa.exAdInput.Input2;

/**
 * 入力値が正しいかを調べます
 *
 * @author 瀧澤
 */
public class Check {
	/** 入力値A */
	private int inputA;
	/** 入力値B */
	private int inputB;
	/** 入力値C */
	private int inputC;
	/** 入力値D */
	private int inputD;

	/**
	 * 入力値が必要文字数あるか、文字が含まれていないか、範囲内かを調べます
	 *
	 * @return isValid 入力値が正しいか
	 */
	public boolean valid() {
		boolean isValid = false;
		Input2 input = new Input2();
		String[] str = input.string();

		// 文字列の長さが4以外ならfalseを返す
		if (str.length != 4) {
			return isValid;
		}

		try {
			inputA = Integer.parseInt(str[0]);
			inputB = Integer.parseInt(str[1]);
			inputC = Integer.parseInt(str[2]);
			inputD = Integer.parseInt(str[3]);
		} catch (NumberFormatException e) {
			return isValid;
		}

		// 入力値A、B、C、Dが範囲内かを調べます
		if (inputA < 0 || inputA > 9 || inputB < 0 || inputB > 9 || inputC < 0 || inputC > 9
				|| inputD < 0 || inputD > 9) {
			return isValid;
		}
		isValid = true;
		return isValid;
	}

	/**
	 * 入力値Aを取得します
	 *
	 * @return inputA 入力値A
	 */
	public int getInputA() {
		return inputA;
	}

	/**
	 * 入力値Aを設定します
	 *
	 * @param inputA セットする inputA
	 */
	public void setInputA(int inputA) {
		this.inputA = inputA;
	}

	/**
	 * 入力値Bを取得します
	 *
	 * @return inputB 入力値B
	 */
	public int getInputB() {
		return inputB;
	}

	/**
	 * 入力値Bを設定します
	 *
	 * @param inputB セットする inputB
	 */
	public void setInputB(int inputB) {
		this.inputB = inputB;
	}

	/**
	 * 入力値Cを取得します
	 *
	 * @return inputC 入力値C
	 */
	public int getInputC() {
		return inputC;
	}

	/**
	 * 入力値Cを設定します
	 *
	 * @param inputC セットする inputC
	 */
	public void setInputC(int inputC) {
		this.inputC = inputC;
	}

	/**
	 * 入力値Dを取得します
	 *
	 * @return inputD 入力値D
	 */
	public int getInputD() {
		return inputD;
	}

	/**
	 * 入力値Dを設定します
	 *
	 * @param inputD セットする inputD
	 */
	public void setInputD(int inputD) {
		this.inputD = inputD;
	}
}