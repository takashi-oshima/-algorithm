package awano.exAd099C;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd099C {
	public static void main(String[] args) {
		InputPrice inputPrice = new InputPrice();
		DrowOutMoney drowOutMoney = new DrowOutMoney();
		//入力値が正しい場合
		if (inputPrice.checkPrice()) {
			//N円の引き出し回数を求めます。
			drowOutMoney.drawerTimes(inputPrice);

		}
	}
}