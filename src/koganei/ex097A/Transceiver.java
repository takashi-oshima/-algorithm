package koganei.ex097A;

/**
 * トランシーバークラス
 *
 * @author 小金井 広輝
 */
public class Transceiver {

	/**
	 * AさんとCさんが直接または間接的に会話できるかの判定を行います
	 *
	 * @param point それぞれの地点
	 * @return 判定結果
	 */
	public String judgeTalking(JudgeDistance inputJudge) {
		int[] point = inputJudge.getPoint();
		int pointA = point[0];
		int pointB = point[1];
		int pointC = point[2];
		int distance = point[3];

		if (Math.abs(pointA - pointC) <= distance) {
			return "Yes";
		}
		if (Math.abs(pointA - pointB) <= distance &&
				Math.abs(pointB - pointC) <= distance) {
			return "Yes";
		}
		return "No";
	}
}
