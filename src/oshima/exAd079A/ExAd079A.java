package oshima.exAd079A;

/**
 * ExAd079Aはメインクラスで、処理の流れを管理します。
 *
 * @author 大島
 */
public class ExAd079A {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。1000~9999までの整数を1つ入力してください。");
			return;
		}
		FindGoodInteger findGoodInteger = new FindGoodInteger();
		findGoodInteger.isGoodInteger(input);
	}
}