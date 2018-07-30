package awano.exAd097A;

/**
 * AさんとCさんが直接または間接的に会話出来るか判定するクラスです。
 * 但し、AさんとCさんが間接的に会話できるとは、AさんとBさんが直接会話でき、
 * かつBさんとCさんが直接会話できることを指します。
 * 2人の人間は距離がd[m]以内のとき直接会話ができます。
 *
 * @author 粟野真司
 */
public class Converse {
	/**
	 * 2人の人間の距離を計算し、会話できるかどうか判定します。
	 * @param inputPoint InputPointクラス
	 */
	public void calcuDistance(InputPoint inputPoint) {
		//AさんからBさんの距離
		int fromAToB = inputPoint.getAPoint() - inputPoint.getBPoint();
		//BさんからCさんの距離
		int fromBToC = inputPoint.getBPoint() - inputPoint.getCPoint();
		//AさんからCさんの距離
		int fromAToC = inputPoint.getAPoint() - inputPoint.getCPoint();

		//距離がマイナスの場合、プラスになるように-1を掛けます。
		if (inputPoint.getAPoint() - inputPoint.getBPoint() < 0) {
			fromAToB = fromAToB * -1;
		}

		if (inputPoint.getBPoint() - inputPoint.getCPoint() < 0) {
			fromBToC = fromBToC * -1;
		}

		if (inputPoint.getAPoint() - inputPoint.getCPoint() < 0) {
			fromAToC = fromAToC * -1;
		}

		//AさんとCさんが直接的にまたは、間接的に会話できるかどうか判定します
		if (fromAToB <= inputPoint.getConverseDistance() && fromBToC <= inputPoint.getConverseDistance()) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}