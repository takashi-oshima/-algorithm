package awano.exAd071B;

import java.util.Scanner;

/**
 * 入力値が1～100000の範囲内か調べ、
 * 入力値Sを受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputWord {
	/**入力値S*/
	private String inputS = "";

	/**
	 * 入力値Sが正しく入力されているかどうか調べます。
	 *
	 * @return 入力値が正しいかどうか
	 */
	public boolean checkInputWord() {
		boolean correctWord = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">S");
		inputS = scanner.nextLine();

		if (!(inputS.matches("^[a-z]+$"))) {
			System.out.println("入力値を半角英小文字で入力してください。");
			return correctWord;
		}

		//入力値が正しい範囲内かを判定します。
		if (inputS.length() < 1 || inputS.length() > 100000) {
			System.out.println("入力値の長さは1～100000の範囲内で入力してください。");
		}
		correctWord = true;
		return correctWord;
	}

	/**
	 * 入力値Sを返します。
	 * @return 入力値S
	 */
	public String getInputS() {
		return inputS;
	}

	/**
	 * 入力値Sを設定します。
	 * @param inputS 入力値S
	 */
	public void setInputS(String inputS) {
		this.inputS = inputS;
	}
}