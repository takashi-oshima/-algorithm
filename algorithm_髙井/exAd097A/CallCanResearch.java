package exAd097A;

/**
 * 会話が可能かどうかを判定し、結果を出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class CallCanResearch {
	/**
	 * aとcが会話可能であるかを判定します。
	 *
	 * @param inpuIntegrityConfirmationt IntegrityConfirmationクラス
	 * @return 判定結果の文字列
	 */
	public String canSpeak(IntegrityConfirmation inpuIntegrityConfirmationt) {
		/** AとBの距離 */
		int a2b = inpuIntegrityConfirmationt.getPointB() - inpuIntegrityConfirmationt.getPointA();
		/** BとCの距離 */
		int b2c = inpuIntegrityConfirmationt.getPointC() - inpuIntegrityConfirmationt.getPointB();
		/** AとCの距離 */
		int a2c = inpuIntegrityConfirmationt.getPointC() - inpuIntegrityConfirmationt.getPointA();

		//距離が負数になってしまったときに正数に変換します
		if (a2b < 0) {
			a2b = -a2b;
		}

		if (b2c < 0) {
			b2c = -b2c;
		}

		if (a2c < 0) {
			a2c = -a2c;
		}

		//通話可能距離よりもAとCの距離が近いとき。
		//または通話可能距離よりもAとBの距離が近く、かつ通話可能距離よりもBとCの距離が近ければフラグを立てます。
		int speakArea = inpuIntegrityConfirmationt.getSpeakArea();
		if (speakArea >= a2c || (speakArea >= a2b && speakArea >= b2c)) {
			return "Yes";
		}
		return "No";
	}
}