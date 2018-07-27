package takai.exAd071B;

public class ExAd071B {

	public static void main(String[] args) {
		//入力値を受け取り、適切なものであれば変数に格納します。
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanTxt();

		if (!integrityConfirmation.isCanScan()) {
			return;
		}
		FindNotContainsEnglish findNotContainsEnglish = new FindNotContainsEnglish();
		findNotContainsEnglish.searchEnglish(integrityConfirmation.getInputString());
	}
}
