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
		int i = 1;
		int squareNumber = 0;
		boolean isSquareNumber = false;

		while(answer > squareNumber) {
			squareNumber = (int) Math.sqrt(i);
			if(answer == squareNumber) {
				isSquareNumber = true;
			}
			i++;
		}

		if(isSquareNumber) {
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
}