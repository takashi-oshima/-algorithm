package takizawa.exAd085C;

/**
 * 田中君が言うには、彼が祖父から受け取ったお年玉袋にはお札がN枚入っていて、合計Y円だった
 * そうです。ですが、嘘かもしれないのでこのような状況がありうるかを判定し、ありうる場合は
 * お年玉袋の中身の候補を一つ見つけます。
 *
 * @author 瀧澤
 *
 */
public class LieDiscovery {
	/** 計算用の10000を用意 */
	public static final int CALC_PRICE1 = 10000;
	/** 計算用の5000を用意 */
	public static final int CALC_PRICE2 = 5000;
	/** 計算用の1000を用意 */
	public static final int CALC_PRICE3 = 1000;

	/**
	 * 嘘かどうかを見抜きます
	 *
	 * @param check Checkクラス
	 */
	public boolean lie(Check check) {
		boolean isLie = true;
		int money = check.getInputY(); // 貰ったとされる金額
		int count = check.getInputN(); // 貰ったとされる枚数
		int tenThousandYenBills = 0; // 1万円札の枚数
		int fiveThousandYenBills = 0; // 5千円札の枚数
		int thousandYenBills = 0; // 千円札の枚数

		// 貰ったとされる枚数になるまで1万円札の枚数を数えます
		for (int i = 0; i <= count; i++) {
			tenThousandYenBills = i;
			// 貰ったとされる枚数になるまで5千円札の枚数、千円札の枚数を数えます
			for (int j = 0; j <= count - i; j++) {
				fiveThousandYenBills = j;
				thousandYenBills = count - tenThousandYenBills - fiveThousandYenBills;

				// 数えた枚数分の合計額が入力した値とあっていればループを抜けます
				if (CALC_PRICE1 * tenThousandYenBills + CALC_PRICE2 * fiveThousandYenBills
						+ CALC_PRICE3 * thousandYenBills == money) {
					isLie = false;
					System.out.println(tenThousandYenBills + " " + fiveThousandYenBills + " " + thousandYenBills);
					return isLie;
				}
			}
		}
		// 合計枚数、金額が入力した値とあっていなかった場合
		if (isLie) {
			System.out.println("-1 -1 -1");
		}
		return isLie;
	}
}