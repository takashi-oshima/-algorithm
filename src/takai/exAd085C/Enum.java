package takai.exAd085C;

public class Enum {
	public enum BillRate{
		Thousand(1000),
		FiveThousand(5000),
		TenThousand(10000);

		final int billRate;

		public int getBillRate() {
			return billRate;
		}

		private BillRate(int billRate) {
			this.billRate = billRate;
		}
	}

	public enum BillCount {
		Min(1), Max(2000);

		final int count;

		public int getCount() {
			return count;
		}

		private BillCount(int count) {
			this.count = count;
		}
	}

	public enum TotalAmount{
		Min(1000), Max(20000000);

		final int totalAmount;

		public int getTotalAmount() {
			return totalAmount;
		}

		private TotalAmount(int totalAmount) {
			this.totalAmount = totalAmount;
		}
	}
}