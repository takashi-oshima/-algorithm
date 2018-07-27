package koganei.ex079B;

/**
 * 入力された数字のリュカ数を求めるクラス
 *
 * @author 小金井 広輝
 */
public class RyukaNumber {

	/**
	 * 入力された数字のリュカ数を求めその数字を返します
	 * リュカ数はi番目のリュカ数Liとすると
	 * L0 = 2
	 * L1 = 1
	 * Li = L(i-1) + L(i-2)  (i >= 2)
	 * と定義される数を指します
	 *
	 * @param number 入力された数字
	 * @return リュカ数
	 */
	public long getRyukaNumber(JudgeNumber number) {

		int intNumber = number.getNumber();
		//初期値を設定します
		//kou1,kou2,kou3は以下の部分を指します
		//kou3  kou1  kou2
		// 3   = 2   + 1
		// 4   = 1   + 3
		// 7   = 3   + 4
		// 11  = 4   + 7
		long kou1 = 2;
		long kou2 = 1;
		long kou3 = kou2;

		//リュカ数を計算していきます
		for (int i = 2; i <= intNumber; i++) {
			kou3 = kou1 + kou2;
			kou1 = kou2;
			kou2 = kou3;
		}
		return kou3;
	}
}
