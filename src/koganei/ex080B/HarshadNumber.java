package koganei.ex080B;

/**
 * シャーハッド数であるか判定するクラス
 *
 * @author 小金井 広輝
 */
public class HarshadNumber {

	/**
	 * 入力された数字がシャーハッド数であるか判定し結果を返します
	 * ハーシャッド数とは整数Xの各桁の和をf(X)としたとき、Xがf(X)で割り切れる数
	 * を指します
	 *
	 * @param number 入力された数字
	 * @return 判定結果
	 */
	public String judgeHarshad(JudgeNumber number) {

		int intNumber = number.getNumber();
		String stringNumber = String.valueOf(intNumber);
		int sum = 0;

		//和f(X)を求めます
		for (int i = 0; i < stringNumber.length(); i++) {
			sum = sum + Character.getNumericValue(stringNumber.charAt(i));
		}

		if (intNumber % sum == 0) {
			//Xがf(X)で割り切れるとき
			return "Yes";
		} else {
			return "No";
		}
	}
}
