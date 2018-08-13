package takizawa.exAd084A;

/**
 * 他のクラスを呼び出し、実行します
 *
 * @author 瀧澤
 */
public class ExAd084A {
	public static void main(String[] args) {
		Check check = new Check();
		FindTime findTime = new FindTime();

		if(!check.valid()) {
			System.out.println("時間は1～23の間で入力してください");
			return;
		}
		findTime.findTime(check);
	}
}