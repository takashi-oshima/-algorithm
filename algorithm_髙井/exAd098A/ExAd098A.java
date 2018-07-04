package exAd098A;

public class ExAd098A {

	public enum IntLength{
		Min(-1000),Max(1000);

		final int length;

		public int getLength() {
			return length;
		}

		private IntLength(int length) {
			this.length = length;
		}
	}

	public static void main(String[] args) {
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanString();

		MaxResearch maxResearch = new MaxResearch();
		System.out.println(maxResearch.maxNumber(integrityConfirmation));
	}
}