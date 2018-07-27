package oshima.exAd079C;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Inputクラスは、標準入力を管理するクラスです。
 *
 * @author 大島
 */
public class Input {
	private int integerA = 0;
	private int integerB = 0;
	private int integerC = 0;
	private int integerD = 0;

	/**
	 * NumberRangeは、整数A,B,C,Dの数の最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum NumberRange {
		MinNumber(0), MaxNumber(9);

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
		String[] inputNumbers = scanner.nextLine().split("");

		if (inputNumbers.length != 4) {
			return canInput;
		}

		try {
			integerA = Integer.parseInt(inputNumbers[0]);
			integerB = Integer.parseInt(inputNumbers[1]);
			integerC = Integer.parseInt(inputNumbers[2]);
			integerD = Integer.parseInt(inputNumbers[3]);
		} catch (NumberFormatException ex) {
			return canInput;
		}

		if (integerA < NumberRange.MinNumber.getRange() || integerA > NumberRange.MaxNumber.getRange()
				|| integerB < NumberRange.MinNumber.getRange() || integerB > NumberRange.MaxNumber.getRange()) {
			return canInput;
		}

		if (integerC < NumberRange.MinNumber.getRange() || integerC > NumberRange.MaxNumber.getRange()
				|| integerD < NumberRange.MinNumber.getRange() || integerD > NumberRange.MaxNumber.getRange()) {
			return canInput;
		}
		canInput = true;
		return canInput;
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

	/**
	 * @return integerB
	 */
	public int getIntegerB() {
		return integerB;
	}

	/**
	 * @param integerB セットする integerB
	 */
	public void setIntegerB(int integerB) {
		this.integerB = integerB;
	}

	/**
	 * @return integerC
	 */
	public int getIntegerC() {
		return integerC;
	}

	/**
	 * @param integerC セットする integerC
	 */
	public void setIntegerC(int integerC) {
		this.integerC = integerC;
	}

	/**
	 * @return integerD
	 */
	public int getIntegerD() {
		return integerD;
	}

	/**
	 * @param integerD セットする integerD
	 */
	public void setIntegerD(int integerD) {
		this.integerD = integerD;
	}
}