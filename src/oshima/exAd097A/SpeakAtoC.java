package oshima.exAd097A;

/**
 * 数直線上にいる A さんと B さんと C さんがトランシーバーで会話しようとしています。 A さんは a[m]地点、B さんは b[m]地点、C
 * さんはc[m]地点にいます。 二人の人間は、距離が d[m] 以内のとき直接会話が出来ます。 A さんと
 * Cさんが直接または間接的に会話出来るか判定して下さい。 但し、A さんと C さんが間接 的に会話出来るとは、A さんと B さんが直接会話でき、かつ
 * Bさんと C さんが直接会話できること を指します。
 *
 * @author 大島
 */
public class SpeakAtoC {

	/**
	 * AとCとの距離、Bの両名との距離をそれぞれ調べ、AとCとが会話できるかどうかを返します。
	 * 直接会話ができる距離がAとCの距離より近いか、AとB、BとCの距離より近ければAとCは会話できます。
	 *
	 * @param input Inputクラス
	 * @return AとCが会話できるかどうか
	 */
	public boolean canSpeak(Input input) {
		boolean canSpeak = false;
		// 距離を正の値に変換するための値
		final int CONVART_POSITIVE_NM = -1;
		// AとBの距離
		int distanceAToB = input.getPointB() - input.getPointA();
		// AとCの距離
		int distanceAToC = input.getPointC() - input.getPointA();
		// BとCの距離
		int dictanceBToC = input.getPointC() - input.getPointB();
		// 直接会話できる距離
		int speakArea = input.getSpeakArea();

		// 距離を正の値に変換します。
		if (distanceAToB < 0) {
			distanceAToB = distanceAToB * CONVART_POSITIVE_NM;
		}

		if (distanceAToC < 0) {
			distanceAToC = distanceAToC * CONVART_POSITIVE_NM;
		}

		if (dictanceBToC < 0) {
			dictanceBToC = dictanceBToC * CONVART_POSITIVE_NM;
		}

		if (speakArea >= distanceAToC) {
			canSpeak = true;
		}

		if (speakArea >= distanceAToB && speakArea >= dictanceBToC) {
			canSpeak = true;
		}
		return canSpeak;
	}
}
