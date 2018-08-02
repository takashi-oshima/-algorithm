package oshima.exAd090B;

/**
 * ExAd090Bはメインクラスで、処理の流れと結果の表示を管理します。
 *
 * @author 大島
 */
public class ExAd090B {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。10000~99999まで数値の整数を2つ入力してください。");
			return;
		}
		PalindromicNumbers palindromicNumbers = new PalindromicNumbers();
		int result = palindromicNumbers.findPalindrome(input);
		System.out.println(result);
	}
}
