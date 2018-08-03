package takizawa.ExAd099C;

/**
 * 他のクラスを呼び出して、実行します
 *
 * @author 瀧澤
 */
public class ExAd099C {
	public static void main(String[] args) {
		Check check = new Check();
		WithDrawal withDrawal = new WithDrawal();

		// 入力値に誤りがあった場合に処理を終了させます
		if (!check.valid()) {
			System.out.println("入力値は1以上100000以下の整数を入力してください");
			return;
		}

		int result = withDrawal.moneyDrawal(check);
		System.out.println(result);
	}
}