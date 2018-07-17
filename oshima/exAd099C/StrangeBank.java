package oshima.exAd099C;

/**
 * ある銀行では、お金の引き出しを難しくするために、一回の操作で引き出せる金額が以下のいずれかとなっています。 ・1 円・6円・9円の乗数
 * この銀行からちょうど N 円を引き出すには少なくとも何回の操作が必要か求めてください。 ただし、一度引き出したお金を再び預け入れてはならないとします。
 *
 * @author 大島
 */
public class StrangeBank {

	/**
	 * SquaredNumberは自乗する数を示す列挙型です。
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
	 * N円を引き出すために必要な操作回数を計算します。
	 *
	 * @param input Inputクラス
	 * @return N円引き出すための操作回数
	 */
	public int calcSquaredCount(Input input) {
		int resultCount = 0;
		int integerN = input.getIntegerN();
		int withdrawalAmount = input.getIntegerN();
		// 100000以下かつ100000以下で指数が同一の時に公倍数が存在しない6と9との累乗が格納されている配列
		int[] sixSquared = { 36, 216, 1296, 7776, 46656 };
		int[] nineSquared = { 81, 729, 6561, 59049 };

		// 出金額が0以上かつresultCountの値が変化すると最初に戻るループ
		out: while (withdrawalAmount != 0) {

			if (withdrawalAmount < SquaredNumber.Six.getNumber()) {
				withdrawalAmount--;
				resultCount++;
				continue;
			}
			// 出金額が6の累乗 * j の場合、6の累乗を引きます。
			// 6の累乗 * j が 2 * 9の累乗 * j + 1 の値を超えないようにjには5を設定します。
			for (int i = 0; i < sixSquared.length; i++) {
				for (int j = 1; j < 6; j++) {
					// 配列に6が入っていませんが、12は-6を2回で処理するのが望ましいため条件に入れます。
					if (withdrawalAmount == sixSquared[i] * j || withdrawalAmount == 12) {
						withdrawalAmount = drawSixSquared(integerN, withdrawalAmount);
						integerN = withdrawalAmount;
						resultCount++;
						continue out;
					}
				}
			}
			// 出金額が9の累乗 * j の場合、9の累乗を引きます。
			// 9の累乗 * j が 2 * 6の累乗 * j + 1 の値を超えないようにjの限度値には5を設定します。
			for (int i = 0; i < nineSquared.length; i++) {
				for (int j = 1; j < 6; j++) {

					if (withdrawalAmount == nineSquared[i] * j) {
						withdrawalAmount = drawNineSquared(integerN, withdrawalAmount);
						integerN = withdrawalAmount;
						resultCount++;
						continue out;
					}
				}
			}
			withdrawalAmount = Math.min(drawNineSquared(integerN, withdrawalAmount),
					drawSixSquared(integerN, withdrawalAmount));
			integerN = withdrawalAmount;
			resultCount++;
		}
		return resultCount;
	}

	/**
	 * 残りの出金額から6の累乗を引きます。
	 *
	 * @param integerN 残りの出金額
	 * @param withdrawalAmount 残りの出金額から累乗値が引かれた数
	 * @return 残りの出金額から累乗値が引かれた数
	 */
	public int drawSixSquared(int integerN, int withdrawalAmount) {
		for (int i = 0; integerN >= Math.pow(SquaredNumber.Six.getNumber(), i); i++) {
			withdrawalAmount = (int) (integerN - Math.pow(SquaredNumber.Six.getNumber(), i));
		}
		integerN = withdrawalAmount;
		return withdrawalAmount;
	}

	/**
	 * 残りの出金額から9の累乗を引きます。
	 *
	 * @param integerN 残りの出金額
	 * @param withdrawalAmount 残りの出金額から累乗値が引かれた数
	 * @return 残りの出金額から累乗値が引かれた数
	 */
	public int drawNineSquared(int integerN, int withdrawalAmount) {
		for (int i = 0; integerN >= Math.pow(SquaredNumber.Nine.getNumber(), i); i++) {
			withdrawalAmount = (int) (integerN - Math.pow(SquaredNumber.Nine.getNumber(), i));
		}
		integerN = withdrawalAmount;
		return withdrawalAmount;
	}
}