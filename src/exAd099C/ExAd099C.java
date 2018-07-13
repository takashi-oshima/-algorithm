package exAd099C;

/**
 * ExAd099Cはメインクラスで、処理の流れと結果の表示を管理します。
 *
 * @author 大島
 */
public class ExAd099C {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。");
			return;
		}
		StrangeBank strangeBank = new StrangeBank();
		int result = strangeBank.calcSquaredCount(input);
		System.out.println(result);
	}
}
