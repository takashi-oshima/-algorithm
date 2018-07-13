package exAd090B;

/**
 * 入力値間に回文数が存在するかを求め、その個数を出力するクラスです。
 *
 * @author 髙井勇輝
 *
 */
public class FindPalindrome {
	public enum IntIndex {
		One(0), Two(1), Fore(3), Five(4);

		final int intIndex;

		public int getIntIndex() {
			return intIndex;
		}

		private IntIndex(int intIndex) {
			this.intIndex = intIndex;
		}
	}

	/**
	 * 入力値間に回文数がないかを判定し、何個存在したかを出力します。
	 *
	 * @param fromNumber 入力値1_開始の数値
	 * @param toNumber 入力値2_終了の位置
	 */
	public void palindromeCheck(String fromNumber, String toNumber) {

		int palindromeCount = 0;
		while (!fromNumber.equals(toNumber)) {
			if (fromNumber.charAt(IntIndex.One.getIntIndex()) != fromNumber.charAt(IntIndex.Five.getIntIndex())) {
				fromNumber = String.valueOf(Integer.parseInt(fromNumber) + 1);
				continue;
			}

			if (fromNumber.charAt(IntIndex.Two.getIntIndex()) != fromNumber.charAt(IntIndex.Fore.getIntIndex())) {
				fromNumber = String.valueOf(Integer.parseInt(fromNumber) + 1);
				continue;
			}
			palindromeCount++;
			fromNumber = String.valueOf(Integer.parseInt(fromNumber) + 1);
		}
		System.out.println(palindromeCount + "個です。");
	}
}