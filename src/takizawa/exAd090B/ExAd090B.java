package takizawa.exAd090B;
/**
 * 他のクラスを呼び出し、実行します
 *
 * @author 瀧澤
 */
public class ExAd090B {

	public static void main(String[] args) {
		Check check = new Check();

		// 入力値が正しくなかったら、エラーを表示して終了します
		if(!check.valid()) {
			System.out.println("入力値はスペースで区切った\n5桁の2つの整数で入力してください");
			return;
		}
		PalindromeNumber palindrome = new PalindromeNumber();
		int result = palindrome.palindromeCount(check);
		System.out.println(result);
	}
}