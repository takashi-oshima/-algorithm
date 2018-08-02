package awano.exAd079B;

import java.util.Scanner;

/**
 * 入力値が1～86の範囲内か調べ、
 * 入力値Nを受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputNumber {
	/**入力値N*/
	private int inputNumber = 0;

	/**
	 * 入力値Nが正しく入力されているかどうか調べます。
	 *
	 * @return 正しく入力されているかどうか
	 */
	public boolean checkInputNumber() {
		boolean correctNumber = false;
		String inputN = "";
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">N");

		try {
			inputN = scanner.nextLine();
			inputNumber = Integer.parseInt(inputN);
		} catch (NumberFormatException e) {
			System.out.println("半角数値を入力してください。");
			return correctNumber;
		}

		//入力値が正しい範囲内かを判定します。
		if (inputNumber < 1 || inputNumber > 86) {
			System.out.println("入力値Nを1～86の範囲で入力してください。");
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
	public int getInputNumber() {
		return inputNumber;
	}

	/**
	 * 入力値Nを設定します。
	 *
	 * @param inputNumber 入力値N
	 */
	public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}
}