package koganei.ex090B;

import koganei.Input;

/**
 * 正しく入力できているか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JudgeNumber {

	/** 最初に入力された数字*/
	private int startNumber;
	/** 最後に入力された数字*/
	private int endNumber;

	/**
	 * 入力された数字を設定し、正しく設定できたかの判定結果を返します
	 *
	 * @param input 入力された文字
	 * @return 判定結果
	 */
	public boolean judgeNumer(Input input) {

		String[] inputString = input.getInputString();

		if (inputString.length != 2) {
			System.out.println("入力値は2つでなければなりません");
			return false;
		}

		try {
			this.startNumber = Integer.parseInt(inputString[0]);
			this.endNumber = Integer.parseInt(inputString[1]);
		} catch (Exception e) {
			System.out.println("数字に変換できませんでした");
			return false;
		}

		if (startNumber < 10000 || startNumber > 99999 || endNumber < 10000 || endNumber > 99999) {
			System.out.println("範囲内（10000～99999）の整数を入力してください");
			return false;
		}

		if (endNumber < startNumber) {
			System.out.println("入力値はA以上B以下でなければなりません");
			return false;
		}
		return true;
	}

	/**
	 * 最初に入力された数字を返します
	 *
	 * @return startNumber 最初に入力された数字
	 */
	public int getStartNumber() {
		return startNumber;
	}

	/**
	 * 最後に入力された数字を返します
	 *
	 * @return endNumber 最後に入力された数字
	 */
	public int getEndNumber() {
		return endNumber;
	}
}
