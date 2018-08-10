package exAd071B;

import java.util.Scanner;

/**
 * 入力内容の判定を行います
 *
 * @author 鶴田竜也
 */

public class InputString {

	/** キーボード入力された各桁の数字を格納します */
	private String numberS;

	/**
	 * 入力内容が正しいか判定し、結果を返します。
	 * 正しければtrue、正しくなければfalseを返します。
	 *
	 * @return 入力内容の真偽
	 */
	public boolean isValidInput() {
		this.numberS = "";

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println(">");
		this.numberS = scan.nextLine();

		// 入力文字列の長さ1から10の5乗以外は受け付けつけないようにします
		if (numberS.length() < 1 || numberS.length() > Math.pow(10, 5)) {
			System.out.println("1から10の5乗までの英小文字の文字を入力してください");
			return isValidInput();
		}

		// 入力値a～ｚのアルファベット以外は受け付けないようにします
		if (!numberS.matches("^[a-z]+$")) {
			System.out.println("入力形式が違います。再度入力し直してください");
			return isValidInput();
		}

		return true;
	}

	/**
	 * 入力値Sを取得します。
	 *
	 * @return 入力値S
	 */
	public String getNumberS() {
		return numberS;
	}
}
