package koganei.ex079A;

/**
 * 良い整数であるか判定するクラス
 *
 * @author 小金井 広輝
 */
public class GoodNumber {

	/** 連続する数字の数 */
	final int COUNTINUE_COUNT = 3;

	/**
	 * 良い整数であるか判定し結果を返します
	 * 良い整数とは「1118」のような連続した数字が3つ以上並んだ4桁の整数を
	 * 指します
	 *
	 * @param number 入力された数字
	 * @return 判定結果
	 */
	public String judgeGoodNumber(JudgeNumber number) {

		int intNumber = number.getNumber();
		String stringNumber = String.valueOf(intNumber);
		String[] splitNumber = stringNumber.split("");

		//連続する3つの数字を次の順番で探します
		//数字の1,2,3桁目がすべて同じか
		//数字の2,3,4桁目がすべて同じか
		for (int i = 0; i + COUNTINUE_COUNT <= splitNumber.length; i++) {
			if (splitNumber[i].equals(splitNumber[i + 1]) &&
					splitNumber[i + 1].equals(splitNumber[i + 2])) {
				//連続で3つ続いた場合
				return "Yes";
			}
		}
		return "No";
	}
}
