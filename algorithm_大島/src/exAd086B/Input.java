package exAd086B;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	/** 入力値が格納される配列 */
	private String[] inputNumbers = {};

	/**
	 * NumberRangeは、整数N,Aの数の最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum NumberRange {
		MinNumber(1), MaxNumber(100);

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
		int integerA = 0;
		int integerB = 0;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		inputNumbers = scanner.nextLine().split(" ");

		if(inputNumbers.length != 2) {
			return canInput;
		}

		try {
			integerA = Integer.parseInt(inputNumbers[0]);
			integerB = Integer.parseInt(inputNumbers[1]);
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
	 * @return inputNumbers
	 */
	public String[] getInputNumbers() {
		return inputNumbers;
	}

	/**
	 * @param inputNumbers セットする inputNumbers
	 */
	public void setInputNumbers(String[] inputNumbers) {
		this.inputNumbers = inputNumbers;
	}
}