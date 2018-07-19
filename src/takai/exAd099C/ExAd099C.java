package takai.exAd099C;

/**
 * 指定した金額を引き下ろすために、何回操作が必要かを求めるクラスです
 *
 * @author 高井勇輝
 *
 */
public class ExAd099C {

	public enum IntLength {
		Min(1), Max(100000);

		final int length;

		public int getLength() {
			return length;
		}

		private IntLength(int length) {
			this.length = length;
		}
	}

	public enum Amount {
		One(1), MinPow(2), Six(6), Nine(9);

		final double amount;

		public double getAmount() {
			return amount;
		}

		private Amount(double amount) {
			this.amount = amount;
		}
	}

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