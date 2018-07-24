package oshima.exAd079B;

/**
 * 整数 N を入力した時、N 番目のリュカ数を求めます。
 * 但し、リュカ数は i 番目のリュカ数を Liとすると、
 * ・L0 = 2
 * ・L1 = 1
 * ・Li = Li-1 + Li-2 (i ≧ 2)と定義される数とします。
 *
 * @author 大島
 */
public class FindLucasNumber {

	/**
	 * 整数 N を入力した時、N 番目のリュカ数を求めます
	 *
	 * @param input Inputクラス
	 */
	public void calcLucasNumber(Input input) {
		long[] LucasNumbers = new long[87];
		int arrayIndex = input.getIntegerN();
		LucasNumbers[0] = 2;
		LucasNumbers[1] = 1;

		// リュカ数を配列に入れ、入力値を配列の添え字にして入力した番目のリュカ数を表示します。
		for (int i = 2; i < 87; i++) {
			LucasNumbers[i] = LucasNumbers[i - 1] + LucasNumbers[i - 2];
		}
		System.out.println(LucasNumbers[arrayIndex]);
	}
}