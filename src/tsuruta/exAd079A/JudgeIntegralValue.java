package exAd079A;

/**
 * 入力値Nがいい整数(同じ数字が3つ以上含まれている)か調べるクラスになります。
 *
 * @author 鶴田竜也
 */
public class JudgeIntegralValue {

	/**
	 * 入力値Nがいい整数かどうか調べます
	 *
	 * @param inputNumber InputNumberクラス
	 * @return いい整数かどうかの真偽
	 */
	public void matchSeisuu(InputNumber inputNumber) {
		// 入力値Nを文字列に変換します
		String numN = String.valueOf(inputNumber.getNumberN());

		// 入力値がいい整数か調べます
		for (int i = 1; i <= 9; i++) {

			// 入力値に３つ同じ数字が含まれているとき(いい整数の時)
			if (numN.matches(".*" + i + i + i + ".*")) {
				System.out.println("Yes");
				return;
			}
		}

		// いい整数じゃなかったとき
		System.out.println("No");
	}
}
