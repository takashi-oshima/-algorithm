package exAd079C;

/**
 * 実行用のクラスになります。
 *
 * 切符には 4つの 0以上 9以下の整数A,B,C,Dがあります。
 * A op1 B op2 C op3 D = 7となるように、
 * op1,op2,op3に「＋」か「－」を入れて7になる式を作成します。
 * A,B,C,Dそれぞれの入力値は0～9までの半角数字になります。
 *
 * @author 鶴田竜也
 */
public class ExAd079C {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		CalcTicket calcTicket = new CalcTicket();

		// 入力値のチェックを行います
		if (inputNumber.isValidInput()) {
			// 結果を出力します
			System.out.println(calcTicket.findSeven(inputNumber));
		}
	}
}
