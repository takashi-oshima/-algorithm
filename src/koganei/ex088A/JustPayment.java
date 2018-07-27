package koganei.ex088A;

/**
 * ちょうど支払うことができるか判定するクラス
 *
 * @author 小金井 広輝
 */
public class JustPayment {

	/** 五百円 */
	final int FIVE_HUNDRED_YEN = 500;

	/**
	 * ちょうど入力された金額を払うことができるかの判定をし、結果を表示します
	 *
	 * @param price 入力された金額と一円玉の数
	 * @return 判定結果
	 */
	public String JudgeJustPayment(JudgePrice price) {

		int remainder = price.getPrice() % FIVE_HUNDRED_YEN;
		int oneYen = price.getOneYen();

		if (remainder <= oneYen) {
			return "Yes";
		} else {
			return "No";
		}
	}
}
