package takizawa.exAd079A;

/**
 * 他のクラスを呼び出し、実行します
 *
 * @author 瀧澤
 */
public class ExAd079A {
	public static void main(String[] args) {
		Check check = new Check();
		GoodInteger goodInt = new GoodInteger();

		if (!check.valid()) {
			System.out.println("4桁の整数を入力してください");
			return;
		}
		goodInt.goodInteger(check);
	}
}