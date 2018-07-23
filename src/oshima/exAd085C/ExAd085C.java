package oshima.exAd085C;

/**
 * ExAd085Cはメインクラスで、処理の流れを管理します。
 *
 * @author 大島
 */
public class ExAd085C {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。1~2000までの整数1つと1000~2000000までの1000の倍数1つを入力してください。");
			return;
		}
		CheckOtoshidama checkOtoshidama = new CheckOtoshidama();
		checkOtoshidama.judgeLiar(input);
	}
}