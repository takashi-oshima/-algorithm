package oshima.exAd080B;

/**
 * 整数 X を 10 進法で表したときの各桁の数字の和を f(X)としたとき、X が f(X)で割り切れる場合、 X はハーシャッド数です。 入力値整数 N
 * が、ハーシャッド数かどうか判定します。
 *
 * @author 大島
 */
public class FindHarshadNumber {

	/**
	 * 入力値整数 N が、ハーシャッド数かどうか判定し、結果を表示します。
	 *
	 * @param input Inputクラス
	 */
	public void findHarshad(Input input) {
		String stringN = input.getStringN();
		String splitStringN = "";
		int integerN = Integer.parseInt(stringN);
		int sumSplitIntegerN = 0;

		// 入力された値を1文字ずつ分割し、それらを合計した値が元の入力値を割り切れるかどうか見ます。
		for (int i = 0; stringN.length() > i; i++) {
			splitStringN = String.valueOf(stringN.charAt(i));
			sumSplitIntegerN += Integer.parseInt(splitStringN);
		}

		if (integerN % sumSplitIntegerN == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}