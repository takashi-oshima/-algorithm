package takai.exAd071B;

import takai.exAdInput.Input;
/**
 * 入力値から、探索する文字列を生成し、
 * 生成された者が適切な文字列化を判定します。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfirmation {
	//入力されたものから英小文字以外を削除たものを入力値として格納します。
	private String inputString = "";

	public enum TxtLength {
		Min(1),Max(100000);

		final int length;

		public int getLength() {
			return length;
		}

		private TxtLength(int length) {
			this.length = length;
		}
	}

	/**
	 * @return inputString
	 */
	public String getInputString() {
		return inputString;
	}

	/**
	 * @param inputString セットする inputString
	 */
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	/**
	 * 入力値が適切かを判定し、適切であれば変数に格納します。
	 */
	public void scanTxt() {
		Input input = new Input();
		String[] inputTxt = input.scan();

		for(int i = 0; i < inputTxt.length; i++) {
			inputString += inputTxt[i].replaceAll("[^a-z]", "");
		}

		//入力された配列を数値に変換できるか試し、変換できた場合に値が適切なものか判定します。
		if (!isTxt(inputString)) {
			System.out.println("不適な文字列です。");
			System.out.println("2～100000の整数を入力してください。");
			return;
		}
		return;
	}

	/**
	 * 生成された文字列が適切なものかを判定します。
	 *
	 * @param inputTxt 生成された入力文字列
	 * @return 判定結果
	 */
	private boolean isTxt(String inputTxt) {

		if(inputTxt.length() < TxtLength.Min.getLength() || inputTxt.length() > TxtLength.Max.getLength()) {
			return false;
		}
		return true;
	}
}
