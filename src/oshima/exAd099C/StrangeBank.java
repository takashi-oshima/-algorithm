package oshima.exAd099C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ある銀行では、お金の引き出しを難しくするために、一回の操作で引き出せる金額が以下のいずれかとなっています。 ・1 円・6円・9円の乗数
 * この銀行からちょうど N 円を引き出すには少なくとも何回の操作が必要か求めます。 ただし、一度引き出したお金を再び預け入れてはならないとします。
 *
 * @author 大島
 */
public class StrangeBank {

	/**
	 * SquaredNumberは数を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum SquaredNumber {
		Six(6), Nine(9);

		final int number;

		public int getNumber() {
			return number;
		}

		private SquaredNumber(int number) {
			this.number = number;
		}
	}

	/**
	 * 指定した金額を出金するために必要な操作回数を計算します。
	 *
	 * @param input Inputクラス
	 * @return 指定した額を出金するまでの操作回数
	 */
	public int calcSquaredCount(Input input) {
		// 出金残額
		int withdrawalAmount = input.getIntegerN();
		// 残額から9を引いた回数
		int minusNineCount = 0;
		// 残額から6を引いた回数
		int minusSixCount = 0;
		// 指定した額を出金するまでの操作回数
		int count = 0;
		// 指定した額を出金するまでの操作回数が全通り入るリスト
		List<Integer> counts = new ArrayList<>();

		// 指定した額を6の累乗と9の累乗とで出金するための全通りの操作を試行するまで処理を繰り返します。
		while(withdrawalAmount >= 0) {
			count = 0;

			minusSixCount = withdrawalAmount / SquaredNumber.Six.getNumber();

			count = withdrawalAmount % SquaredNumber.Six.getNumber();
			count = count + checkMinusCount(minusSixCount,SquaredNumber.Six.getNumber());
			count = count + checkMinusCount(minusNineCount,SquaredNumber.Nine.getNumber());

			counts.add(count);

			minusNineCount++;
			withdrawalAmount = withdrawalAmount - SquaredNumber.Nine.getNumber();
		}
		Collections.sort(counts);
		int minCount = counts.get(0);
		return minCount;
	}

	/**
	 * 残高からnumを引いた回数をnumの累乗を引いた回数に変換し、かつ余りを算出するメソッド
	 *
	 * @param powerOfNumCount 残額からnumを引いた回数
	 * @param num 6か9
	 * @return 残高からnumの累乗を引いた回数とその余りの和
	 */
	public int checkMinusCount(int powerOfNumCount, int num) {
		// 残額からnumの累乗を引き続けた時の余り
		int remainder = 0;

		while(powerOfNumCount >= num) {

			remainder = remainder + powerOfNumCount % num;
			powerOfNumCount = powerOfNumCount / num;
		}
		return powerOfNumCount + remainder;
	}
}
