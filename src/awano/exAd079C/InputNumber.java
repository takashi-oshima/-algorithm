package awano.exAd079C;

import java.util.Scanner;

/**
 * 入力された数値A、B、C、Dが1～9の範囲内であるかどうか調べ、
 * 入力値A、B、C、D(整理番号)を受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputNumber {
	/**整理番号*/
	private int[] referenceNumber = {};

	/**
	 * 入力値ABCDが正しく入力されているかどうか調べます。
	 *
	 * @return 入力値が正しいかどうか
	 */
	public boolean checknumber() {
		boolean correctNumber = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">ABCD");
		String number = scanner.nextLine();

		//入力値が正しい範囲内かを判定します。
		if (!number.matches("[0-9]{4}")) {
			System.out.println("0000～9999の範囲で半角数字4桁を入力してください。");
			return correctNumber;
		}

		String[] inputNum = number.split("");
		referenceNumber = new int[inputNum.length];

		for (int i = 0; i < inputNum.length; i++) {
			referenceNumber[i] = Integer.parseInt(inputNum[i]);
		}
		correctNumber = true;
		return correctNumber;
	}

	/**
	 * 整理番号を返します。
	 *
	 * @return 整理番号
	 */
	public int[] getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * 整理番号を設定します。
	 *
	 * @param referenceNumber 整理番号
	 */
	public void setReferenceNumber(int[] referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
}