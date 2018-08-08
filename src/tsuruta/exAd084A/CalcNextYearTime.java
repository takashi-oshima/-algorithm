package exAd084A;

/**
 * 12月30日から次の年になるまでの時間を求めます。
 *
 * @author 鶴田竜也
 */
public class CalcNextYearTime {

	/**
	 * 12月30日から次の年になるまでの時間を求めます。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void calcNextTimeYear(InputNumber inputNumber) {

		// キーボード入力された入力値Mを格納します
		int fromTime = inputNumber.getNumberM();
		// 12月30日0時から次の年までの時間(48時間)を格納します
		int toTime = 48;

		// 12月30日から次の年になるまでの残り時間を表示します
		System.out.println("12月30日" + fromTime + "時から次の年までの残り時間は" + (toTime - fromTime) + "時間です");
	}
}
