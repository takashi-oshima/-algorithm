package koganei.ex098A;

/**
 * 最大の値を返すクラス
 *
 * @author 小金井 広輝
 */
public class Maxnum {

	/**
	 * ふたつの数字の加算、減算、乗算した値のうち最大の値を返します
	 *
	 * @param num ふたつの数字
	 * @return 最大の値
	 */
	public int getMax(JudgeNumber number) {
		int numA = number.getInputNums()[0];
		int numB = number.getInputNums()[1];
		int sum = numA + numB;
		int sub = numA - numB;
		int mul = numA * numB;

		int max = Math.max(sum, Math.max(sub, mul));

		return max;
	}
}
