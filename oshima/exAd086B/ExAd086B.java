package oshima.exAd086B;

public class ExAd086B {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。");
			return;
		}
		JudgeSquareNumbers infiniteCoins = new JudgeSquareNumbers();
		boolean result = infiniteCoins.judgeSquareNumber(input);

		if (result) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}