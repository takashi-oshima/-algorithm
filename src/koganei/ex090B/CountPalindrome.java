package koganei.ex090B;

/**
 * 回文数の数を求め、個数を返すクラス
 *
 * @author 小金井 広輝
 */
public class CountPalindrome {

	/**
	 * 桁数を示す列挙型です
	 *
	 * @author 小金井 広輝
	 */
	public enum ColumnNumber {
		One(0), Two(1), Three(2), Four(3), Five(4);

		private final int number;

		public int getNumber() {
			return number;
		}

		private ColumnNumber(int number) {
			this.number = number;
		}

	}

	/**
	 * A以上B以下の整数のうち、回文数となるものの個数を返します
	 *
	 * @param number 入力された数字
	 * @return 個数
	 */
	public int getCountPalindrome(JudgeNumber number) {

		int count = 0;
		int startNumber = number.getStartNumber();
		int endNumber = number.getEndNumber();

		for (int i = startNumber; i <= endNumber; i++) {

			String stringNumber = String.valueOf(i);

			if (stringNumber.charAt(ColumnNumber.One.getNumber()) == stringNumber.charAt(ColumnNumber.Five.getNumber())
					&&
					stringNumber.charAt(ColumnNumber.Two.getNumber()) == stringNumber
							.charAt(ColumnNumber.Four.getNumber())) {
				//1番目の数字と5番目の数字、かつ2番目の数字と4番目の数字が同じ場合
				count++;
			}
		}
		return count;
	}
}
