package takizawa.ex097_A;

/**
 * AさんとCさんが直接または間接的に会話できるかを判定します。
 * 但し、AさんとCさんが間接的に会話できる条件としてAさんとBさんが直接会話でき
 * かつ、BさんとCさんが直接会話できることを指します
 *
 * @author 瀧澤
 */
public class RangeDecision {
	public void canSpeak(Check check) {
		boolean isCanSpeak = false;

		// 地点AからBまでの距離を絶対値で求めます
		int pointAtoB = Math.abs(check.getPointA() - check.getPointB());
		// 地点AからCまでの距離を絶対値で求めます
		int pointAtoC = Math.abs(check.getPointA() - check.getPointC());
		// 地点BからCまでの距離を絶対値で求めます
		int pointBtoC = Math.abs(check.getPointB() - check.getPointC());
		// 距離Dを設定します
		int distance = check.getDistanceD();

		// AからB、BからCまでの距離が共に距離D以内なら話せる距離にいるのでYESを表示します
		if (pointAtoB <= distance && pointBtoC <= distance) {
			isCanSpeak = true;
			System.out.println("YES");
			return;
		}

		//AからCまでの距離が距離D以内なら話せる距離にいるのでYESを表示します
		if (pointAtoC <= distance) {
			isCanSpeak = true;
			System.out.println("YES");
			return;
		}

		// 話せる距離にいないとき、NOと表示させます
		if (!isCanSpeak) {
			System.out.println("NO");
		}
		return;
	}
}