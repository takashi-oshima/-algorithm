package takai.exAd071B;

/**
 * 与えられた文字列から、その文字列に含まれていない英小文字かつ、
 * 最も辞書順で小さいものを出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd071B {

	public static void main(String[] args) {
		//入力値を受け取り、適切なものであれば変数に格納します。
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanTxt();

		//入力値から、その文字列に含まれていない英小文字かつ、
		//最も辞書順で小さいものを出力します。
		FindNotContainsAlpfabrt findNotContainsAlpfabrt = new FindNotContainsAlpfabrt();
		findNotContainsAlpfabrt.searchAlpfabrt(integrityConfirmation.getInputString());
	}
}
