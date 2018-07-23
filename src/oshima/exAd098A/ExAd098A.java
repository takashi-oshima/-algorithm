package oshima.exAd098A;

/**
 * ExAd098Aはメインクラスで、処理の流れと結果の表示を管理します。
 *
 * @author 大島
 */
public class ExAd098A {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。-1000~1000までの2つの整数を入力してください。");
			return;
		}
		MaxValue maxValue = new MaxValue();
		int result = maxValue.calcMax(input);
		System.out.println(result);
	}
}
