package takai.exAd080B;

/**
 * 入力値がハーシャッド数かどうかを判定します。
 *
 * @author 高井勇輝
 *
 */
public class HarshadNumberDecision {

	public boolean searchHarshad(String inputNumber) {
		int numbersSum = 0;
		boolean isHarshadNumber = false;
		String[] splitNumber = inputNumber.split("");

		for (String number : splitNumber) {
			numbersSum += Integer.parseInt(number);
		}

		if (Integer.parseInt(inputNumber) % numbersSum == 0) {
			isHarshadNumber = true;
		}

		return isHarshadNumber;
	}
}