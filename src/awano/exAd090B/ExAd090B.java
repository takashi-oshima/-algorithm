package awano.exAd090B;

/**
 * 実行用のクラスです。
 *
 * @author 粟野真司
 */
public class ExAd090B {
	public static void main(String[] args) {
		InputNumber inputNumber = new InputNumber();
		PalindromeNumber palindromeNumber = new PalindromeNumber();
		//正しい入力の場合
		if (inputNumber.ceheckNumber()) {
			//回文数を求めます。
			palindromeNumber.countPalindromeNum(inputNumber);
		}
	}
}
