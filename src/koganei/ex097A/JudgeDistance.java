package koganei.ex097A;

import koganei.Input;

/**
 * 正しく入力できているか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JudgeDistance {

	/** 入力され地点 */
	private int[] point;

	/**
	 * 入力された地点を設定し、正しく設定できたかの判定結果を返します
	 *
	 * @param input 入力された文字
	 * @return 判定結果
	 */
	public boolean judgeConversion(Input input) {
		String[] inputString = input.getInputString();
		point = new int[4];

		if (inputString.length != 4) {
			System.out.println("入力値は４つでなければなりません");
			return false;
		}

		try {
			for (int i = 0; i < inputString.length; i++) {
				point[i] = Integer.parseInt(inputString[i]);
				if (point[i] < 1 || point[i] > 100) {
					System.out.println("範囲内（1～100）の整数を入力してください");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("数字に変換できませんでした");
			return false;
		}
		return true;
	}

	/**
	 * 各地点を返します
	 *
	 * @return month 各地点
	 */
	public int[] getPoint() {
		return point;
	}
}
