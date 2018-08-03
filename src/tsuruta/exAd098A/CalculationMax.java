package exAd098A;

/**
 * 入力された2つ数字を足し算、引き算、掛け算し、
 * その中での最大値を求めます。
 *
 * @author 鶴田竜也
 */
public class CalculationMax {

	/**
	 * 入力された数字の最大値を返します。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void calcMax(InputNumber inputNumber) {
		int addition = inputNumber.getNumberA() + inputNumber.getNumberB();
		int subtraction = inputNumber.getNumberA() - inputNumber.getNumberB();
		int multiplication = inputNumber.getNumberA() * inputNumber.getNumberB();

		// 足し算、引き算、掛け算した結果を比較し、最大値を出力します。
		int tmpMax = Math.max(addition, subtraction);
		int max = Math.max(tmpMax, multiplication);

		System.out.println("最大値は" + max + "です");
	}
}
