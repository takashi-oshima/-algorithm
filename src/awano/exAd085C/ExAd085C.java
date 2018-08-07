package awano.exAd085C;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd085C {

	public static void main(String[] args) {
		InputAmount inputAmount = new InputAmount();
		Lottery lottery = new Lottery();

		//入力値が正しい場合
		if (inputAmount.checkInputAmount()) {
			//お年玉袋の中身の候補を表示します。
			lottery.predictLottery(inputAmount);
		}
	}
}