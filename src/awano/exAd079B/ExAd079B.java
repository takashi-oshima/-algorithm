package awano.exAd079B;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd079B {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		LucasNumber lucasNumber = new LucasNumber();

		//正しい入力値の場合
		if (inputNumber.checkInputNumber()) {
			//入力値N番目のリュカ数を求めます。
			lucasNumber.calcuLucasNumber(inputNumber);
		}
	}
}