package takizawa.exAd079C;

/**
 * 切符には4つの0以上9以下の整数A,B,C,Dが整理番号としてこの順に書かれています
 * A op1 B op2 C op3 D = 7となるように、op1,op2,op3に「＋」か「－」を入れて式を
 * 作ります。なお、答えが存在しない場合はErrorを表示します。
 *
 * @author 瀧澤
 */
public class ReferenceNumber {
	/** 一律の計算結果 */
	public final static int RESULT = 7;

	/**
	 * 結果が７になる整理番号を探して、計算式を表示します
	 *
	 * @param check Checkクラス
	 */
	public boolean referenceNum(Check check) {
		boolean isCalculable = false;
		int num1 = check.getInputA();
		int num2 = check.getInputB();
		int num3 = check.getInputC();
		int num4 = check.getInputD();

		// A～Dのすべてを足したときの答えが7になる場合
		if (num1 + num2 + num3 + num4 == RESULT) {
			isCalculable = true;
			System.out.println(num1 + "+" + num2 + "+" + num3 + "+" + num4 + "=" + RESULT);
			return isCalculable;
		}

		// A～Dのすべてを引いたときの答えが7になる場合
		if (num1 - num2 - num3 - num4 == RESULT) {
			isCalculable = true;
			System.out.println(num1 + "-" + num2 + "-" + num3 + "-" + num4 + "=" + RESULT);
			return isCalculable;
		}

		// A + B - C - Dをした時の答えが7になる場合
		if (num1 + num2 - num3 - num4 == RESULT) {
			isCalculable = true;
			System.out.println(num1 + "+" + num2 + "-" + num3 + "-" + num4 + "=" + RESULT);
			return isCalculable;
		}

		// A - B + C + Dをした時の答えが7になる場合
		if (num1 - num2 + num3 + num4 == RESULT) {
			isCalculable = true;
			System.out.println(num1 + "-" + num2 + "+" + num3 + "+" + num4 + "=" + RESULT);
			return isCalculable;
		}

		// A + B + C - Dをした時の答えが7になる場合
		if (num1 + num2 + num3 - num4 == RESULT) {
			isCalculable = true;
			System.out.println(num1 + "+" + num2 + "+" + num3 + "-" + num4 + "=" + RESULT);
			return isCalculable;
		}

		// A - B - C + Dをした時の答えが7になる場合
		if (num1 - num2 - num3 + num4 == RESULT) {
			isCalculable = true;
			System.out.println(num1 + "-" + num2 + "-" + num3 + "+" + num4 + "=" + RESULT);
			return isCalculable;
		}

		// A - B + C - Dをした時の答えが7になる場合
		if (num1 - num2 + num3 - num4 == RESULT) {
			isCalculable = true;
			System.out.println(num1 + "-" + num2 + "+" + num3 + "-" + num4 + "=" + RESULT);
			return isCalculable;
		}

		// A + B - C + Dをした時の答えが7になる場合
		if (num1 + num2 - num3 + num4 == RESULT) {
			isCalculable = true;
			System.out.println(num1 + "+" + num2 + "-" + num3 + "+" + num4 + "=" + RESULT);
			return isCalculable;
		}

		if (!isCalculable) {
			System.out.println("Error");
		}
		return isCalculable;
	}
}