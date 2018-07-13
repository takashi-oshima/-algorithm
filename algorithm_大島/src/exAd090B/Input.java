package exAd090B;

import java.util.Scanner;

/**
 * Inputクラスは、標準入力を管理するクラスです。
 *
 * @author 大島
 */
public class Input {
	/** 入力値A */
	private String inputNumberA = "";
	/** 入力値B */
	private String inputNumberB = "";

	/**
	 * 標準入力を受け付け、入力値をチェックします。
	 *
	 * @return 入力した値が適切かどうかです。
	 */
	public boolean canInput() {
		boolean canInput = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String[] inputNumbers = scanner.nextLine().split(" ");

		if(inputNumbers.length != 2) {
			return canInput;
		}

		if(!inputNumbers[0].matches("[1-9]{1}[0-9]{4}") || !inputNumbers[1].matches("[1-9]{1}[0-9]{4}")) {
			return canInput;
		}
		inputNumberA = inputNumbers[0];
		inputNumberB = inputNumbers[1];
		canInput = true;
		return canInput;
	}

	/**
	 * @return inputNumberA
	 */
	public String getInputNumberA() {
		return inputNumberA;
	}

	/**
	 * @param inputNumberA セットする inputNumberA
	 */
	public void setInputNumberA(String inputNumberA) {
		this.inputNumberA = inputNumberA;
	}

	/**
	 * @return inputNumberB
	 */
	public String getInputNumberB() {
		return inputNumberB;
	}

	/**
	 * @param inputNumberB セットする inputNumberB
	 */
	public void setInputNumberB(String inputNumberB) {
		this.inputNumberB = inputNumberB;
	}
}
