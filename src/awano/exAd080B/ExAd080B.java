package awano.exAd080B;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd080B {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		HarshadNumber harshadNumber = new HarshadNumber();
		//正しい入力値の場合
		if (inputNumber.checkNumber(inputNumber)) {
			//ハーシャッド数かどうか判定します。
			harshadNumber.isHarshadNumber(inputNumber);
		}
	}
}