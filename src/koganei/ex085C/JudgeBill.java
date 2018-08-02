package koganei.ex085C;

import koganei.Input;
import koganei.ex085C.OtoshidamaBill.billPrice;

/**
 * 正しく入力できているか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JudgeBill {
	/** 入力されたお札の枚数 */
	private int billCount;
	/** 入力された金額 */
	private int price;

	/**
	 * 入力されたお札の枚数と金額を設定し、正しく設定できたかの判定結果を返します
	 *
	 * @param input 入力された文字
	 * @return 判定結果
	 */
	public boolean judgeBill(Input input) {

		String[] inputString = input.getInputString();

		if (inputString.length != 2) {
			System.out.println("入力値は2つでなければなりません");
			return false;
		}

		try {
			this.billCount = Integer.parseInt(inputString[0]);
			this.price = Integer.parseInt(inputString[1]);
		} catch (Exception e) {
			System.out.println("数字に変換できませんでした");
			return false;
		}

		if (billCount < 1 || billCount > 2000) {
			System.out.println("範囲内（1～2000）のお札の枚数を入力してください");
			return false;
		}

		if (price < 1000 || price > 20000000) {
			System.out.println("範囲内（1000～20000000）の金額を入力してください");
			return false;
		}

		if (price % billPrice.OneThousandYen.getNumber() != 0) {
			System.out.println("金額は1000の倍数で入力してください");
			return false;
		}
		return true;
	}

	/**
	 * 入力されたお札の枚数を返します
	 *
	 * @return bill 入力されたお札の枚数
	 */
	public int getBill() {
		return billCount;
	}

	/**
	 * 入力された金額を返します
	 *
	 * @return price ひとつめに入力された数字
	 */
	public int getPrice() {
		return price;
	}
}
