package oshima.exAd079B;

/**
 * ExAd079Bはメインクラスで、処理の流れを管理します。
 *
 * @author 大島
 */
public class ExAd079B {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。1~86までの整数を1つ入力してください。");
			return;
		}
		FindLucasNumber findLucasNumber = new FindLucasNumber();
		findLucasNumber.calcLucasNumber(input);
	}
}