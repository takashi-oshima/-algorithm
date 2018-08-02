package oshima.exAd084A;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Inputクラスは、標準入力を管理するクラスです。
 *
 * @author 大島
 */
public class Input {
	/** 整数M */
	private int integerM = 0;

	/**
	 * NumberRangeは、整数Mの数の最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum NumberRange {
		MMin(1), MMax(23);

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

		try {
			integerM = scanner.nextInt();
		} catch (InputMismatchException ex) {
			return canInput;
		}

		if (integerM < NumberRange.MMin.getRange() || integerM > NumberRange.MMax.getRange()) {
			return canInput;
		}
		canInput = true;
		return canInput;
	}

	/**
	 * @return integerM
	 */
	public int getIntegerM() {
		return integerM;
	}

	/**
	 * @param integerM セットする integerM
	 */
	public void setIntegerM(int integerM) {
		this.integerM = integerM;
	}
}