package takai.exAd088A;

/**
 * 任意の1円硬貨と無限枚の500円硬貨で、ある金額を支払うことができるかを調べるクラスです。
 * 入力値の1つ目を支払う金額、2つ目を1円硬貨の枚数とします。
 *
 * @author 高井勇輝
 *
 */
public class ExAd088A {

	public static void main(String[] args) {
		//入力値を受け取り適切かどうか判定し、適切であれば変数に格納します。
		IntegrityConfiration integrityConfiration = new IntegrityConfiration();
		integrityConfiration.scanString();

		if(!integrityConfiration.isRightness()) {
			return;
		}

		//ある金額を支払うことができるかを判定し、結果を出力します。
		ConfirmExistsMoney confirmExistsMoney = new ConfirmExistsMoney();
		confirmExistsMoney.canPayment(integrityConfiration.getPayment(), integrityConfiration.getCoinCount());
	}
}