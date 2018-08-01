package awano.exAd086B;

/**
 * 実行用のクラスです。
 * 整数aとbをこの順に繋げて読んだものが平方数かどうか判定します。
 *
 * @author 粟野真司
 */
public class ExAd086B {
	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();

		//入力値が正しい場合
		if (inputNumber.checkInputNumber(inputNumber)) {
			//入力値の平方根を求めます。
			int squareRoot = (int) Math.sqrt(inputNumber.getInteger());
			//平方根を2乗した値
			int squareNumber = squareRoot * squareRoot;

			//平方数かどうか判定します。
			if (inputNumber.getInteger() == squareNumber) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}