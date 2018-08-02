package takai.exAd085C;

import takai.exAd085C.Enum.BillCount;
import takai.exAd085C.Enum.BillRate;
import takai.exAd085C.Enum.TotalAmount;
import takai.exAdInput.Input;
/**
 * 入力値が適切かの判定を行うクラスです。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfiration {
	/** お札の全体数 */
	int count;
	/** 全体の金額 */
	int amount;
	/** 入力値が適切かどうか */
	private boolean canScan = false;

	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @return canScan
	 */
	public boolean isCanScan() {
		return canScan;
	}

	/**
	 * @param count セットする count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @param amount セットする amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @param canScan セットする canScan
	 */
	public void setCanScan(boolean canScan) {
		this.canScan = canScan;
	}

	/**
	 * 入力値が適切か判定します。
	 */
	public void scanString() {
		final int TEXT_LENGTH = 2;
		Input input = new Input();
		String[] inputTxt = input.scan();

		if (inputTxt.length != TEXT_LENGTH) {
			System.out.println("入力文字列が不正です。");
			return;
		}

		if (!isIntCount(inputTxt[0]) || !isIntAmount(inputTxt[1])) {
			System.out.println("入力値が不正です。");
			return;
		}
		setCount(Integer.parseInt(inputTxt[0]));
		setAmount(Integer.parseInt(inputTxt[1]));
		setCanScan(true);
	}

	/**
	 * 入力された枚数が正しいものか判定します。
	 *
	 * @param count 枚数
	 * @return 判定
	 */
	private boolean isIntCount(String count) {
		boolean isInt = false;
		int i;

		try {
			i = Integer.parseInt(count);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (BillCount.Min.getCount() <= i && i <= BillCount.Max.getCount()) {
			isInt = true;
		}
		return isInt;
	}

	/**
	 * 入力された金額が正しいものか判定します
	 *
	 * @param amount 金額
	 * @return 判定
	 */
	private boolean isIntAmount(String amount) {
		boolean isInt = false;
		int i;

		try {
			i = Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (TotalAmount.Min.getTotalAmount() <= i && i <= TotalAmount.Max.getTotalAmount()) {
			isInt = true;
		}

		if(0 != i % BillRate.Thousand.getBillRate()) {
			isInt = false;
		}
		return isInt;
	}
}