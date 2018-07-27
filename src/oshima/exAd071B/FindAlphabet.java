package oshima.exAd071B;

/**
 * 入力値として英小文字からなる文字列 S があります。 S に現れない英小文字であって、最も辞書順(アルファベット順)で小さいものを求めます。
 * 但し、Sにすべての英小文字が現れる場合は、代わりに「None」を出力します。
 *
 * @author 大島
 */
public class FindAlphabet {

	/**
	 * 入力した文字列Sに現れない英文字を検索し、最も辞書順で小さいものを表示します。
	 *
	 * @param input Inputクラス
	 */
	public void findAndSortAlphabet(Input input) {
		String strS = input.getStrS();
		// 結果の表示文
		String result = "None";
		// 全半角アルファベットが格納されている配列
		final String[] ALL_ALPHABET = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		for (int i = 0; i < ALL_ALPHABET.length; i++) {

			if (!strS.contains(ALL_ALPHABET[i])) {
				result = ALL_ALPHABET[i];
				break;
			}
		}
		System.out.println(result);
	}
}