package awano.exAd079C;

/**
 * 切符には4つの0以上9以下の整数A、B、C、Dが整理番号として順に書かれています。
 * A(op1)、B(op2)、C(op3)、D(op4) = 7となるように
 * op1、op2、op3に「+」か「-」を入れて式を作ります。
 * 答えが存在しない場合は"Error"を出力します。
 *
 * @author 粟野真司
 */
public class Formula {
	/**式の答えの7*/
	public static final int SEVEN = 7;
	/**式を作る際の「+」*/
	public static final String PLUS = "+";
	/**式を作る際の「-」*/
	public static final String MINUS = "-";
	/**式を作る際の「=」*/
	public static final String EQUAL = "=";

	/**
	 * 入力された整理番号を元に、答えが7となる式をつくります。
	 *
	 * @param inputNumber InputNumberクラス
	 * @return 式番号
	 */
	public String createFormula(InputNumber inputNumber) {
		//入力値A
		int op1 = inputNumber.getReferenceNumber()[0];
		//入力値B
		int op2 = inputNumber.getReferenceNumber()[1];
		//入力値C
		int op3 = inputNumber.getReferenceNumber()[2];
		//入力値D
		int op4 = inputNumber.getReferenceNumber()[3];

		//A+B+C+Dの場合
		if (op1 + op2 + op3 + op4 == SEVEN) {
			return op1 + PLUS + op2 + PLUS + op3 + PLUS + op4 + EQUAL + SEVEN;
		}

		//A+B-C+Dの場合
		if (op1 + op2 - op3 + op4 == SEVEN) {
			return op1 + PLUS + op2 + MINUS + op3 + PLUS + op4 + EQUAL + SEVEN;
		}

		//A+B-C-Dの場合
		if (op1 + op2 - op3 - op4 == SEVEN) {
			return op1 + PLUS + op2 + MINUS + op3 + MINUS + op4 + EQUAL + SEVEN;
		}

		//A+B+C-Dの場合
		if (op1 + op2 + op3 - op4 == SEVEN) {
			return op1 + PLUS + op2 + PLUS + op3 + MINUS + op4 + EQUAL + SEVEN;
		}

		//A-B-C-Dの場合5
		if (op1 - op2 - op3 - op4 == SEVEN) {
			return op1 + MINUS + op2 + MINUS + op3 + MINUS + op4 + EQUAL + SEVEN;
		}

		//A-B+C-Dの場合
		if (op1 - op2 + op3 - op4 == SEVEN) {
			return op1 + MINUS + op2 + PLUS + op3 + MINUS + op4 + EQUAL + SEVEN;
		}

		//A-B+C+Dの場合
		if (op1 - op2 + op3 + op4 == SEVEN) {
			return op1 + MINUS + op2 + PLUS + op3 + PLUS + op4 + EQUAL + SEVEN;
		}

		//A-B-C+Dの場合
		if (op1 - op2 - op3 + op4 == SEVEN) {
			return op1 + MINUS + op2 + MINUS + op3 + PLUS + op4 + EQUAL + SEVEN;
		}

		//答えが存在しない場合
		return "Eroor";
	}
}