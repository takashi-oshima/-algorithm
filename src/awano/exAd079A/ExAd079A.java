package awano.exAd079A;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd079A {
	public static void main(String[] args) {
		InputInteger inputInteger = new InputInteger();
		GoodIntegr goodIntegr = new GoodIntegr();

		//正しい入力値の場合
		if (inputInteger.checkInputNumber()) {
			//入力値Nが良い整数か判定します。
			goodIntegr.isGoodIntegr(inputInteger);
		}
	}
}