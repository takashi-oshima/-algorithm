package exAd086B;

import java.util.Scanner;

/**
 * 入力内容の判定を行います
 *
 * @author 鶴田竜也
 */
public class InputNumber {

	/** キーボード入力された数字Nを格納します */
	private int numberA;
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

		String inputNumber = scan.nextLine();
		String[] inputNum = inputNumber.split(" ");

		if (inputNum.length != 2) {
			System.out.println("入力値は2つです。再入力してください。");
			return isValidInput();
		}

		try {
			this.numberA = Integer.parseInt(inputNum[0]);
			this.numberB = Integer.parseInt(inputNum[1]);

		} catch (NumberFormatException e) {
			System.out.println("数字以外を入力しないでください。");
			return isValidInput();
		}
		// 入力値N 1～100以外の整数を受け付けないようにします
		if (this.numberA < 1 || this.numberA > 100) {
			System.out.println("Aには1から100の半角数字を入力してください");
			return isValidInput();
		}
		// 入力値A 0～100以外の整数を受け付けないようにします
		if (this.numberB < 1 || this.numberB > 100) {
			System.out.println("Bには1から100の半角数字を入力してください");
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
