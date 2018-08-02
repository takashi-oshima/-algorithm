package awano.exAd084A;

/**
 * 12月30日の入力値M時から次の年になるまでは何時間か求めます。
 *
 * @author 粟野真司
 *
 */
public class CountDownNextYear {
	/**
	 * 次の年になるまでは何時間か求めます。
	 *
	 * @param inputTime InputTimeクラス
	 */
	public void countTime(InputTime inputTime) {
		//次の年になる時間
		final int NEXT_YEAR = 48;
		//入力値M時から次の年になるまでは何時間か求めます。
		int remainingTime = NEXT_YEAR - inputTime.getTime();
		System.out.println(remainingTime);
	}
}
