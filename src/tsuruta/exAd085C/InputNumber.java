package exAd085C;

import java.util.Scanner;

/**
 * 入力内容の判定を行います
 *
 * @author 鶴田竜也
 */
public class InputNumber {

	/** お年玉袋の中のお札の枚数 */
	private int numberN;
	/** お年玉の合計 */
	private int numberY;

	/**
	 * 入力内容が正しいか判定し、結果を返します。
	 * 正しければtrue、正しくなければfalseを返します。
	 *
	 * @return 入力内容の真偽
	 */
	public boolean isValidInput() {
		this.numberN = 0;
		this.numberY = 0;
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
			this.numberN = Integer.parseInt(inputNum[0]);
			this.numberY = Integer.parseInt(inputNum[1]);

		} catch (NumberFormatException e) {
			System.out.println("数字以外を入力しないでください。");
			return isValidInput();
		}

		// 入力値N 1～2000以外の整数を受け付けないようにします
		if (this.numberN < 1 || this.numberN > 2000) {
			System.out.println("Nには1から100の半角数字を入力してください");
			return isValidInput();
		}

		// 入力値Y 1000～20000000以外の整数を受け付けないようにします
		if (this.numberY < 1000 || this.numberY > 20000000) {
			System.out.println("Yには1000から20000000の半角数字を入力してください");
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

	/**
	 * 入力値Yを取得します。
	 *
	 * @return Yの入力値
	 */
	public int getNumberY() {
		return numberY;
	}
}
