package koganei.ex098A;

import koganei.Input;

/**
 * 正しく入力できているか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JudgeNumber {

	/** 入力された数字 */
	private int[] inputNums;

	/**
	 * 入力された数字を設定します
	 *
	 * @return 数字を設定できたか否か
	 */
	public boolean judgeConversion(Input input) {
		String[] inputString = input.getInputString();
		int[] num = new int[2];
		if (inputString.length != 2) {
			System.out.println("入力が正しくありません");
			return false;
		}
		try {
			for (int i = 0; i < inputString.length; i++) {
				num[i] = Integer.parseInt(inputString[i]);
				if (num[i] < -1000 || num[i] > 1000) {
					System.out.println("範囲内（-1000～1000）の整数を入力してください");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("数字に変換できませんでした");
			return false;
		}
		this.inputNums = new int[2];
		this.inputNums = num;
		return true;
	}
	/**
	 * 入力された数字を返します
	 *
	 * @return inputNums 数字
	 */
	public int[] getInputNums() {
		return inputNums;
	}
}
