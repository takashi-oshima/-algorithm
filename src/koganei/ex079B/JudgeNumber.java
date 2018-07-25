package koganei.ex079B;

import koganei.Input;

/**
 * 正しく入力できているか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JudgeNumber {

	/** 入力された数字 */
	private int number;

	/**
	 * 入力された数字を設定し、正しく設定できたかの判定結果を返します
	 *
	 * @param input 入力された文字
	 * @return 判定結果
	 */
	public boolean judgeNumber(Input input) {

		String[] inputString = input.getInputString();

		if (inputString.length != 1) {
			System.out.println("入力値は1つでなければなりません");
			return false;
		}

		try {
			this.number = Integer.parseInt(inputString[0]);
		} catch (Exception e) {
			System.out.println("数字に変換できませんでした");
			return false;
		}

		if (number < 1 || number > 86) {
			System.out.println("範囲内（1～86）の数字を入力してください");
			return false;
		}
		return true;
	}

	/**
	 * 入力された数字を返します
	 *
	 * @return number 入力された数字
	 */
	public int getNumber() {
		return number;
	}
}
