package exAd071B;

/**
 * 実行用のクラスになります。
 *
 * 入力文字Sと英小文字を比較し、
 * Sに現れない英小文字であって、辞書順で最も小さいものを出力します。
 * 但し、入力文字Sに全ての英小文字が現れる場合は「None」と出力します。
 *
 * @author 鶴田竜也
 */
public class ExAd071B {

	public static void main(String[] args) {

		InputString inputString = new InputString();
		LowerCase lowerCase = new LowerCase();

		// 入力チェックを行います
		if(inputString.isValidInput()) {
		// 結果を表示します
		lowerCase.notfoundLowerCase(inputString);
		}
	}
}
