package awano.exAd097A;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd097A {
	public static void main(String[] args) {
		InputPoint inputPoint = new InputPoint();
		Converse converse = new Converse();

		//入力された地点が正しい地点の場合
		if (inputPoint.checkPoint() == true) {
			converse.calcuDistance(inputPoint);
		}
	}
}