package exAd098A;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Inputクラスは、標準入力を管理するクラスです。
 *
 * @author 大島
 */
public class Input {
	/** 整数A */
	private int integerA = 0;
	/** 整数B */
	private int integerB = 0;

	/**
	 * NumberRangeは、値の最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum NumberRange {
		MinNumber(-1000), MaxNumber(1000);

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
			integerA = scanner.nextInt();
			integerB = scanner.nextInt();
		} catch (InputMismatchException ex) {
			return canInput;
		}

		if (integerA < NumberRange.MinNumber.getRange() || integerA > NumberRange.MaxNumber.getRange()
				|| integerB < NumberRange.MinNumber.getRange() || integerB > NumberRange.MaxNumber.getRange()) {
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
}
