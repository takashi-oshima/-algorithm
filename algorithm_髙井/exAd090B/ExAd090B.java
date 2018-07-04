package exAd090B;

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
		IntegrityConfiration integrityConfiration = new IntegrityConfiration();
		integrityConfiration.scanString();

		FindPalindrome findPalindrome = new FindPalindrome();
		System.out.println(findPalindrome.palindromeCheck(integrityConfiration));
	}
}