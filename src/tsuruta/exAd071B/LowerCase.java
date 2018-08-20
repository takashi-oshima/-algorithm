package exAd071B;

/**
 * 入力値に含まれていない英小文字の中で、辞書順で最も小さい英小文字を求めます。
 *
 * @author 鶴田竜也
 */
public class LowerCase {

	/**
	 * 入力値に含まれていない英小文字の中で辞書順で最も小さい英小文字を求めます。
	 * 入力値の中に全ての英小文字が含まれていたら「None」を返します。
	 *
	 * @param inputString InputStringクラス
	 */
	public void notfoundLowerCase(InputString inputString) {
		// 入力された英小文字を格納します
		String inputS = inputString.getNumberS();

		// 英小文字を格納します
		final String[] ｌowerCase = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z" };

		// 入力値Sに含まれていない英小文字を格納します
		String differentLowerCase = "";

		// 入力値Sの中に英小文字が含まれているか調べます
		for (int i = 0; i < ｌowerCase.length; i++) {
			// 入力値Sに含まれていない英小文字があったとき
			if (!inputS.contains(ｌowerCase[i])) {
				differentLowerCase = ｌowerCase[i];
				// 入力値に含まれていない、最も小さい英小文字を出力します
				System.out.println(differentLowerCase);
				return;
			}
		}

		// 入力値の中に全ての英小文字が現れなかった時に出力します
		System.out.println("None");
	}
}