package exAd098A;

/**
 * 2 つの整数 A, B が与えられます。A+B, A-B, A×B の中で最大の値を求めます。
 *
 * @author 大島
 */
public class MaxValue {

	/**
	 * A+B, A-B, A×B の中で最大の値を求めます。
	 *
	 * @param input Inputクラス
	 *
	 * @return 入力した整数における足し算、引き算、掛け算の中で最大の値
	 */
	public int calcMax(Input input) {
		int addition = input.getIntegerA() + input.getIntegerB();
		int subtraction = input.getIntegerA() - input.getIntegerB();
		int multiplication = input.getIntegerA() * input.getIntegerB();

		int max = Math.max(addition, Math.max(subtraction, multiplication));

		return max;
	}
}
