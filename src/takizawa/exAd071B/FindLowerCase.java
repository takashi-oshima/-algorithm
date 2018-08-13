package takizawa.exAd071B;

/**
 * 英小文字からなる文字列Sが与えられます。Sに現れない英小文字であって、最も辞書順
 * で小さいものを求めます。但し、Sにすべての英小文字が現れる場合は、代わりに「None」
 * を出力します。
 *
 * @author 瀧澤
 */
public class FindLowerCase {
	/**
	 * 入力されていない英小文字の中で最も小さいものを探します
	 *
	 * @param check Checkクラス
	 * @return result 結果
	 */
	public String findLowerCase(Check check) {
		// 入力文字列をinputSとします
		String inputS = check.getInputS();
		// aからzまでの26文字を格納
		String[] searchLowerCase = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z" };
		String result = "";

		for (int i = 0; i < searchLowerCase.length; i++) {

			// 入力文字に含まれていない文字が見つかった場合resultに１文字入れて処理を抜ける
			if (!inputS.contains(searchLowerCase[i])) {
				result = searchLowerCase[i];
				return result;
			}
		}

		// 入力文字にa-zまでの26文字が含まれていた場合はNoneを表示する
		if (result == "") {
			System.out.println("None");
		}
		return result;
	}
}