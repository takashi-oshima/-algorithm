package exAd090B;

/**
 * 実行用のクラスになります。
 *
 * @author 鶴田竜也
 */
public class ExAd090B {

	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		Palindrome parindlome = new Palindrome();
		// 入力内容が正しいか判定します
		if (inputNumber.isValidInput()) {
			// 回文数を数えます
			parindlome.countPalindrome(inputNumber) ;
		}
	}
}