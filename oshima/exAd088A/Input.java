package oshima.exAd088A;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	/** 整数N */
	private int integerN = 0;
	/** 整数A */
	private int integerA = 0;

	/**
	 * NumberRangeは、整数N,Aの数の最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum NumberRange {
		NMin(1), NMax(10000),AMin(0),AMax(1000);

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
			integerA = scanner.nextInt();
		} catch (InputMismatchException ex) {
			return canInput;
		}

		if (integerN < NumberRange.NMin.getRange() || integerN > NumberRange.NMax.getRange()
				|| integerA < NumberRange.AMin.getRange() || integerA > NumberRange.AMax.getRange()) {
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
	 * @return integerA
	 */
	public int getIntegerA() {
		return integerA;
	}

	/**
	 * @param integerA セットする integerA
	 */
	public void setIntegerA(int integerA) {
		this.integerA = integerA;
	}
}