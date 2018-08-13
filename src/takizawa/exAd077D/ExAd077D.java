package takizawa.exAd077D;

/**
 * 他のクラスを呼び出し実行します
 *
 * @author 瀧澤
 */
public class ExAd077D {
	public static void main(String[] args) {
		Check check = new Check();
		Minimum mini = new Minimum();

		if(!check.valid()) {
			System.out.println("入力値は2から100000のいずれかの値を入力してください");
			return;
		}
		mini.minimum(check);
	}
}