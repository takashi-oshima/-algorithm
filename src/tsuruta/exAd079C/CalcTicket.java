package exAd079C;

/**
 * 入力値4つを用いて答えが7になるか求めます
 *
 * @author 鶴田竜也
 */
public class CalcTicket {

	/**
	 * 入力値4つを用いて足し算引き算を行い、結果が7になるか求めます
	 * 答えが7になるか否かを返します
	 *
	 * @param inputNumber InputNumberクラス
	 * @return 答えが7か否か
	 */
	public String findSeven(InputNumber inputNumber) {
		// 答えの7を格納します
		final int SEVEN = 7;

		// 入力値A,B,C,Dをそれぞれ格納します
		int numA = inputNumber.getNumberA();
		int numB = inputNumber.getNumberB();
		int numC = inputNumber.getNumberC();
		int numD = inputNumber.getNumberD();

		// 入力値の足し算引き算で答えの7になる式があればそのif文を実行します
		if (numA + numB + numC + numD == SEVEN) {
			return numA + "+" + numB + "+" + numC + "+" + numD + "=" + SEVEN;
		}

		if (numA + numB + numC - numD == SEVEN) {
			return numA + "+" + numB + "+" + numC + "-" + numD + "=" + SEVEN;
		}

		if (numA + numB - numC - numD == SEVEN) {
			return numA + "+" + numB + "-" + numC + "-" + numD + "=" + SEVEN;
		}

		if (numA - numB - numC - numD == SEVEN) {
			return numA + "-" + numB + "-" + numC + "-" + "=" + SEVEN;
		}

		if (numA - numB - numC + numD == SEVEN) {
			return numA + "-" + numB + "-" + numC + "+" + "=" + SEVEN;
		}

		if (numA - numB + numC + numD == SEVEN) {
			return numA + "-" + numB + "+" + numC + "+" + numD + "=" + SEVEN;
		}
		if (numA + numB - numC + numD == SEVEN) {
			return numA + "+" + numB + "-" + numC + "+" + numD + "=" + SEVEN;
		}

		if (numA - numB + numC - numD == SEVEN) {
			return numA + "-" + numB + "+" + numC + "-" + +numD + "=" + SEVEN;
		}

		// 入力値の足し算引き算の結果が7ではなかったとき
		return "Error:この入力値を使った計算では7になりません";
	}
}
