package takai.exAd079A;

/**
 * 3つ以上の同じ数字が連続して並んだ4桁の数であるかを判定するプログラムです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd079A {

	public static void main(String[] args) {
		//入力値を受け取り、適切なものであれば変数に格納します。
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanTxt();

		if (!integrityConfirmation.isCanScan()) {
			return;
		}

		//入力値から3つ以上同じ数字が連続しているかを判定し、boolean型で返します。
		SearchGoodNumber searchGoodNumber = new SearchGoodNumber();
		boolean isGoodNumber = searchGoodNumber.checkNumber(integrityConfirmation.getInputNumber());

		if(!isGoodNumber) {
			System.out.println("No");
			return;
		}
		System.out.println("Yes");
	}
}