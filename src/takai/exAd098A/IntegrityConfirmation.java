package takai.exAd098A;

import takai.exAdInput.Input;

/**
 * 入力値が指定されたものかどうか判定するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfirmation {
	/** 一つ目の入力値 */
	private int inputNumber1 = 0;
	/** 二つ目の入力値 */
	private int inputNumber2 = 0;
	/** 和 */
	private int sum = 0;
	/** 差 */
	private int difference = 0;
	/** 積 */
	private int product = 0;
	/** 会話できるかどうか */
	private boolean isRightness = false;

	public enum IntLength {
		Min(-1000), Max(1000);

		final int length;

		public int getLength() {
			return length;
		}

		private IntLength(int length) {
			this.length = length;
		}
	}

	/**
	 * @return sum
	 */
	public int getSum() {
		return sum;
	}

	/**
	 * @return difference
	 */
	public int getDifference() {
		return difference;
	}

	/**
	 * @return product
	 */
	public int getProduct() {
		return product;
	}

	/**
	 * @return isRightness
	 */
	public boolean isRightness() {
		return isRightness;
	}

	/**
	 * @param sum セットする sum
	 */
	public void setSum(int sum) {
		this.sum = sum;
	}

	/**
	 * @param difference セットする difference
	 */
	public void setDifference(int difference) {
		this.difference = difference;
	}

	/**
	 * @param product セットする product
	 */
	public void setProduct(int product) {
		this.product = product;
	}

	/**
	 * @param isRightness セットする isRightness
	 */
	public void setRightness(boolean isRightness) {
		this.isRightness = isRightness;
	}

	/**
	 * 入力値が適切かどうかを判定し、和、差、積を格納します
	 */
	public void scanString() {
		Input input = new Input();
		String[] inputTxt = input.scan();
		//数値が2つ入力されているかを確認します。
		if (inputTxt.length != 2) {
			System.out.println("入力された文字列が不正です。");
			System.out.println("-1000～1000の整数を2つ、半角空白区切りで入力してください。");
			return;
		}

		//入力された配列を数値に変換できるか試し、変換できた場合に値が適切なものか判定します。
		if (!isIntNumber(inputTxt[0]) || !isIntNumber(inputTxt[1])) {
			System.out.println("不適な文字列です。");
			System.out.println("-1000～1000の整数を2つ、半角空白区切りで入力してください。");
			return;
		}
		inputNumber1 = Integer.parseInt(inputTxt[0]);
		inputNumber2 = Integer.parseInt(inputTxt[1]);
		setSum(inputNumber1 + inputNumber2);
		setDifference(inputNumber1 - inputNumber2);
		setProduct(inputNumber1 * inputNumber2);
		setRightness(true);
	}

	/**
	 * 入力値が数値に変換できるかどうかを判定します。
	 * 変換できたときは、指定範囲内の数値であるかも判定します。
	 *
	 * @param inputTxt 入力文字列
	 * @return 判定結果
	 */
	private boolean isIntNumber(String inputTxt) {
		boolean isInt = false;
		int i = 0;

		try {
			i = Integer.parseInt(inputTxt);
		} catch (NumberFormatException e) {
			return isInt;
		}

		if (IntLength.Min.getLength() <= i && IntLength.Max.getLength() >= i) {
			isInt = true;
		}
		return isInt;
	}


}