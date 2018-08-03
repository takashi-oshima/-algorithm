package exAd090B;

/**
 * 始まりの数字から終わりの数字までに含まれている回分数の数を求めます。
 *
 * @author 鶴田竜也
 */
public class Palindrome {

	/**
	 * 回分数の数を求めます。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void countPalindrome(InputNumber inputNumber) {

		/* 始まりの数字 */
		int startNum = inputNumber.getNumberA();
		/* 終わりの数字 */
		int endNum = inputNumber.getNumberB();

		// 回分数の回数を格納するための変数です
		int count = 0;
		for (int i = startNum; i <= endNum; i++) {

			// i(始まりの数字)をString型に変換した後、char配列に格納します
			String startNumber = String.valueOf(i);
			char[] charArray = startNumber.toCharArray();

			// 回分数になったらカウントします
			if (charArray[0] == charArray[4] && charArray[1] == charArray[3]) {
				count++;
			}
		}
		// 回分数の合計を表示します。
		System.out.println(count);
	}
}
