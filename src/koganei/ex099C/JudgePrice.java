package koganei.ex099C;

import koganei.Input;

/**
 * 正しく入力できているか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JudgePrice {

	/** 入力された金額 */
	private int price;

	/**
	 * 入力された金額を設定し、正しく設定できたかの判定結果を返します
	 *
	 * @param input 入力された文字
	 * @return 判定結果
	 */
	public boolean judgeConversion(Input input) {

		String[] inputString = input.getInputString();

		if (inputString.length != 1) {
			System.out.println("入力が正しくありません");
			return false;
		}

		try {
			price = Integer.parseInt(inputString[0]);
			if (price < 0 || price > 100000) {
				System.out.println("範囲内（1～100000）の整数を入力してください");
				return false;
			}
		} catch (Exception e) {
			System.out.println("数字に変換できませんでした");
			return false;
		}
		return true;
	}

	/**
	 * 金額を返します
	 *
	 * @return price 金額
	 */
	public int getPrice() {
		return price;
	}
}
