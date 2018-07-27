package koganei.ex085C;

/**
 * お年玉の中身の候補をひとつ見つけるクラス
 *
 * @author 小金井 広輝
 */
public class OtoshidamaBill {

	/**
	 * お札の値段を設定したもの
	 *
	 * @author 小金井 広輝
	 */
	public static enum billPrice {
		TenThousandYen(10000), FiftyThousandYen(5000), OneThousandYen(1000);

		private final int number;

		public int getNumber() {
			return number;
		}

		private billPrice(int number) {
			this.number = number;
		}
	}

	/**
	 * お年玉の中身の候補をひとつ見つけ結果を返します
	 * 見つからなかった場合は「-1 -1 -1」を返します
	 *
	 * @param bill 入力されたお札枚数と金額
	 * @return 候補結果
	 */
	public String getOtoshidamaBill(JudgeBill bill) {

		int billCount = bill.getBill();
		int price = bill.getPrice();
		int remainder;

		//10000,5000,1000円札の枚数の初期値を設定します
		//例えば45000円の場合
		//10000円.....4枚
		//5000円......1枚
		//1000円......0枚
		int default10000 = price / billPrice.TenThousandYen.getNumber();
		remainder = price % billPrice.TenThousandYen.getNumber();
		int default5000 = remainder / billPrice.FiftyThousandYen.getNumber();
		remainder = price % billPrice.FiftyThousandYen.getNumber();
		int default1000 = remainder / billPrice.OneThousandYen.getNumber();

		//入力されたお札枚数から10000,5000,1000円札の内訳の全パターンをループで行います
		//順番は
		//10000円札N枚と5000,1000円札の全パターン
		//10000円札N-1枚と5000,1000円札の全パターン
		//10000円札N-2枚と5000,1000円札の全パターン
		//					：
		//
		//例えば45000円の場合
		//10000円: 4 5000円: 1 1000円: 0
		//10000円: 4 5000円: 0 1000円: 5
		//10000円: 3 5000円: 3 1000円: 0
		//10000円: 3 5000円: 2 1000円: 5
		//10000円: 3 5000円: 1 1000円: 10
		//					：

		for (int count10000 = default10000; count10000 >= 0; count10000--) {

			int count1000 = default1000;
			int decreased10000 = default10000 - count10000;
			for (int count5000 = default5000 + 2 * decreased10000; count5000 >= 0; count5000--) {

				if (billCount == count10000 + count5000 + count1000) {
					//入力されたお札枚数と一致した場合
					return count10000 + " " + count5000 + " " + count1000;
				}
				count1000 += 5;
			}
		}
		//見つからなかった場合
		return "-1 -1 -1";
	}
}
