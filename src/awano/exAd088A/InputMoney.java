package awano.exAd088A;

import java.util.Scanner;

/**
 * 入力値がN(1～10000)、A(0～1000)の範囲内か調べ、
 * N(支払い金額)とA(1円硬貨の枚数)を受け取るクラスです。
 *
 * @author 粟野真司
 *
 */
public class InputMoney {
	/**支払い金額*/
	private int payMoney = 0;
	/**１円の所持枚数*/
	private int oneYenCoin = 0;

	/**
	 * 入力値NとAが正しく入力されているかどうか調べます。
	 *
	 * @return 正しい金額かどうか
	 */
	public boolean checkMoney() {
		boolean correctMoney = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">N A");
		String[] number = scanner.nextLine().split(" ", 0);

		if (number.length != 2) {
			System.out.println("N,Aの値を半角数値で入力してください。");
			return correctMoney;
		}

		int[] inputNum = new int[number.length];

		try {
			for (int i = 0; i < number.length; i++) {
				inputNum[i] = Integer.parseInt(number[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("半角数値の整数を入力してください");
			return correctMoney;
		}
		payMoney = inputNum[0];
		oneYenCoin = inputNum[1];

		if (payMoney < 1 || payMoney > 10000) {
			System.out.println("Nの値は1～10000の範囲で入力してください。");
			return correctMoney;
		}

		if (oneYenCoin < 0 || oneYenCoin > 1000) {
			System.out.println("Aの値は0～1000の範囲で入力してください。");
			return correctMoney;
		}
		correctMoney = true;
		return correctMoney;
	}

	/**
	 * 支払い金額を返します。
	 *
	 * @return 支払い金額
	 */
	public int getPayMoney() {
		return payMoney;
	}

	/**
	 * 支払い金額を設定します。
	 *
	 * @param payMoney 支払い金額
	 */
	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	/**
	 * 1円の所持枚数を返します。
	 *
	 * @return 1円の所持枚数
	 */
	public int getOneYenCoin() {
		return oneYenCoin;
	}

	/**
	 * 1円の所持枚数を設定します。
	 *
	 * @param oneYenCoin 1円の所持枚数
	 */
	public void setOneYenCoin(int oneYenCoin) {
		this.oneYenCoin = oneYenCoin;
	}
}
