package exAd090B;

import java.util.Scanner;

/**
 * 入力内容の判定を行います
 *
 * @author 鶴田竜也
 */
public class InputNumber {

	/** Aの数字を格納します */
	private int numberA;
	/** Bの数字を格納します */
	private int numberB;

	/**
	 * 入力内容が正しいか判定し、結果を返します。
	 * 正しければtrue、正しくなければfalseを返します。
	 *
	 * @return 入力内容の真偽
	 */
	public boolean isValidInput() {
		this.numberA = 0;
		this.numberB = 0;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println(">");

		String inputNumber;
		String[] inputDate;

		try {
			inputNumber = scan.nextLine();
			inputDate = inputNumber.split(" ");

			if (inputDate.length != 2) {
				System.out.println("入力値は2つです。再入力してください。");
				return isValidInput();
			}

			this.numberA = Integer.parseInt(inputDate[0]);
			this.numberB = Integer.parseInt(inputDate[1]);

		} catch (NumberFormatException e) {
			System.out.println("半角数字の整数（10000～99999）を入力してください");
			return isValidInput();
		}
		// 10000～99999以外の整数を受け付けないようにします
		if (this.numberA < 10000 || this.numberB < 10000 || this.numberA > 99999 || this.numberB > 99999) {
			System.out.println("10000～99999までの半角数字を入力してください");
			return isValidInput();
		}

		return true;
	}

	/**
	 * Aの入力値を取得します。
	 *
	 * @return Aの入力値
	 */
	public int getNumberA() {
		return numberA;
	}

	/**
	 * Bの入力値を取得します。
	 *
	 * @return Bの入力値
	 */
	public int getNumberB() {
		return numberB;
	}
}
