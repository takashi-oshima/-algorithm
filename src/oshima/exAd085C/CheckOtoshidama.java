package oshima.exAd085C;

/**
 * 日本でよく使われる紙幣は 10000 円札、5000 円札、1000 円札です。以下、「お札」とはこの 3 種を指します。 お年玉袋にはお札が N
 * 枚入っていて、合計 Y 円だったそうですが、ウソかもしれません。 このような状況がありうるか判定し、ありうる場合はお年玉袋の中身の候補を一つ見つけます。
 *
 * @author 大島
 */
public class CheckOtoshidama {

	/**
	 * BillTypeは、各紙幣の金額を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum BillType {
		TenThousandYen(10000), FiveThousandYen(5000), ThousandYen(1000);

		final int type;

		public int getType() {
			return type;
		}

		private BillType(int type) {
			this.type = type;
		}
	}

	/**
	 * Y円が10000円 5000円 1000円N枚で満たせるかどうかを判定し、結果を表示します。
	 * 判定方法として、お札の総数と金額の総数とを解とする二元連立方程式を用います。
	 *
	 * @param input Inputクラス
	 */
	public void judgeLiar(Input input) {
		// Y円が10000円 5000円 1000円N枚で満たせるかどうか
		boolean judge = false;
		// 紙幣の総数
		int totalBill = input.getIntegerN();
		// 現在の紙幣の枚数
		int bill = input.getIntegerN();
		// 金額の総数
		int totalMoney = input.getIntegerY();
		// 現在の金額の総数
		int money = input.getIntegerY();
		// 1万円の枚数
		int tenThousandBillCount = 0;
		// 5000円の枚数
		int fiveThousandBillCount = 0;
		// 1000円の枚数
		int thousandBillCount = 0;

		while (tenThousandBillCount < totalBill) {

			// 以下の二元連立方程式をクラメルの公式に基づいて変換します。
			// fiveThousandBillCount + thousandBillCount = totaBill;
			// fiveThousandBillCount * BillType.FiveThousandYen.getType() +
			// thousandBillCount * BillType.ThousandYen.getType() = totalMoney;
			fiveThousandBillCount = (BillType.ThousandYen.getType() * bill - money)
					/ (BillType.ThousandYen.getType() - BillType.FiveThousandYen.getType());
			thousandBillCount = (money - BillType.FiveThousandYen.getType() * bill)
					/ (BillType.ThousandYen.getType() - BillType.FiveThousandYen.getType());

			int totalThousandBill = thousandBillCount * BillType.ThousandYen.getType();
			int totalFiveThousandBill = fiveThousandBillCount * BillType.FiveThousandYen.getType();

			if (fiveThousandBillCount + thousandBillCount == bill && totalFiveThousandBill + totalThousandBill == money
					&& fiveThousandBillCount >= 0 && thousandBillCount >= 0) {
				judge = true;
				break;
			}
			// 1万円札を増やし、残金と残りお札枚数から増やした分を引きます。また、1万円だけでお年玉か満たせるか判定します。
			tenThousandBillCount++;
			int totalTenThousandBill = tenThousandBillCount * BillType.TenThousandYen.getType();
			money -= BillType.TenThousandYen.getType();
			bill -= 1;
			fiveThousandBillCount = 0;
			thousandBillCount = 0;

			if (tenThousandBillCount == totalBill && totalTenThousandBill == totalMoney) {
				judge = true;
				break;
			}
		}

		if (judge) {
			System.out.println(tenThousandBillCount + " " + fiveThousandBillCount + " " + thousandBillCount);
		} else {
			System.out.println("-1 -1 -1");
		}
	}
}