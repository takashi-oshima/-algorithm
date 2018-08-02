package exAd097A;

/**
 * 実行用クラスになります。
 *
 * @author 鶴田竜也
 */
public class ExAd097A {

	public static void main(String[] args) {
		InputPoint inputPoint = new InputPoint();
		Transceiver transceiver = new Transceiver();

		if (inputPoint.isValidInput()) {
			System.out.println(transceiver.judgeCanSpeak(inputPoint));
		}
	}
}
