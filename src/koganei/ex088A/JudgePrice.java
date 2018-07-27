package koganei.ex088A;

import koganei.Input;

/**
 * 正しく入力できているか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JudgePrice {

	/** 入力された金額 */
	private int price;
	/** 入力された一円玉の枚数 */
	private int oneYen;

	/**
	 * 入力された金額と一円玉の枚数を設定し、正しく設定できたかの判定結果を返します
	 *
	 * @param input 入力された文字
	 * @return 判定結果
	 */
	public boolean judgePrice(Input input) {
		String[] inputString = input.getInputString();

		if (inputString.length != 2) {
			System.out.println("入力値は2つでなければなりません");
			return false;
		}

		try {
			this.price = Integer.parseInt(inputString[0]);
			this.oneYen = Integer.parseInt(inputString[1]);
		} catch (Exception e) {
			System.out.println("数字に変換できませんでした");
			return false;
		}

		if (price < 1 || price > 10000) {
			System.out.println("範囲内（1～10000）の金額を入力してください");
			return false;
		}

		if (oneYen < 0 || oneYen > 1000) {
			System.out.println("範囲内（0～1000）の一円玉の枚数を入力してください");
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

	/**
	 * 一円玉の枚数を返します
	 *
	 * @return oneYen 一円玉の枚数
	 */
	public int getOneYen() {
		return oneYen;
	}
}
