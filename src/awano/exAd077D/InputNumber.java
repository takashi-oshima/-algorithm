package awano.exAd077D;

import java.util.Scanner;

/**
 * 入力値Nが2～100000の範囲内であるかどうか調べ、
 * 入力値N(整数)を受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputNumber {
	/**入力値N*/
	private int inputN = 0;

	/**
	 * 入力値Nが正しく入力されているかどうか調べます。
	 *
	 * @return 入力値が正しいかどうか
	 */
	public boolean checkNumber() {
		boolean correctNumber = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">N");
		String number = scanner.nextLine();

		if (!(number.matches("^[0-9]+$"))) {
			System.out.println("半角数字で入力してください。");
			return correctNumber;
		}

		try {
			inputN = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			System.out.println("入力桁数が大きすぎます。2～100000の範囲で入力してください。");
			return correctNumber;
		}

		//入力値が正しい範囲内かを判定します。
		if (inputN < 2 || inputN > 100000 || number.indexOf("0") == 0) {
			System.out.println("入力値を2～100000の範囲で入力してください。");
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
	public int getInputN() {
		return inputN;
	}

	/**
	 * 入力値Nを設定します。
	 *
	 * @param inputN 入力値N
	 */
	public void setInputN(int inputN) {
		this.inputN = inputN;
	}
}