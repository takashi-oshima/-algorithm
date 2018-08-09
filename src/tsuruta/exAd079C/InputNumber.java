package exAd079C;

import java.util.Scanner;

/**
 * 入力内容の判定を行います
 *
 * @author 鶴田竜也
 */
public class InputNumber {

	/** 入力値Aを格納します */
	private int numberA;
	/** 入力値Bを格納します */
	private int numberB;
	/** 入力値Cを格納します */
	private int numberC;
	/** 入力値Dを格納します */
	private int numberD;

	/**
	 * 入力内容が正しいか判定し、結果を返します。
	 * 正しければtrue、正しくなければfalseを返します。
	 *
	 * @return 入力内容の真偽
	 */
	public boolean isValidInput() {
		// このメソッドが呼び出しされるたびに入力値を初期化します
		this.numberA = 0;
		this.numberB = 0;
		this.numberC = 0;
		this.numberD = 0;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println(">");
		String inputNumber = scan.nextLine();

		// 入力値チェック  入力値4つのみを受け付けます
		if (!inputNumber.matches("[0-9]{4}")) {
			System.out.println("入力値は4つ、0から9までの半角数字を再入力してください。");
			return isValidInput();
		}
		// 入力値を1文字ごとに分割します
		String[] inputNum = inputNumber.split("");

		try {
			this.numberA = Integer.parseInt(inputNum[0]);
			this.numberB = Integer.parseInt(inputNum[1]);
			this.numberC = Integer.parseInt(inputNum[2]);
			this.numberD = Integer.parseInt(inputNum[3]);

		} catch (NumberFormatException e) {
			System.out.println("入力値は4つで、0から9までの数字を再入力してください。");
			return isValidInput();
		}

		return true;
	}

	/**
	 * 入力値Aを取得します。
	 *
	 * @return 入力値A
	 */
	public int getNumberA() {
		return numberA;
	}

	/**
	 * 入力値Bを取得します。
	 *
	 * @return 入力値B
	 */
	public int getNumberB() {
		return numberB;
	}

	/**
	 * 入力値Cを取得します。
	 *
	 * @return 入力値C
	 */
	public int getNumberC() {
		return numberC;
	}

	/**
	 * 入力値Dを取得します。
	 * @return 入力値D
	 */
	public int getNumberD() {
		return numberD;
	}
}
