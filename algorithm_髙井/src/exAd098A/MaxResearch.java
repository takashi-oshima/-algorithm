package exAd098A;

/**
 * 入力値の和、差、積のうちどれが最も大きいかを判定するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class MaxResearch {
	public int maxNumber(int sum,int difference,int product) {
		final int ARRAY_LENGTH = 3;
		int[] numbers = new int[ARRAY_LENGTH];

		numbers[0] = sum;
		numbers[1] = difference;
		numbers[2] = product;

		int max = numbers[0];
		for(int i = 0; i < numbers.length ; i++) {
			max = Math.max(max, numbers[i]);
		}
		return max;
	}
}