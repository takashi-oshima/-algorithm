package awano.exAd079A;

import java.util.Scanner;

/**
 * 入力値が1000～9999の範囲内か調べ、
 * 入力値Nを受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputInteger {
	/**入力値N*/
	private String inputN = "";

	/**
	 * 入力値Nが正しく入力されているかどうか調べます。
	 *
	 * @return 正しく入力されているかどうか
	 */
	public boolean checkInputNumber() {
		boolean correctNumber = false;
		int inputNumber = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">N");

		try {
			inputN = scanner.nextLine();
			inputNumber = Integer.parseInt(inputN);
		} catch (NumberFormatException e) {
			System.out.println("4桁の整数Nを入力してください。");
			return correctNumber;
		}

		//入力値が正しい範囲内かを判定します。
		if (inputNumber < 1000 || inputNumber > 9999) {
			System.out.println("入力値Nを1000～9999の範囲で入力してください。");
			return correctNumber;
		}
		correctNumber = true;
		return correctNumber;
	}

	/**
	 * 入力値Nを返します。
	 *
	 * @return 入力値N
	 */
	public String getInputN() {
		return inputN;
	}

	/**
	 * 入力値Nを設定します。
	 *
	 * @param inputN 入力値N
	 */
	public void setInputN(String inputN) {
		this.inputN = inputN;
	}

}