package takai.exAd099C;

/**
 * 指定した金額を引き下ろすために、何回操作が必要かを求めるクラスです
 *
 * @author 高井勇輝
 *
 */
public class ExAd099C {

	public static void main(String[] args) {
		//入力値を受け取り、適切な入力値かを判定し、
		//適切であれば格納します。
		IntegrityConfirmation integrityConfirmation = new IntegrityConfirmation();
		integrityConfirmation.scanString();

		//格納した入力値を用いて、実際に何回操作が必要になるかを求めます。
		DrawOut drawOut = new DrawOut();
		System.out.println(
				drawOut.actCount(integrityConfirmation.getInputNumber()));
	}
}