package exAd088A;

/**
 * 入力された数字を500円玉と1円玉だけで支払いできるか判定するクラスです。
 *
 * @author 鶴田竜也
 */
public class Payment {

	// 500円玉
	private final int FIVE_HUNDRED_YEN = 500;

	/**
	 *  入力された数字を500円玉と1円玉だけで支払いできるか判定します。
	 * 支払い可能であれば"yes"、支払い不可であれば"No"を返します。
	 *
	 * @param inputNumber InputNumberクラス
	 * @return 支払い可否の文字列
	 */
	public String calcPay(InputNumber inputNumber) {

		// 所持金
		int possessionMoney = inputNumber.getNumberN();
		// 所持金を500円で割った余りの金額
		int remainder = possessionMoney % FIVE_HUNDRED_YEN;
		// 1円玉
		int oneYen = inputNumber.getNumberA();

		// 1円玉を余りの金額以上保持していれば"Yes"を返します
		if (oneYen >= remainder) {
			return "Yes";
		} else {
			return "No";
		}
	}
}
