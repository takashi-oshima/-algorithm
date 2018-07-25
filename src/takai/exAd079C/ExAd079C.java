package takai.exAd079C;

/**
 * A op1 B op2 C op3 D = 7となるように、
 * op1,op2,op3に「＋」か－を入れて式を作成するプログラムです
 *
 * @author 高井勇輝
 *
 */
public class ExAd079C {

	public static void main(String[] args) {
		//入力値を受け取り、適切なものであれば変数に格納します。
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanTxt();

		if (!integrityConfirmation.isCanScan()) {
			return;
		}
		//入力値からA op1 B op2 C op3 D = 7となるように式を作成します。
		FindSeven findSeven = new FindSeven();
		findSeven.calculationNumbers(integrityConfirmation.getInputNumber());
	}
}
