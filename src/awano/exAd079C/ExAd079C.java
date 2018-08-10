package awano.exAd079C;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd079C {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		Formula formula = new Formula();

		//入力値が正しい場合
		if (inputNumber.checknumber()) {
			//答えが7となる式を出力します。
			System.out.println(formula.createFormula(inputNumber));
		}
	}
}