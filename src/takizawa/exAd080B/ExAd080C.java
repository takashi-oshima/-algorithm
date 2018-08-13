package takizawa.exAd080B;

/**
 * 他のクラスを呼び出し、実行します
 *
 * @author 瀧澤
 */
public class ExAd080C {
	public static void main(String[] args) {
		Check check = new Check();
		HarshadNumber harshad = new HarshadNumber();

		if (!check.valid()) {
			System.out.println("1～100000000の間で入力してください");
		}
		harshad.isHarshadNumber(check);
	}
}