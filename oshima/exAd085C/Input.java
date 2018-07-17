package oshima.exAd085C;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	/** 整数N */
	private int integerN = 0;
	/** 整数A */
	private int integerY = 0;

	/**
	 * NumberRangeは、整数N,Aの数の最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum NumberRange {
		NMin(1), NMax(2000),YMin(1000),YMax(20000000);

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
			integerN = scanner.nextInt();
			integerY = scanner.nextInt();
		} catch (InputMismatchException ex) {
			return canInput;
		}

		if (integerN < NumberRange.NMin.getRange() || integerN > NumberRange.NMax.getRange()
				|| integerY < NumberRange.YMin.getRange() || integerY > NumberRange.YMax.getRange()) {
			return canInput;
		}

		if(integerY % NumberRange.YMin.getRange() != 0) {
			return canInput;
		}
		canInput = true;
		return canInput;
	}

	/**
	 * @return integerN
	 */
	public int getIntegerN() {
		return integerN;
	}

	/**
	 * @param integerN セットする integerN
	 */
	public void setIntegerN(int integerN) {
		this.integerN = integerN;
	}

	/**
	 * @return integerY
	 */
	public int getIntegerY() {
		return integerY;
	}

	/**
	 * @param integerY セットする integerY
	 */
	public void setIntegerY(int integerY) {
		this.integerY = integerY;
	}
}