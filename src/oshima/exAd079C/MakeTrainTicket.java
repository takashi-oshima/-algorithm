package oshima.exAd079C;

/**
 * A op1 B op2 C op3 D = 7 となるように op1,op2,op3 に「＋」か「－」を入れて式を作ります。
 * なお、答えが存在しない入力は受け付けません。 また、答えが複数存在する場合は何れか1つを出力するものとします。
 *
 * @author 大島
 */
public class MakeTrainTicket {
	/** 式の演算子に対応して「+」か「-」が格納される変数 */
	String op1 = "";
	/** 式の演算子に対応して「+」か「-」が格納される変数 */
	String op2 = "";
	/** 式の演算子に対応して「+」か「-」が格納される変数 */
	String op3 = "";

	/**
	 * A op1 B op2 C op3 D = 7 となるように op1,op2,op3 に「＋」か「－」を入れて式を作ります。
	 *
	 * @param input Inputクラス
	 */
	public void calcTrainTicket(Input input) {
		boolean makeTrainTicket = false;
		// 求められている式の結果値です。
		final int ANSER = 7;
		// opが「+」か「-」に変化する時の計算式の全パターン数です。
		final int ALL_PATTERN = 8;
		int integerA = input.getIntegerA();
		int integerB = input.getIntegerB();
		int integerC = input.getIntegerC();
		int integerD = input.getIntegerD();
		// 式の結果
		int result = 0;
		// -1を掛けることによって、演算子を「+」から「－」に変換します。
		int[][] changeFormula = new int[][] { { 1, 1, 1 }, { 1, 1, -1 }, { 1, -1, -1 }, { -1, -1, -1 }, { -1, -1, 1 },
				{ -1, 1, 1 }, { 1, -1, 1 }, { -1, 1, -1 } };

		for (int i = 0; i < ALL_PATTERN; i++) {
			assignPlusMinus(i);
			result = integerA + integerB * changeFormula[i][0] + integerC * changeFormula[i][1]
					+ integerD * changeFormula[i][2];

			if (result == ANSER) {
				System.out.println(integerA + op1 + integerB + op2 + integerC + op3 + integerD + "=" + ANSER);
				makeTrainTicket = true;
				break;
			}
		}

		if (!makeTrainTicket) {
			System.out.println("Error");
		}
	}

	/**
	 * String op1 op2 op3にchangeFormulaの要素何番目を見ているかによって「+」か「-」を代入します。
	 *
	 * @param i int[][] changeFormulaの要素何番目を見ているかを示しています。
	 */
	public void assignPlusMinus(int i) {
		switch (i) {
		case 0:
			op1 = "+";
			op2 = "+";
			op3 = "+";
			break;
		case 1:
			op1 = "+";
			op2 = "+";
			op3 = "-";
			break;
		case 2:
			op1 = "+";
			op2 = "-";
			op3 = "-";
			break;
		case 3:
			op1 = "-";
			op2 = "-";
			op3 = "-";
			break;
		case 4:
			op1 = "-";
			op2 = "-";
			op3 = "+";
			break;
		case 5:
			op1 = "-";
			op2 = "+";
			op3 = "+";
			break;
		case 6:
			op1 = "+";
			op2 = "-";
			op3 = "+";
			break;
		case 7:
			op1 = "-";
			op2 = "+";
			op3 = "-";
			break;
		default:
			break;
		}
	}
}