package awano.exAd098A;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd098A {
	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		FindMax findMax = new FindMax();

		//入力され数値が正しい数値の場合
		if (inputNumber.checkNumber()) {
			findMax.calcuNum(inputNumber);
		}
	}
}