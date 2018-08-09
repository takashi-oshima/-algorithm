package exAd084A;

/**
 * 実行用クラスになります。
 *
 * 12月30日から次の年になるまで何時間か求め、次の年までの時間を表示します。
 *
 * @author 鶴田竜也
 */
public class ExAd084A {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		CalcNextYearTime calcNextYeraTime = new CalcNextYearTime();

		// 入力チェックを行います
		if (inputNumber.isValidInput()) {
			// 次の年までの残り時間を表示します
			calcNextYeraTime.calcNextTimeYear(inputNumber);
		}
	}
}
