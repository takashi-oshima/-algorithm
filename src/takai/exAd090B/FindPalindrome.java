package takai.exAd090B;

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
	public void palindromeCheck(int fromNumber, int toNumber) {
		int palindromeCount = 0;

		while (!(toNumber < fromNumber)) {
			String fromNumberString = Integer.toString(fromNumber);

			if (fromNumberString.charAt(IntIndex.One.getIntIndex()) != fromNumberString
					.charAt(IntIndex.Five.getIntIndex())) {
				fromNumber = Integer.parseInt(fromNumberString) + 1;
				continue;
			}

			if (fromNumberString.charAt(IntIndex.Two.getIntIndex()) != fromNumberString
					.charAt(IntIndex.Fore.getIntIndex())) {
				fromNumber = Integer.parseInt(fromNumberString) + 1;
				continue;
			}
			palindromeCount++;
			fromNumber = Integer.parseInt(fromNumberString) + 1;
		}
		System.out.println(palindromeCount + "個です。");
	}
}