package takizawa.ex096_A;

/**
 * 他のクラスを呼び出して実行します
 *
 * @author 瀧澤
 */
public class Ex096_A {
	public static void main(String[] args) {
		System.out.print("文字列:");
		Check check = new Check();

		if(!check.valid()) {
			return;
		}
		Count count = new Count();
		int result = count.takahashi(check);
		System.out.println(result);
	}
}