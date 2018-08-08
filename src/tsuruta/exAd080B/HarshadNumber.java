package exAd080B;

/**
 * ハーシャッド数を求めるクラスです
 *
 * @author 鶴田竜也
 */
public class HarshadNumber {

	/**
	 * ハーシャッド数を求めるクラスになります
	 *
	 * @return 入力された値がハーシャッド数か否かを返します
	 */
	public String calcHarshadNumber(InputNumber inputNumber) {

		// 入力値Nを格納します
		int numberN = inputNumber.getNumberN();

		// 入力値の各桁の合計を格納します
		int sum = 0;

		// 入力数字Nを文字列に変換します
		String numN = String.valueOf(numberN);

		// 文字列を各桁毎に分ける為、文字列をchar配列に格納します
		char[] numberArray = numN.toCharArray();

		//入力値の各位の和を求めます。
		for (int i = 0; i < numberArray.length; i++) {

			// char型配列の中身をint型に変換し、sumに代入します
			sum += Character.getNumericValue(numberArray[i]);
		}

		// 入力値Nがシャーハッド数であれば"Yes"を返します
		if (numberN % sum == 0) {
			return "Yes";
		}
		return "No";
	}
}
