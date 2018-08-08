package exAd079A;

/**
 * 実行用クラスになります。
 *
 * 入力された数字が「いい整数」かどうか判定し結果を表示します。
 * いい整数とは「1118」のような連続した数字が3つ以上並んだ4桁の整数です。
 *
 * @author 鶴田竜也
 */
public class ExAd079A {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		JudgeIntegralValue judgeIntegeralValue = new JudgeIntegralValue();

		// 入力チェックをします
		if (inputNumber.isValidInput()) {

			// 結果を表示します
			judgeIntegeralValue.matchSeisuu(inputNumber);
		}
	}
}
