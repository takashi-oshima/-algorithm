package takizawa.exAd090B;

/**
 *A以上B以下の整数のうち、回分数の個数を求めます
 *
 * @author 瀧澤
 */
public class PalindromeNumber {
	/**
	 * 入力値1から入力値2までの範囲の回文数を求める
	 *
	 * @param check Checkクラス
	 * @return count 回分数の数
	 */
	public int palindromeCount(Check check) {
		int count = 0;
		int inputNumberA = check.getNumberA();
		int inputNumberB = check.getNumberB();

		for (int i = inputNumberA; i <= inputNumberB; i++) {
			int l1 = i / 10000;     // 万の位
			int l2 = i / 1000 % 10; // 千の位
			int l3 = i / 10 % 10;   // 十の位
			int l4 = i / 1 % 10;    // 一の位

			// 万の位と一の位、千の位と十の位が等しいときが回分数となります
			if (l1 == l4 && l2 == l3) {
				count++;
			}
		}
		return count;
	}
}