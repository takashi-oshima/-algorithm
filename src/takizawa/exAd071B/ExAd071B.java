package takizawa.exAd071B;

/**
 * 他のクラスを呼び出して実行します
 *
 * @author 瀧澤
 */
public class ExAd071B {
	public static void main(String[] args) {
		Check check = new Check();
		FindLowerCase findLower = new FindLowerCase();

		if(!check.valid()) {
			System.out.println("文字列は小文字で入力してください");
			return;
		}
		String result = findLower.findLowerCase(check);
		// 結果の表示
		System.out.println(result);
	}
}