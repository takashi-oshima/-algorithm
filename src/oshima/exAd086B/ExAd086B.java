package oshima.exAd086B;

/**
 * ExAd086Bはメインクラスで、処理の流れと結果の表示を管理します。
 *
 * @author 大島
 */
public class ExAd086B {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。1~100までの整数2つを入力してください。");
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