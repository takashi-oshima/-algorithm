package koganei.ex086B;

import koganei.Input;

/**
 * 正しく入力できているか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JudgeNumber {

	/** ひとつめに入力された数字 */
	private int numA;
	/** ふたつめに入力された数字 */
	private int numB;

	/**
	 * 入力されたふたつの数字を設定し、正しく設定できたかの判定結果を返します
	 *
	 * @param input 入力された文字
	 * @return 判定結果
	 */
	public boolean judgeNumber(Input input) {
		String[] inputString = input.getInputString();

		if (inputString.length != 2) {
			System.out.println("入力値は2つでなければなりません");
			return false;
		}

		try {
			this.numA = Integer.parseInt(inputString[0]);
			this.numB = Integer.parseInt(inputString[1]);
		} catch (Exception e) {
			System.out.println("数字に変換できませんでした");
			return false;
		}

		if (numA < 1 || numA > 100 || numB < 1 || numB > 100) {
			System.out.println("範囲内（1～100）の数字を入力してください");
			return false;
		}
		return true;
	}

	/**
	 * ひとつめに入力された数字を返します
	 *
	 * @return numA ひとつめに入力された数字
	 */
	public int getNumA() {
		return numA;
	}

	/**
	 * ふたつめに入力された数字を返します
	 *
	 * @return numB ふたつめに入力された数字
	 */
	public int getNumB() {
		return numB;
	}
}
