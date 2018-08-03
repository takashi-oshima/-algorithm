package takizawa.exAd088A;

/**
 * 佐藤さんは1円硬貨A枚と500円硬貨を∞枚持っています。
 * これらの硬貨を使って、N円ぴったりの買い物をできるか判定します。
 *
 * @author 瀧澤
 */
public class Payment {
	/**
	 * N円ぴったり買い物できるか計算します
	 *
	 * @param check Checkクラス
	 */
	public static final int FIVEHUNDRED_COIN = 500;
	public void payment(Check check) {
		int purchacePrice = check.getNumberN();
		int oneYenCoinNumber = check.getNumberA();



		int quotient = purchacePrice / FIVEHUNDRED_COIN ;     // N円/500円の商
		int remainder = purchacePrice % FIVEHUNDRED_COIN ;    // N円/500円の剰余

		// 持っている1円玉の数が剰余以上で、1円玉と500円玉を使ってN円になるとき
		if(oneYenCoinNumber >= remainder && remainder + (quotient * FIVEHUNDRED_COIN ) == purchacePrice) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}