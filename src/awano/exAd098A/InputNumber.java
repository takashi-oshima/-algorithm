package awano.exAd098A;

import java.util.Scanner;

/**
 * 入力された数値が整数で-1000～1000の範囲かどうか調べ、
 * 2つの整数A、Bを受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputNumber {
	/**入力された整数A*/
	private int a = 0;
	/**入力された整数B*/
	private int b = 0;

	/**
	 * 入力された数値が-1000～1000の整数かどうか調べます。
	 *
	 * @return 正しい数値かどうか
	 */
	public boolean checkNumber() {
		boolean correctNum = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">A B");
		String[] number = scanner.nextLine().split(" ", 0);

		if (number.length != 2) {
			System.out.println("半角数値で2つの整数を入力してください。");
			return correctNum;
		}

		int[] inputNum = new int[number.length];

		try {
			for (int i = 0; i < number.length; i++) {
				inputNum[i] = Integer.parseInt(number[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("半角数値の整数を入力してください");
			return correctNum;
		}
		//入力値が整数-1000～1000の範囲外の場合
		for (int i = 0; i < inputNum.length; i++) {
			if (inputNum[i] <= -1000 || inputNum[i] >= 1000) {
				System.out.println("入力は-1000～1000の整数で入力してください。");
				return correctNum;
			}
		}
		correctNum = true;
		a = inputNum[0];
		b = inputNum[1];
		return correctNum;
	}

	/**
	 * aを返します。
	 *
	 * @return a 整数A
	 */
	public int getA() {
		return a;
	}

	/**
	 * aを設定します。
	 *
	 * @param a 整数A
	 */
	public void setA(int a) {
		this.a = a;
	}

	/**
	 * bを返します。
	 *
	 * @return 整数B
	 */
	public int getB() {
		return b;
	}

	/**
	 * bを設定します。
	 *
	 * @param b 整数B
	 */
	public void setB(int b) {
		this.b = b;
	}
}