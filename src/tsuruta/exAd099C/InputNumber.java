package exAd099C;

import java.util.Scanner;

/**
 * 入力内容の判定を行います
 *
 * @author 鶴田竜也
 */
public class InputNumber {

	/** キーボード入力された数字（N）を格納します */
	private int numberN;

	/**
	 * 入力内容が正しいか判定し、結果を返します。
	 * 正しければtrue、正しくなければfalseを返します。
	 *
	 * @return 入力内容の真偽
	 */
	public boolean isValidInput() {
		this.numberN = 0;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println(">");

		String inputNumber = scan.nextLine();
		String[] inputDate = inputNumber.split(" ");

		if (inputDate.length != 1) {
			System.out.println("入力値は1つです。再入力してください。");
			return isValidInput();
		}

		try {
			this.numberN = Integer.parseInt(inputDate[0]);

		} catch (NumberFormatException e) {
			System.out.println("数字以外を入力しないでください。");
			return isValidInput();
		}

		if (this.numberN < 1 || this.numberN > 100000) {
			System.out.println("1～100000の半角数字を入力してください");
			return isValidInput();
		}

		return true;
	}

	/**
	 * 入力値Nを取得します。
	 *
	 * @return Nの入力値
	 */
	public int getNumberN() {
		return numberN;
	}
}