package exAd084A;

import java.util.Scanner;

/**
 * 入力内容の判定を行います
 *
 * @author 鶴田竜也
 */
public class InputNumber {

	/** キーボード入力された数字Mを格納します */
	private int numberM;

	/**
	 * 入力内容が正しいか判定し、結果を返します。
	 * 正しければtrue、正しくなければfalseを返します。
	 *
	 * @return 入力内容の真偽
	 */
	public boolean isValidInput() {
		this.numberM = 0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println(">");

		String inputNumber = scan.nextLine();
		String[] inputNum = inputNumber.split(" ");

		if (inputNum.length != 1) {
			System.out.println("入力値は1つです。再入力してください。");
			return isValidInput();
		}

		try {
			this.numberM = Integer.parseInt(inputNum[0]);

		} catch (NumberFormatException e) {
			System.out.println("数字以外を入力しないでください。");
			return isValidInput();
		}
		// 入力値N 1～23以外の整数を受け付けないようにします
		if (this.numberM < 1 || this.numberM > 23) {
			System.out.println("1から23の半角数字を入力してください");
			return isValidInput();
		}

		return true;
	}

	/**
	 * 入力値Mを取得します。
	 *
	 * @return Mの入力値
	 */
	public int getNumberM() {
		return numberM;
	}
}
