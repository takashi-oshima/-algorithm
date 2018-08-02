package oshima.exAd080B;

/**
 * ExAd085Cはメインクラスで、処理の流れを管理します。
 *
 * @author 大島
 */
public class ExAd080B {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。1~100000000までの整数を1つ入力してください。");
			return;
		}
		FindHarshadNumber findHarshadNumber = new FindHarshadNumber();
		findHarshadNumber.findHarshad(input);
	}
}