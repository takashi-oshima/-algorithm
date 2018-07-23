package koganei;

import java.util.Scanner;

public class Input {

	/** 入力文字列*/
	private String[] inputString;

	/**
	 * 入力された文字を取得します
	 */
	public Input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		this.inputString = scanner.nextLine().split(" ");
	}

	/**
	 * 入力された文字を返します
	 *
	 * @return 入力された文字
	 */
	public String[] getInputString() {
		return inputString;
	}
}
