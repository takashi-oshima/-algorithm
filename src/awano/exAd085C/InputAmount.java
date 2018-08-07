package awano.exAd085C;

import java.util.Scanner;

/**
 *
 * 入力された数値Nが1～2000かつYが1000～20000000の範囲内であるかどうか調べ、
 * 入力値N(お札の枚数)と入力値A(お年玉の合計金額)を受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputAmount {
	/**お札の枚数*/
	private int billCount = 0;
	/**お年玉の合計金額*/
	private int totalAmount = 0;

	/**
	 * 入力値NとYが正しく入力されているかどうか調べます。
	 *
	 * @return 入力値が正しいかどうか
	 */
	public boolean checkInputAmount() {
		boolean correctAmount = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">N Y");
		String[] inputNY = scanner.nextLine().split(" ");

		if (inputNY.length != 2) {
			System.out.println("N,Yの値を半角数値で入力してください。");
			return correctAmount;
		}
		int[] inputArray = new int[inputNY.length];

		try {
			for (int i = 0; i < inputNY.length; i++) {
				inputArray[i] = Integer.parseInt(inputNY[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("半角数値で入力してください。");
			return correctAmount;
		}
		billCount = inputArray[0];
		totalAmount = inputArray[1];

		//入力値が正しい範囲内かを判定します。
		if (billCount < 1 || billCount > 2000 || totalAmount < 1000 || totalAmount > 20000000) {
			System.out.println("Nの値を1～2000の範囲で、Yの値を1000～20000000の範囲で入力してください。");
			return correctAmount;
		}
		correctAmount = true;
		return correctAmount;
	}

	/**
	 * お札の枚数を返します。
	 *
	 * @return お札の枚数
	 */
	public int getBillCount() {
		return billCount;
	}

	/**
	 * お札の枚数を設定します。
	 * @param billCount お札の枚数
	 */
	public void setBillCount(int billCount) {
		this.billCount = billCount;
	}

	/**
	 * お年玉の合計金額を返します。
	 * @return お年玉の合計金額
	 */
	public int getTotalAmount() {
		return totalAmount;
	}

	/**
	 * お年玉の合計金額を設定します。
	 * @param totalAmount お年玉の合計金額
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}