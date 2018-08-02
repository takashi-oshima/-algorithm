package awano.exAd080B;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 入力値が1～100000000の範囲内か調べ、
 * 入力値Nを受け取るクラスです。
 *
 * @author 粟野真司
 *
 */
public class InputNumber {
	/**入力値N*/
	private int number = 0;

	/**
	 * 入力値Nが正しく入力されているかどうか調べます。
	 *
	 * @param inputNumber InputNumberクラス
	 * @return 正しく入力されているかどうか
	 */
	public boolean checkNumber(InputNumber inputNumber) {
		boolean correctNumber = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">N");

		try {
			number = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("半角数値で入力してください。");
			return correctNumber;
		}

		//入力値が正しい範囲内かを判定します。
		if (number < 1 || number > 100000000) {
			System.out.println("Mの入力値を1～100000000の範囲で入力してください。");
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
	public int getNumber() {
		return number;
	}

	/**
	 * 入力値Nを設定します。
	 *
	 * @param number 入力値N
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}