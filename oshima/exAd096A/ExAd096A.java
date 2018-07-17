package oshima.exAd096A;

/**
 * ExAd096Aはメインクラスで、処理の流れと結果の表示を管理します。
 *
 * @author 大島
 */
public class ExAd096A {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("月と日との入力値が不正です。");
			return;
		}
		FindDayOfTakahashi find = new FindDayOfTakahashi();
		int result = find.findDayOfTakahashi(input);
		System.out.println(result);
	}
}
