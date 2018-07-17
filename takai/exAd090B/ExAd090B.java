package takai.exAd090B;

/**
 * 入力値の間に存在する回文数を出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd090B {

	public enum IntLength {
		Min(10000), Max(99999);

		final int length;

		public int getLength() {
			return length;	
		}

		private IntLength(int length) {
			this.length = length;
		}
	}

	public static void main(String[] args) {
		//入力値を受け取り適切かどうか判定し、適切で張れば変数に格納します。
		IntegrityConfiration integrityConfiration = new IntegrityConfiration();
		integrityConfiration.scanString();

		//格納された入力値を用いて、回文数かどうかの判定を行います。
		FindPalindrome findPalindrome = new FindPalindrome();
		findPalindrome.palindromeCheck(integrityConfiration.getFromNumber(), integrityConfiration.getToNumber());
	}
}