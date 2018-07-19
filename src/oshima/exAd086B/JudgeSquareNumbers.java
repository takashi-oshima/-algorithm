package oshima.exAd086B;

/**
 * a と b をこの順に繋げて読んだものが平方数かどうか判定します。
 *
 * @author 大島
 */
public class JudgeSquareNumbers {

	/**
	 * 入力した値は平方数かどうかを判定します。
	 *
	 * @param input Inputクラス
	 * @return 平方数かどうか
	 */
	public boolean judgeSquareNumber(Input input) {
		boolean judge = false;
		String[] inputNumbers = input.getInputNumbers();

		// 1~100の数字が格納されている文字列
		String numberA = inputNumbers[0];
		String numberB = inputNumbers[1];

		String numberAB = numberA + numberB;

		int numberC = Integer.parseInt(numberAB);
		int result = (int) Math.sqrt(numberC);

		if (result * result == numberC) {
			judge = true;
		}
		return judge;
	}
}
