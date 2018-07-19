package takai.exAd099C;

import takai.exAd099C.ExAd099C.Amount;

/**
 * 格納された変数から、何回操作が必要になるか求めるクラスです。
 *
 * @author 高井勇輝
 *
 */
public class DrawOut {
	/**
	 * 指定された金額を引き出すために何回操作が必要か計算します
	 *
	 * @param inputNumber 指定金額
	 * @return 操作回数
	 */
	public int actCount(double inputNumber) {
		int actCount = 0;
		double difference = 0;
		//10000以下で、指数が同じ場合に公倍数が存在しない6と9の累乗を格納している配列
		double[] sixSquared = { 36, 216, 1296, 7776, 46656 };
		double[] nineSquared = { 81, 729, 6561, 59049 };

		out: while (inputNumber != 0) {

			//残りの出金額が6の累乗の倍数である時、6の累乗を引きます。
			//6の累乗のj倍数が9の累乗のj+1倍数の値を超えないように、jは5以下であるようにします。
			for (int i = 0; i < sixSquared.length; i++) {
				for (int j = 1; j < Amount.Six.getAmount(); j++) {

					//12は-6を2回で処理することが望ましいため、12も条件として指定します。
					if (inputNumber == sixSquared[i] * j || inputNumber == 12) {
						inputNumber -= differenceSixSquared(inputNumber);
						actCount++;
						continue out;
					}
				}
			}

			//残りの出金額が9の累乗の倍数である時、9の累乗を引きます。
			//9の累乗のj倍数が6の累乗のj+1倍数の値を超えないように、jは5以下であるようにします。
			for (int i = 0; i < nineSquared.length; i++) {
				for (int j = 1; j < Amount.Six.getAmount(); j++) {

					if (inputNumber == nineSquared[i] * j) {
						inputNumber -= differenceNineSquared(inputNumber);
						actCount++;
						continue out;
					}
				}
			}

			difference = Math.max(differenceNineSquared(inputNumber), differenceSixSquared(inputNumber));
			inputNumber -= difference;
			actCount++;

			if (inputNumber > Amount.Six.getAmount()) {
				continue;
			}

			while (inputNumber != 0) {
				inputNumber--;
				actCount++;
			}
		}
		return actCount;
	}

	/**
	 * 残りの出金額に最も近い6の累乗数を返します。
	 *
	 * @param inputNumber 残り出金額
	 * @return 6の累乗数
	 */
	private double differenceSixSquared(double inputNumber) {
		double sixDifference = 0;
		for (int i = 1; inputNumber >= Math.pow(Amount.Six.getAmount(), i); i++) {
			sixDifference = Math.pow(Amount.Six.getAmount(), i);
		}
		return sixDifference;
	}

	/**
	 * 残りの出金額に最も近い9の乗数を返します。
	 *
	 * @param inputNumber 残り出金額
	 * @return 9の累乗数
	 */
	private double differenceNineSquared(double inputNumber) {
		double nineDifference = 0;
		for (int i = 1; inputNumber >= Math.pow(Amount.Nine.getAmount(), i); i++) {
			nineDifference = Math.pow(Amount.Nine.getAmount(), i);
		}
		return nineDifference;
	}
}