package awano.exAd084A;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd084A {

	public static void main(String[] args) {
		InputTime inputTime = new InputTime();
		CountDownNextYear countDownNextYear = new CountDownNextYear();
		//入力値が正しい場合
		if (inputTime.checkInputTime(inputTime)) {
			//次の年になるまで何時間か求めます。
			countDownNextYear.countTime(inputTime);
		}
	}
}