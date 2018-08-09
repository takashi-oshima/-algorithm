package awano.exAd071B;

/**
 * 入力文字Sと英小文字を比較し、
 * 入力文字Sに現れない英小文字であって、最も辞書順で小さいものを出力します。
 * 但し、入力文字Sに全ての英小文字が現れる場合は「None」と出力します。
 *
 * @author 粟野真司
 *
 */
public class NotAppearAlphabet {
	/**
	 * 入力文字Sに現れない英小文字を探します。
	 *
	 * @param inputWord InputWordクラス
	 */
	public void findAlphabet(InputWord inputWord) {
		String[] alphabetArray = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" };
		String result = "";
		for (int i = 0; i < alphabetArray.length; i++) {
			if (!inputWord.getInputS().contains(alphabetArray[i])) {
				result = alphabetArray[i];
				System.out.println(result);
				return;
			}
		}
		System.out.println("None");
	}
}