package takai.exAd084A;

/**
 * 入力値を時間として持つ12月30日から、1月1日までの時間差を求めるシステムです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd084A {

	public static void main(String[] args) {
		//入力値を受け取り、適切な入力値かを判定します。
		//適切だった場合、入力値を時間として持つカレンダーを作成します。
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanTxt();

		if (!integrityConfirmation.isCanScan()) {
			return;
		}

		//入力値を時間として持つ12月30日から、1月1日までの時間差を求めて出力します。
		CheckRemainingTime checkRemainingTime = new CheckRemainingTime();
		checkRemainingTime.setCalendar();
		long remainingTime = checkRemainingTime.checkRemainingTime(integrityConfirmation.getDate());
		System.out.println(remainingTime);
	}
}