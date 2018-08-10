package awano.exAd077D;

/**
 *実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd077D {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		MinValue minValue = new MinValue();

		//入力値が正しい場合
		if (inputNumber.checkNumber()) {
			//入力値Nの正の倍数の各桁の和の最小を求めます。
			minValue.getdigitsSum(inputNumber);
		}
	}
}