package takai.exAd085C;

/**
 * 入力された枚数と金額が、日本円であり得るものかどうかを判定するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd085C {

	public static void main(String[] args) {
		//入力値を受け取り適切かどうか判定し、適切で張れば変数に格納します。
		IntegrityConfiration integrityConfiration = new IntegrityConfiration();
		integrityConfiration.scanString();

		if(!integrityConfiration.isCanScan()) {
			return;
		}
		//ある金額を支払うことができるかを判定し、結果を出力します。
		CheckIsLie checkIsLie = new CheckIsLie();
		checkIsLie.checkAmount(integrityConfiration.getCount(), integrityConfiration.getAmount());
	}
}