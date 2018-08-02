package koganei.ex086B;

/**
 * 平方数であるか判定するクラス
 *
 * @author 小金井 広輝
 */
public class SquareRoot {

	/**
	 * 入力された2つの数字を繋げて読んだものが平方数であるかどうかの判定をし、
	 * 判定結果を返します
	 *
	 * @param number 入力された数字
	 * @return 判定結果
	 */
	public String JudgeSquareRoot(JudgeNumber number) {

		String stringNumA = String.valueOf(number.getNumA());
		String stringNumB = String.valueOf(number.getNumB());
		double intNumAB = Double.parseDouble(stringNumA + stringNumB);
		double squareNumber = Math.sqrt(intNumAB);

		if (squareNumber - Math.floor(squareNumber) != 0) {
			//平方数が整数である場合（小数がない場合）
			return "No";
		} else {
			return "Yes";
		}
	}
}
