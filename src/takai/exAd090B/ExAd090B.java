package takai.exAd090B;

/**
 * 入力値の間に存在する回文数を出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd090B {

	public static void main(String[] args) {
		//入力値を受け取り適切かどうか判定し、適切であれば変数に格納します。
		IntegrityConfiration integrityConfiration = new IntegrityConfiration();
		integrityConfiration.scanString();

		if(!integrityConfiration.isRightness()) {
			return;
		}

		//格納された入力値を用いて、回文数かどうかの判定を行います。
		FindPalindrome findPalindrome = new FindPalindrome();
		findPalindrome.palindromeCheck(integrityConfiration.getFromNumber(), integrityConfiration.getToNumber());
	}
}