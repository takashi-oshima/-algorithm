package koganei;

import java.util.Scanner;

/**
 * コンソールに入力させるクラス
 *
 * @author 小金井 広輝
 */
public class Input {

	/** 入力文字列*/
	private String[] inputString;

	/**
	 * 入力させた文字を取得し、空白区切りでsplitにより配列化します
	 */
	public Input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		this.inputString = scanner.nextLine().split(" ");
	}

	/**
	 * 入力させた文字を配列で返します
	 *
	 * @return 入力された文字
	 */
	public String[] getInputString() {
		return inputString;
	}
}
