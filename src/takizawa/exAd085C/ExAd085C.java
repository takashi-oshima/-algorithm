package takizawa.exAd085C;

/**
 * 他のクラスを呼び出して、実行します
 *
 * @author 瀧澤
 */
public class ExAd085C {
	public static void main(String[] args) {
		Check check = new Check();
		LieDiscovery lieDisc = new LieDiscovery();

		if(!check.valid()) {
			System.out.println("入力値はスペースで区切った、2つの整数で\n入力してください。\nまた、入力値は"
					+ "1つ目の数字は1～2000、2つ目の\n数字は1000～20000000の間で入力してください");
			return;
		}
		lieDisc.lie(check);
	}
}