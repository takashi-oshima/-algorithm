package oshima.exAd071B;

/**
 * ExAd071Bはメインクラスで、処理の流れを管理します。
 *
 * @author 大島
 */
public class ExAd071B {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。連続した英小文字で長さ10の５乗以内の文字列を入力してください。");
			return;
		}
		FindAlphabet findAlphabet = new FindAlphabet();
		findAlphabet.findAndSortAlphabet(input);
	}
}