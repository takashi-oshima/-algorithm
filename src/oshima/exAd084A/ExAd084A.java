package oshima.exAd084A;

/**
 * ExAd084Aはメインクラスで、処理の流れを管理します。
 *
 * @author 大島
 */
public class ExAd084A {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。1~23までの整数を1つ入力してください。");
			return;
		}
		CalcNewYearTime calcNewYearTime = new CalcNewYearTime();
		calcNewYearTime.calcNewYear(input);
	}
}