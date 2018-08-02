package awano.exAd088A;

/**
 * 1円硬貨をA枚と500円硬貨を無限枚持っているとします。
 * これらの硬貨だけを使って、
 * ちょうどN円支払うことができるか判定するクラスです。
 *
 * @author 粟野真司
 */
public class Payment {
	/**
	 * 所持金でちょうどN円支払うことができるかどうか判定します。
	 *
	 * @param inputMoney InputMoneyクラス
	 * @return 支払うことができるかどうか
	 */
	public boolean canPayment(InputMoney inputMoney) {
		boolean canPayment = false;
		//500円硬貨
		final int FIVE_HUNDRED = 500;
		//支払い金額
		int nYen = inputMoney.getPayMoney();
		//1円の所持枚数
		int haveOneYen = inputMoney.getOneYenCoin();

		/*N円（支払い金額）が0になるまで、
		 * もしくは、1円の所持枚数が0になるまでwhile文を回します*/
		while (nYen != 0) {

			if (nYen % FIVE_HUNDRED == 0) {
				break;
			}

			if (nYen >= FIVE_HUNDRED) {
				nYen -= FIVE_HUNDRED;
			}

			if (haveOneYen != 0 && nYen < FIVE_HUNDRED) {
				haveOneYen--;
				nYen--;
			}

			//1円の所持枚数が0になった場合
			if (haveOneYen == 0) {
				break;
			}
		}
		//N円(支払い金額)が0になった場合
		if (nYen % FIVE_HUNDRED == 0) {
			canPayment = true;
		}
		return canPayment;
	}
}