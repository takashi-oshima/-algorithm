package exAd096A;

/**
 * ExAd096Aはメインクラスで、処理の流れを管理します。
 *
 * @author 大島
 */
public class ExAd096A {

	public static void main(String[] args) {

		Input input = new Input();

		if(!input.inputDate()) {
			System.out.println("月と日との入力値が不正です。");
			return;
		}
		FindDayOfTakahashi find = new FindDayOfTakahashi();
		find.findDayOfTakahashi(input);
	}
}
