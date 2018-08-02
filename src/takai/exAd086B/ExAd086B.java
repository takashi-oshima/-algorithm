package takai.exAd086B;
/**
 * 2つの入力値を繋げた値が、平方数かどうか判定するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd086B {

	public static void main(String[] args) {
		//入力値を受け取り適切かどうか判定し、適切であれば変数に格納します。
		IntegrityConfiration integrityConfiration = new IntegrityConfiration();
		integrityConfiration.scanString();

		//入力値を繋げた値が平方数かを判定します。
		if(integrityConfiration.isCanScan()) {
			SquareNumberDecision squareNumberDecision = new SquareNumberDecision();
			squareNumberDecision.isSquareNumber(integrityConfiration.getAnswer());
		}
	}
}