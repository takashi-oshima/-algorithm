package takizawa.ex097_A;

/**
 * 他のクラスを呼び出して実行します
 *
 * @author 瀧澤
 */
public class Ex097_A {
	public static void main(String[] args) {
		Check check = new Check();

		// 入力値エラーがあった時は処理を終了させます
		if(!check.valid()) {
			System.out.println("入力値は地点AからDをスペースで区切った\n4つの整数で入力してください");
			return;
		}

		RangeDecision range = new RangeDecision();
		range.canSpeak(check);
	}
}