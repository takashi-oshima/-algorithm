package exAd079B;

/**
 * リュカ数を求めます
 *
 * @author 鶴田竜也
 */

public class CalcLuca {

	/**
	 * 入力された値のリュカ数を求めます
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void calcLucasNumber(InputNumber inputNumber) {

		// 入力値N
		int numberN = inputNumber.getNumberN();

		// 86までのリュカ数を格納します
		long lucasArray[] = new long[87];

		for (int i = 0; i < 87; i++) {
			if (i == 0) {
				lucasArray[i] = 2;

			} else if (i == 1) {
				// リュカ数1の値を設定します
				lucasArray[i] = 1;
				if (i == numberN) {
					System.out.println(lucasArray[i]);
					return;
				}

			} else {
				// 2以上のリュカ数を格納します
				lucasArray[i] = lucasArray[i - 1] + lucasArray[i - 2];
				if (i == numberN) {
					System.out.println(lucasArray[i]);
					return;
				}
			}
		}
	}
}