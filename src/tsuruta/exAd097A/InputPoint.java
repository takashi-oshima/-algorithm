package exAd097A;

import java.util.Scanner;

/**
 * 入力の判定を行います。
 *
 * @author 鶴田竜也
 */
public class InputPoint {
	/** a地点を格納します */
	private int aPoint;
	/** b地点を格納します */
	private int bPoint;
	/** c地点を格納します */
	private int cPoint;
	/** d地点を格納します */
	private int distance;

	/**
	 * 入力内容が正しいか判定し結果を返します。
	 * 正しければtrue、正しくなければfalseを返します。
	 *
	 * @return 入力内容の真偽
	 */
	public boolean isValidInput() {
		this.aPoint = 0;
		this.bPoint = 0;
		this.cPoint = 0;
		this.distance = 0;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println(">");

		String inputNumber = scan.nextLine();

		String[] inputDate = inputNumber.split(" ");

		if (inputDate.length != 4) {
			System.out.println("入力値は4つです。再入力してください。");
			return isValidInput();
		}

		try {
			this.aPoint = Integer.parseInt(inputDate[0]);
			this.bPoint = Integer.parseInt(inputDate[1]);
			this.cPoint = Integer.parseInt(inputDate[2]);
			this.distance = Integer.parseInt(inputDate[3]);
		} catch (NumberFormatException e) {
			System.out.println("数字以外を入力しないでください。");
			return isValidInput();
		}
		// 1～100以外の整数を受け付けないようにします
		if (this.aPoint < 0 || this.bPoint < 0 || this.cPoint < 0 || this.distance < 0) {
			System.out.println("0以下の数字を入力しないでください");
			return isValidInput();
		}
		if (this.aPoint > 100 || this.bPoint > 100 || this.cPoint > 100 || this.distance > 100) {
			System.out.println("100以上の整数を入力しないでください");
			return isValidInput();
		}

		return true;
	}

	/**
	 * aの位置を取得します。
	 *
	 * @return aの位置
	 */
	public int getaPoint() {
		return aPoint;
	}

	/**
	 * aの位置を設定します。
	 *
	 * @param aPoint aの位置
	 */
	public void setaPoint(int aPoint) {
		this.aPoint = aPoint;
	}

	/**
	 * bの位置を取得します。
	 *
	 * @return bの位置
	 */
	public int getbPoint() {
		return bPoint;
	}

	/**
	 * bの位置を設定します。
	 *
	 * @param bPoint bの位置
	 */
	public void setbPoint(int bPoint) {
		this.bPoint = bPoint;
	}

	/**
	 * cの位置を取得します。
	 *
	 * @return
	 */
	public int getcPoint() {
		return cPoint;
	}

	/**
	 * cの位置を設定します。
	 *
	 * @param cPoint cの位置
	 */
	public void setcPoint(int cPoint) {
		this.cPoint = cPoint;
	}

	/**
	 * 距離を取得します。
	 *
	 * @return 距離
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * 距離を設定します。
	 *
	 * @param distance 距離
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
