package takai.exAd099C;

import java.util.ArrayList;
import java.util.List;

/**
 * 格納された変数から、何回操作が必要になるか求めるクラスです。
 *
 * @author 高井勇輝
 *
 */
public class DrawOut {

	public enum Amount {
		One(1), MinPow(2), Six(6), Nine(9);

		final int amount;

		public int getAmount() {
			return amount;
		}

		private Amount(int amount) {
			this.amount = amount;
		}
	}

	/**
	 * 指定された金額を引き出すために何回操作が必要か計算します。
	 *
	 * @param inputNumber 指定金額
	 * @return 最少の操作回数
	 */
	public int actCount(int inputNumber) {
		int nineSquared = 0;
		List<Integer> counts = new ArrayList<>();

		while (inputNumber >= 0) {
			int count = 0;
			int sixSquared = inputNumber / Amount.Six.getAmount();

			count = inputNumber % Amount.Six.getAmount();
			count += exponentCheck(sixSquared, Amount.Six.getAmount());
			count += exponentCheck(nineSquared, Amount.Nine.getAmount());
			counts.add(count);
			nineSquared++;
			inputNumber -= Amount.Nine.getAmount();
		}
		int min = counts.get(0);

		for (int i : counts) {
			min = Math.min(min, i);
		}
		return min;
	}

	/**
	 * 残金から6、または9を引いた回数を累乗に変換し、それと余りの和を返します。
	 *
	 * @param number 残金から6、または9を引いた回数
	 * @param squaredNumber 6、または9
	 * @return 余りと渡されたものの個数の和
	 */
	private int exponentCheck(int number, int squaredNumber) {
		int remainder = 0;

		while(number >= squaredNumber) {
			remainder += number % squaredNumber;
			number /= squaredNumber;
		}
		return remainder + number;
	}
}