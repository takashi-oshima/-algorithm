package takai.exAd086B;
/**
 * 入力値が平方数かどうかを判定します。
 *
 * @author 高井勇輝
 *
 */
public class SquareNumberDecision {
	/**
	 * 入力値が平方数か判定します。
	 *
	 * @param answer 入力値を繋げた値
	 */
	public void isSquareNumber(int answer) {
		int squareNumber = 0;
		boolean isSquareNumber = false;

		squareNumber = (int) Math.sqrt(answer);
		if(squareNumber * squareNumber == answer) {
			isSquareNumber = true;
		}

		if(isSquareNumber) {
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
}