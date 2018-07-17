package oshima.exAd085C;

public class Otoshidama {

	/**
	 * Y円が10000円 5000円 1000円N枚で満たせるかどうかを判定します。
	 *
	 * @param input Inputクラス
	 * @return 満たせる時のそれぞれの紙幣の枚数
	 */
	public int[] judgeLiar(Input input) {
		int[] billCount = { 0, 0, 0 };
		int totalBill = input.getIntegerN();
		int totalMoney = input.getIntegerY();

		//必要条件
		//1 使った各お札の枚数の総計が合計枚数と一致すること billCount[0] + billCount[1] + billCount[2] == totalBill
		//2 使った各お札の枚数 *札種が合計金額と一致すること billCount[0] * TEN_THOUSAND_BILL + billCount[1] * FIVE_THOUSAND_BILL + billCount[2] * THOUSAND_BILL == totalMoney

		return billCount;
	}

	/**
	 * 一万円札がお年玉の中に何枚入っていたかを求めます。
	 *
	 * @param totalBill お札の合計枚数
	 * @param totalMoney お年玉の合計額
	 * @return 一万円札を使った枚数
	 */
	public int tenThousandBillCount(int totalBill, int totalMoney) {
		final int TEN_THOUSAND_BILL = 10000;
		int tenThousandBillCount = 0;
		totalMoney -= TEN_THOUSAND_BILL;

		return tenThousandBillCount;
	}

	/**
	 * 五千円札がお年玉の中に何枚入っていたかを求めます。
	 *
	 * @param totalBill お札の合計枚数
	 * @param totalMoney お年玉の合計額
	 * @return 五千円札を使った枚数
	 */
	public int fiveThousandBillCount(int totalBill, int totalMoney) {
		final int FIVE_THOUSAND_BILL = 5000;
		int fiveThousandBillCount = 0;
		totalMoney -= FIVE_THOUSAND_BILL;

		return fiveThousandBillCount;
	}

	/**
	 * 千円札がお年玉の中に何枚入っていたかを求めます。
	 *
	 * @param totalBill お札の合計枚数
	 * @param totalMoney お年玉の合計額
	 * @return 千円札を使った枚数
	 */
	public int thousandBillCount(int totalBill, int totalMoney) {
		final int THOUSAND_BILL = 1000;
		int thousandBillCount = 0;
		totalMoney -= THOUSAND_BILL;

		return thousandBillCount;
	}
}