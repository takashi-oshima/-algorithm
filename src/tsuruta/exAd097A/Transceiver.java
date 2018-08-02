package exAd097A;

/**
 * AさんとCさんが直接または間接的に会話出来るか判定します。
 * 但し、 AさんとCさんが間接的に会話出来るとは 、
 * AさんとBさんが直接会話でき、かつBさんとCさんが直接会話できることを指します。
 * 2人の距離がd[m]以内の時に会話できます。
 *
 * @author 鶴田竜也
 */
public class Transceiver {

	/**
	 * 会話ができるか判定します。
	 * 会話可能なら"Yes",会話不可なら"No"を返します。
	 *
	 * @param inputPoint InputPointクラス
	 * @return "Yes"か"No"の文字列
	 */
	public String judgeCanSpeak(InputPoint inputPoint) {

		// aとbの距離、bcの距離を格納します
		int abDistance = inputPoint.getaPoint() - inputPoint.getbPoint();
		int bcDistance = inputPoint.getbPoint() - inputPoint.getcPoint();
		int acDistance = inputPoint.getaPoint() - inputPoint.getcPoint();

		// 距離がマイナスの時、プラスに変えます
		if (abDistance < 0) {
			abDistance *= -1;
		}
		if (bcDistance < 0) {
			bcDistance *= -1;
		}

		if (acDistance < 0) {
			acDistance *= -1;
		}

		if (acDistance <= inputPoint.getDistance())
			return "Yes";

		if (abDistance <= inputPoint.getDistance()
				&& bcDistance <= inputPoint.getDistance()) {
			return "Yes";
			// 誰とも会話できない場合
		} else {
			return "No";
		}
	}
}
