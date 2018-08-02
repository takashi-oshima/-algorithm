package oshima.exAd079A;

import java.util.Scanner;

/**
 * Inputクラスは、標準入力を管理するクラスです。
 *
 * @author 大島
 */
public class Input {
	/** 整数N */
	private String stringN = "";

	/**
	 * NumberRangeは、整数Nの数の最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum NumberRange {
		NMin(1000), NMax(9999);

		final int range;

		public int getRange() {
			return range;
		}

		private NumberRange(int range) {
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
		stringN = scanner.nextLine();
		int integerN = 0;

		try {
			integerN = Integer.parseInt(stringN);
		} catch (NumberFormatException ex) {
			return canInput;
		}

		if (integerN < NumberRange.NMin.getRange() || integerN > NumberRange.NMax.getRange()) {
			return canInput;
		}
		canInput = true;
		return canInput;
	}

	/**
	 * @return stringN
	 */
	public String getStringN() {
		return stringN;
	}

	/**
	 * @param stringN セットする stringN
	 */
	public void setStringN(String stringN) {
		this.stringN = stringN;
	}
}