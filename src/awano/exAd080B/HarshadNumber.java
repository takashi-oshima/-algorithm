package awano.exAd080B;

/**
 * 入力値Nがハーシャッド数かどうか判定します。
 * 整数Xを10進報法で表したときの各桁の数字の和をf(X)としたとき、
 * Xがf(X)で割り切れる場合、Xはハーシャッド数です。
 *
 * @author 粟野真司
 */
public class HarshadNumber {
	/**
	 * 入力値Nがハーシャッド数かどうか判定します。
	 * @param inputNumber InputNubmerクラス
	 */
	public void isHarshadNumber(InputNumber inputNumber) {
		String num = String.valueOf(inputNumber.getNumber());
		//入力値Nの各位の和
		int sum = 0;
		//入力値をchar型の配列に変換
		char[] numArray = num.toCharArray();

		//入力値の各位の和を求めます。
		for (int i = 0; i < numArray.length; i++) {
			sum += Character.getNumericValue(numArray[i]);
		}

		//ハーシャッド数かどうか判定します。
		if (inputNumber.getNumber() % sum == 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}