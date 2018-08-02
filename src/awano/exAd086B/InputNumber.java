package awano.exAd086B;

import java.util.Scanner;

/**
 * 入力値a,bが1～100の範囲内か調べ、
 * 整数aと整数bを受け取るクラスです。
 *
 * @author 粟野真司
 *
 */
public class InputNumber {
	/**aとbを繋げた数値*/
	private int integer = 0;

	/**
	 * 入力値aとbが正しく入力されているかどうか調べます。
	 *
	 * @param inputNumber InputNumberクラス
	 * @return 正しく入力されているかどうか
	 */
	public boolean checkInputNumber(InputNumber inputNumber) {
		boolean correctNum = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">a b");
		String number = scanner.nextLine();
		String[] inputNum = number.split(" ", 0);

		if (inputNum.length != 2) {
			System.out.println("a,bの値を半角数値で入力してください。");
			return correctNum;
		}
		String str = inputNum[0] + inputNum[1];

		try {
			for (int i = 0; i < inputNum.length; i++) {
				integer = Integer.parseInt(str);
			}
		} catch (NumberFormatException e) {
			System.out.println("半角数値の整数を入力してください");
			return correctNum;
		}
		int[] rangeNum = new int[inputNum.length];

		for (int i = 0; i < inputNum.length; i++) {
			rangeNum[i] = Integer.parseInt(inputNum[i]);

			////入力値が正しい範囲内かを判定します。
			if (rangeNum[i] < 1 || rangeNum[i] > 100) {
				System.out.println("a,bの入力値を1～100の範囲内で入力してください。");
				return correctNum;
			}
		}
		correctNum = true;
		return correctNum;
	}

	/**
	 * aとbを繋げた数値を返します。
	 *
	 * @return aとbを繋げた数値
	 */
	public int getInteger() {
		return integer;
	}

	/**
	 * aとbを繋げた数値を設定します。
	 *
	 * @param integer aとbを繋げた数値
	 */
	public void setInteger(int integer) {
		this.integer = integer;
	}
}