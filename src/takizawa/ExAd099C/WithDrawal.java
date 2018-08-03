package takizawa.ExAd099C;

import java.util.Arrays;

/**
 * 引き出せる金額が決まっている銀行でN円を引き出すためには
 * 何回の操作が必要かを求めます
 *
 * @author 瀧澤
 */
public class WithDrawal {
	/** 仮指数 */
	public static final int TEMP_INDEX = 10;
	/** 引出上限 */
	public static final int DRAWER_MAX = 100000;

	/**
	 * 操作回数を求めます
	 *
	 * @param check Checkクラス
	 * @return count 操作回数
	 */
	public int moneyDrawal(Check check) {
		int money = check.getNumber();
		int count = 0;
		int sixPowerCount = 0;
		int ninePowerCount = 0;

		for (int i = 1; i < TEMP_INDEX; i++) {

			// 100000以下の6の累乗をカウントします
			if (Math.pow(6, i) <= DRAWER_MAX) {
				sixPowerCount++;
			}

			// 100000以下の9の累乗をカウントします
			if (Math.pow(9, i) <= DRAWER_MAX) {
				ninePowerCount++;
			}
		}

		// 100000の6の累乗と9の累乗文
		int[] powerArray = new int[sixPowerCount + ninePowerCount + 1];
		powerArray[0] = 1; // 0番目にはあらかじめ1を格納しておく

		for (int i = 1; i <= sixPowerCount; i++) {

			// 100000以下の6の累乗がなくなるまで
			while (sixPowerCount != 0) {

				// 配列の1番目から6の累乗を入れてあげます
				if (Math.pow(6, i) <= DRAWER_MAX) {
					powerArray[i] = (int) Math.pow(6, i);
					sixPowerCount--;
					i++;
				}
			}
		}

		for (int i = 7; i < powerArray.length; i++) {
			for (int j = 1; j < powerArray.length; j++) {

				// 100000以下の6の累乗を入れた次の要素番号から9の累乗を入れます
				if (Math.pow(9, j) <= DRAWER_MAX) {
					powerArray[i] = (int) Math.pow(9, j);
					ninePowerCount--;
					i++;
				}
			}
		}
		// 昇順に直す
		Arrays.sort(powerArray);
		for (int i = powerArray.length - 1; i >= 0; i--) {

			// 引出金額が配列の要素より大きく、引出金額が0円じゃないとき
			if (money >= powerArray[i] && money != 0) {
				// 引出金額/i番目の要素を操作回数として足していきます
				count += money / powerArray[i];
				// 引出金額を更新します。
				money = money % powerArray[i];
			}
		}
		return count;
	}
}