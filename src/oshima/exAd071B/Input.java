package oshima.exAd071B;

import java.util.Scanner;

/**
 * Inputクラスは、標準入力を管理するクラスです。
 *
 * @author 大島
 */
public class Input {
	/** 文字列S */
	private String strS = "";

	/**
	 * StringLengthRangeは、文字列Sの長さの最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum StringRange {
		SLengthMin(1), SLengthMax(10000);

		final int range;

		public int getRange() {
			return range;
		}

		private StringRange(int range) {
			this.range = range;
		}
	}

	/**
	 * 標準入力を受け付け、入力値をチェックします。
	 *
	 * @return 入力した値が適切かどうかです。
	 */
	public boolean canInput() {
		boolean canInput = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		strS = scanner.nextLine();

		if (strS.length() < StringRange.SLengthMin.getRange() || strS.length() > StringRange.SLengthMax.getRange()) {
			return canInput;
		}
		canInput = true;
		return canInput;
	}

	/**
	 * @return strS
	 */
	public String getStrS() {
		return strS;
	}

	/**
	 * @param strS セットする strS
	 */
	public void setStrS(String strS) {
		this.strS = strS;
	}
}