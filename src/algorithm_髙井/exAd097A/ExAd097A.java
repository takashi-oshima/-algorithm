package exAd097A;

/**
 * 入力値1をAの位置、入力値2をBの位置、入力値3をCの位置、入力値4を通話可能距離として、
 * aとcが間接的にでも会話可能であればYesを、会話不可能であればNoを出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class ExAd097A {

	public enum Number {
		Start(0), End(100);

		final int num;

		public int getNum() {
			return num;
		}

		private Number(int num) {
			this.num = num;
		}
	}

	public static void main(String[] args) {

		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanString();

		CallCanResearch callCanResearch = new CallCanResearch();

		//AとCが間接的にでも通話が可能かを判定し、結果に応じた文字列を出力します。
		System.out.println(callCanResearch.canSpeak(integrityConfirmation));
	}
}