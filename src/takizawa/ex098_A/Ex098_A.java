package takizawa.ex098_A;

/**
 * 他のクラスを呼び出し、実行します
 *
 * @author 瀧澤
 */
public class Ex098_A {

	public static void main(String[] args) {
		Check check = new Check();

		// 入力値が正しくないときはエラーを表示させます
		if (!check.valid()) {
			System.out.println("入力値はスペースで区切った\n2つの整数で入力してください");
			return;
		}
		FormulaMaximum maximum = new FormulaMaximum();
		int result = maximum.maximum(check);
		System.out.println(result);
	}

}