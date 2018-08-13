package takizawa.exAd079B;

/**
 * 他のクラスを呼び出して実行します
 *
 * @author 瀧澤
 */
public class ExAd079B {
	public static void main(String[] args) {
		Check check = new Check();
		LucasNumber lucas = new LucasNumber();

		if(!check.valid()) {
			System.out.println("入力値は1～86の整数で入力してください");
			return;
		}
		lucas.lucasNumber(check);
	}
}