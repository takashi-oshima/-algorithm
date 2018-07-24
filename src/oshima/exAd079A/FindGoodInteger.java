package oshima.exAd079A;

/**
 * 1118 のような、3 つ以上の同じ数字が連続して並んだ 4 桁の整数を良い整数とします。 入力値の4 桁の整数 N が良い整数かどうか判定します。
 *
 * @author 大島
 */
public class FindGoodInteger {

	/**
	 * 整数 N が良い整数かどうか判定し、結果を表示します。
	 *
	 * @param input Inputクラス
	 */
	public void isGoodInteger(Input input) {
		boolean isGoodInteger = false;
		String integerN = input.getStringN();
		String splitIntegerN = "";
		String[] compareNumbers = new String[integerN.length()];

		// 入力値を1文字ずつ分割し、3つ同じ値であり、連続しているかを判定します。
		for (int i = 0; integerN.length() > i; i++) {
			splitIntegerN = String.valueOf(integerN.charAt(i));
			compareNumbers[i] = splitIntegerN;
		}

		if(compareNumbers[0].equals(compareNumbers[1]) && compareNumbers[0].equals(compareNumbers[2])) {
			isGoodInteger = true;
		}

		if(compareNumbers[1].equals(compareNumbers[2]) && compareNumbers[1].equals(compareNumbers[3])) {
			isGoodInteger = true;
		}

		if(isGoodInteger) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}