package exAd090B;

/**
 * 始まりの数字から終わりの数字までに含まれている回文数の数を求めます。
 *
 * @author 鶴田竜也
 */
public class Palindrome {

	/**
	 * 回文数の数を求めます。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void countPalindrome(InputNumber inputNumber) {

		/* 始まりの数字 */
		int firstNum = inputNumber.getNumberA();
		/* 終わりの数字 */
		int lastNum = inputNumber.getNumberB();

		// 回文数の回数を格納するための変数です
		int count = 0;
		for (int i = firstNum; i <= lastNum; i++) {

			// i(始まりの数字)をString型に変換した後、char配列に格納します
			String firstNumber = String.valueOf(i);
			char[] charArray = firstNumber.toCharArray();

			// 回文数になったらカウントします
			if (charArray[0] == charArray[4] && charArray[1] == charArray[3]) {
				count++;
			}
		}
		// 回文数の合計を表示します。
		System.out.println(count);
	}
}
