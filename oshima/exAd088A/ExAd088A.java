package oshima.exAd088A;

public class ExAd088A {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。");
			return;
		}
		InfiniteCoins infiniteCoins = new InfiniteCoins();
		boolean result = infiniteCoins.canPayment(input);

		if (result) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}