package awano.exAd090B;

import java.util.Scanner;

/**
 * 入力値ABが10000～99999の範囲内か調べ、
 * 整数Aと整数Bを受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputNumber {
	/**開始の数値*/
	private int aNumber = 0;
	/**終了の数値*/
	private int bNumber = 0;

	/**
	 * 入力値AとBが正しく入力されているかどうか調べます。
	 *
	 * @return 正しく入力されているかどうか
	 */
	public boolean ceheckNumber() {
		boolean correctNum = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">A B");
		String number = scanner.nextLine();
		String[] inputNum = number.split(" ", 0);

		if (inputNum.length != 2) {
			System.out.println("半角数値で2つの整数を入力してください。");
			return correctNum;
		}
		int[] rangeNum = new int[inputNum.length];

		try {
			for (int i = 0; i < inputNum.length; i++) {
				rangeNum[i] = Integer.parseInt(inputNum[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("半角数値の整数を入力してください。");
			return correctNum;
		}

		//入力値が正しい範囲内かを判定します。
		for (int i = 0; i < rangeNum.length; i++) {
			if (rangeNum[i] < 10000 || rangeNum[i] > 99999) {
				System.out.println("入力数値を10000～99999の範囲で入力してください。");
				return correctNum;
			}
		}

		aNumber = rangeNum[0];
		bNumber = rangeNum[1];
		correctNum = true;
		return correctNum;
	}

	/**
	 * 開始の数値を返します。
	 *
	 * @return 開始の数値
	 */
	public int getANumber() {
		return aNumber;
	}

	/**
	 * 開始の数値を設定します。
	 *
	 * @param startNum 開始の数値
	 */
	public void setANumber(int aNumber) {
		this.aNumber = aNumber;
	}

	/**
	 * 終了の数値を返します。
	 *
	 * @return 終了の数値
	 */
	public int getBNumber() {
		return bNumber;
	}

	/**
	 * 終了の数値を設定します。
	 *
	 * @param endNum 終了の数値
	 */
	public void setBNumber(int bNumber) {
		this.bNumber = bNumber;
	}
}