package exAd098A;

/**
 * 実行用クラスになります。
 *
 * @author 鶴田竜也
 */
public class ExAd098A {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		CalculationMax calculationMax = new CalculationMax();

		if (inputNumber.isValidInput()) {
			calculationMax.calcMax(inputNumber);
		}
	}
}