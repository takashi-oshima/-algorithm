package exAd099C;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Inputクラスは、標準入力を管理するクラスです。
 *
 * @author 大島
 */
public class Input {
	/** 整数N */
	private int integerN = 0;

	/**
	 * NumberRangeは、値の最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum NumberRange {
		MinNumber(1), MaxNumber(100000);

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
		} catch (InputMismatchException ex) {
			return canInput;
		}

		if (integerN < NumberRange.MinNumber.getRange() || integerN > NumberRange.MaxNumber.getRange()) {
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
}
