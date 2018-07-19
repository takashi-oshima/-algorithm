package takai.exAd085C;

import takai.exAd085C.Enum.BillRate;

/**
 * 入力された枚数と値があり得るのかを計算します
 *
 * @author 高井勇輝
 *
 */
public class CheckIsLie {
	/**
	 * 入力された枚数と値があり得るのかを計算します
	 *
	 * @param count 枚数
	 * @param amount 金額
	 */
	public void checkAmount(int count, int amount) {
		/** 現在の金額 */
		int nowAmount = 0;
		/** 1万円札の数 */
		int tenThousandBillCount = 0;
		/** 5千円札の数 */
		int fiveThousandBillCount = 0;
		/** 千円札の数 */
		int thousandBillCount = 0;
		/** あり得るかどうか */
		boolean isTrue = false;

		//amount == 10000 * tenThousandBillCount + 5000 * fiveThousandBillCount + 1000 * thousandBillCount
		//count == tenThousandBillCount + fiveThousandBillCount + thousandBillCount
		//上記の連立方程式を、tenThousandBillCount = 0を初期値として計算し、金額と枚数が入力値と一致するか、
		//fiveThousandBillCountが負数になるまで繰り返します。
		while (fiveThousandBillCount >= 0) {
			fiveThousandBillCount = ((amount / 1000) - count - (tenThousandBillCount * 9)) / 4;
			thousandBillCount = count - tenThousandBillCount - fiveThousandBillCount;

			if (thousandBillCount < 0 || fiveThousandBillCount < 0) {
				tenThousandBillCount++;
				continue;
			}

			//枚数と金額を確認します。
			nowAmount = (tenThousandBillCount * BillRate.TenThousand.getBillRate())
					+ (fiveThousandBillCount * BillRate.FiveThousand.getBillRate())
					+ (thousandBillCount * BillRate.Thousand.getBillRate());

			if (nowAmount == amount) {
				isTrue = true;
				break;
			}
			tenThousandBillCount++;
		}

		if (isTrue) {
			System.out.println(tenThousandBillCount + " " + fiveThousandBillCount + " " + thousandBillCount);
		} else {
			System.out.println("-1 -1 -1");
		}
	}
}