package exAd099C;

/**
 * 実行用クラスになります。
 *
 * 銀行からちょうどN円引き出すには少なくとも何回の操作が必要か求め結果を表示します
 * 引き出せる金額は以下のいずれかになります
 * 1円
 * 6円,36円(6の2乗),216円(6の３乗)・・・
 * 9円, 81円(9の2乗), 729円(9の3乗)・・・
 *
 * @author 鶴田竜也
 */
public class ExAd099C {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		BankDepsits bankdeposits = new BankDepsits();

		//入力された文字列が正しく入力できているかチェックします
		if (inputNumber.isValidInput()) {
			bankdeposits.Withdrawals(inputNumber);
		}
	}
}
