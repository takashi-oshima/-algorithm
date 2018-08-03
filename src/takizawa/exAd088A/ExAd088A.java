package takizawa.exAd088A;

/**
 * 他のクラスを呼び出し、実行します
 *
 * @author 瀧澤
 */
public class ExAd088A {

	public static void main(String[] args) {
		Check check = new Check();
		Payment pay = new Payment();

		// 入力値に誤りがあった場合はエラーを表示させ、処理を終了します
		if(!check.valid()) {
			System.out.println("入力値はスペースで区切った\n2つの整数で入力してください");
			return;
		}
		pay.payment(check);
	}
}