package oshima.exAd085C;

public class ExAd085C {

	public static void main(String[] args) {
		Input input = new Input();

		if (!input.canInput()) {
			System.out.println("入力値が不正です。");
			return;
		}
		Otoshidama otoshidama = new Otoshidama();
		int[] result = otoshidama.judgeLiar(input);

		for(int billCount: result) {
			System.out.print(billCount + " ");
		}
	}
}