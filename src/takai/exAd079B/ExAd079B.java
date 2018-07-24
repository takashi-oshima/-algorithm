package takai.exAd079B;
/**
 * 入力値をnとしてn番目のリュカ数を出力するプログラムです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd079B {

	public static void main(String[] args) {
		//入力値を受け取り、適切なものであれば変数に格納します。
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanTxt();

		if (!integrityConfirmation.isCanScan()) {
			return;
		}
		SearchLucasNumber searchLucasNumber = new SearchLucasNumber();
		searchLucasNumber.checkNumber(integrityConfirmation.getInputNumber());
	}
}