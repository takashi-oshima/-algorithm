package takizawa.ex097_A;

import takizawa.exAdInput.Input;

public class Check {
	/** 地点A */
	private int pointA;
	/** 地点B */
	private int pointB;
	/** 地点C*/
	private int pointC;
	/** 距離D */
	private int distanceD;

	/**
	 * 正しく入力されているかをチェックします
	 *
	 * @return isValid 入力値が正しいか
	 */
	public boolean valid() {
		boolean isValid = false;
		Input input = new Input();
		String[] str = input.string();

		// 入力値が4以外の時はエラーを表示させます
		if (str.length != 4) {
			return isValid;
		}
		try {
			pointA = Integer.parseInt(str[0]);
			pointB = Integer.parseInt(str[1]);
			pointC = Integer.parseInt(str[2]);
			distanceD = Integer.parseInt(str[3]);
		} catch (NumberFormatException e) {
			System.out.println("文字が含まれています");
			return isValid;
		}

		// 入力値が範囲外の時にエラーを表示させます
		if (pointA < 1 || pointA > 100 || pointB < 1 || pointB > 100
				|| pointC < 1 || pointC > 100 || distanceD < 1 || distanceD > 100) {
			System.out.println("入力値が範囲外です");
			return isValid;
		}
		isValid = true;
		return isValid;
	}

	/**
	 * 地点Aを取得します
	 *
	 * @return numA 地点A
	 */
	public int getPointA() {
		return pointA;
	}

	/**
	 * 地点Aを設定します
	 *
	 * @param numA セットする numA
	 */
	public void setPointA(int numA) {
		this.pointA = numA;
	}

	/**
	 * 地点Bを取得します
	 *
	 * @return numB 地点B
	 */
	public int getPointB() {
		return pointB;
	}

	/**
	 * 地点Bを設定します
	 *
	 * @param numB セットする numB
	 */
	public void setPointB(int numB) {
		this.pointB = numB;
	}

	/**
	 * 地点Cを取得します
	 *
	 * @return numC 地点C
	 */
	public int getPointC() {
		return pointC;
	}

	/**
	 * 地点Cを設定します
	 *
	 * @param numC セットする numC
	 */
	public void setPointC(int numC) {
		this.pointC = numC;
	}

	/**
	 * 地点Dを取得します
	 *
	 * @return numD 地点D
	 */
	public int getDistanceD() {
		return distanceD;
	}

	/**
	 * 地点Dを設定します
	 *
	 * @param numD セットする numD
	 */
	public void setDistanceD(int numD) {
		this.distanceD = numD;
	}
}