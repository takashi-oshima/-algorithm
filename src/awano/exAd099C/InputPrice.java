package awano.exAd099C;

import java.util.Scanner;

/**
 * 入力された数値が、1～100000の範囲内であるかどうか調べ、
 * 入力値(N円)を受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputPrice {
	/**入力値N円*/
	private int inputN = 0;

	/**
	 * 入力値Nが正しく入力されているかどうか調べます。
	 *
	 * @return 入力値が正しいかどうか
	 */
	public boolean checkPrice() {
		boolean correctPrice = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">N");

		try {
			String inputNum = scanner.nextLine();
			inputN = Integer.parseInt(inputNum);
		} catch (NumberFormatException e) {
			System.out.println("半角数値で整数を入力してください");
			return correctPrice;
		}

		//入力値が正しい範囲内かを判定します。
		if (inputN < 1 || inputN > 100000) {
			System.out.println("数値を1～100000の範囲で入力してください。");
			return correctPrice;
		}
		correctPrice = true;
		return correctPrice;
	}

	/**
	 * 入力値N円を返します。
	 *
	 * @return 入力値N円
	 */
	public int getInputN() {
		return inputN;
	}

	/**
	 * 入力値N円を設定します。
	 *
	 * @param inputN 入力値N円
	 */
	public void setInputN(int inputN) {
		this.inputN = inputN;
	}
}