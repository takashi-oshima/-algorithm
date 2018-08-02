package takai.exAd080B;

/**
 * 入力値がハーシャッド数であるかどうかを判定するプログラムです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd080B {

	public static void main(String[] args) {
		//入力値を受け取り、適切なものであれば変数に格納します。
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanTxt();

		if (!integrityConfirmation.isCanScan()) {
			return;
		}

		//入力値を元に、入力値がハーシャッド数かどうかを判定し、boolean型で返します。
		HarshadNumberDecision harshadNumberDecision = new HarshadNumberDecision();
		boolean isHarshadNumber = harshadNumberDecision.searchHarshad(integrityConfirmation.getInputNumber());

		if (!isHarshadNumber) {
			System.out.println("No");
			return;
		}

		System.out.println("Yes");
	}
}