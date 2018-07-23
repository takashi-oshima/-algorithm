package oshima.exAd097A;

/**
 * ExAd097Aはメインクラスで、処理の流れと結果の表示を管理します。
 *
 * @author 大島
 */
public class ExAd097A {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。1~100までの整数を4つ入力してください。");
			return;
		}
		SpeakAtoC speakAtoC = new SpeakAtoC();
		boolean result = speakAtoC.canSpeak(input);

		if (result) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
