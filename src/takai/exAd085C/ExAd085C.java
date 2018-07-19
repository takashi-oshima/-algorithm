package takai.exAd085C;

public class ExAd085C {

	public static void main(String[] args) {
		//入力値を受け取り適切かどうか判定し、適切で張れば変数に格納します。
		IntegrityConfiration integrityConfiration = new IntegrityConfiration();
		integrityConfiration.scanString();

		//ある金額を支払うことができるかを判定し、結果を出力します。
		CheckIsLie checkIsLie = new CheckIsLie();
		checkIsLie.checkAmount(integrityConfiration.getCount(), integrityConfiration.getAmount());
	}
}