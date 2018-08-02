package awano.exAd079A;

/**
 * 1118のような3つ以上の同じ数字が連続して並んだ4桁の整数
 * を良い整数とします。
 * 入力値N(4桁の整数)が良い整数かどうか判定するクラスです。
 *
 * @author 粟野真司
 */
public class GoodIntegr {
	/**
	 * 入力値N(4桁の整数)が良い整数かどうか判定します。
	 *
	 * @param inputInteger InputIntegerクラス
	 */
	public void isGoodIntegr(InputInteger inputInteger) {
		char[] numberArray = inputInteger.getInputN().toCharArray();

		//3つ以上同じ数字が連続して並んでいるか調べます。
		if ((numberArray[0] == numberArray[1] && numberArray[1] == numberArray[2])
				|| (numberArray[1] == numberArray[2] && numberArray[2] == numberArray[3])) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}