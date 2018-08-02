package oshima.exAd088A;

/**
 * ExAd088Aはメインクラスで、処理の流れと結果の表示を管理します。
 *
 * @author 大島
 */
public class ExAd088A {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。1~10000の整数を1つと0~1000の整数を1つ入力してください。");
			return;
		}
		CanPayOnly500And1Yen infiniteCoins = new CanPayOnly500And1Yen();
		boolean result = infiniteCoins.canPayment(input);

		if (result) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}