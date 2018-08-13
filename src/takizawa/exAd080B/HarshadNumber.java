package takizawa.exAd080B;

/**
 * 整数を10進法で表したときの各桁の和をf(X)としたとき、Xがf(X)で割り切れる場合、
 * Xをシャーハット数とします。入力した値がシャーハッド数かどうかを調べます
 *
 * @author 瀧澤
 */
public class HarshadNumber {
	/**
	 * シャーハッド数かどうかを調べます
	 *
	 * @param check Checkクラス
	 * @return isHarshad シャーハッド数かどうか
	 */
	public boolean isHarshadNumber(Check check) {
		boolean isHarshad = false;

		// 入力値Xをnumberに格納
		int number = check.getInputX();
		int total = 0;

		// numberを文字列に直します
		String numberToString = String.valueOf(number);
		// 文字列に直した物を1文字ずつnumberStrに格納します
		String[] numberStr = numberToString.split("");

		// int型配列numArrayをnumberStr分用意します
		int[] numArray = new int[numberStr.length];

		// int型配列に格納しなおします
		for (int i = 0; i < numberStr.length; i++) {
			numArray[i] = Integer.parseInt(numberStr[i]);
			total += numArray[i];
		}

		// 分割した入力値の合計を出します

		// Xがf(X)で割り切れる場合はYESを表示し、割り切れない場合はNOを表示します
		if (number % total == 0) {
			isHarshad = true;
			System.out.println("YES");
			return isHarshad;
		} else {
			System.out.println("NO");
			return isHarshad;
		}
	}
}