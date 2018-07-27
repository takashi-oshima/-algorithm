package oshima.exAd079C;

/**
 * ExAd079Cはメインクラスで、処理の流れを管理します。
 *
 * @author 大島
 */
public class ExAd079C {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。0~9までの整数を4つ連続して入力してください。");
			return;
		}
		MakeTrainTicket makeTrainTicket = new MakeTrainTicket();
		makeTrainTicket.calcTrainTicket(input);
	}
}