package exAd098A;

/**
 * 2つの入力値の和、差、積のうち、最も大きいものを出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd098A {

	public enum IntLength {
		Min(-1000), Max(1000);

		final int length;

		public int getLength() {
			return length;
		}

		private IntLength(int length) {
			this.length = length;
		}
	}

	public static void main(String[] args) {
		//入力値が適切かを判定し、計算結果を変数に格納します。
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanString();

		//計算結果を比較し、最も大きい値を出力します。
		MaxResearch maxResearch = new MaxResearch();
		System.out.println(maxResearch.maxNumber(integrityConfirmation.getSum(), integrityConfirmation.getDifference(),
				integrityConfirmation.getProduct()));
	}
}