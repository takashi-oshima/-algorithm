package ex0114;

import java.util.Scanner;

/**
 * 入力された文字列を半角空白ごとに区切り、逆順に表示するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0114 {

	public static void main(String[] args) {
		/** 入力された文字列 */
		String inputTxt = "";

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		//入力値を代入します。
		inputTxt = scan.nextLine();

		//NULL・空文字チェック
		if (inputTxt == null || inputTxt.isEmpty()) {
			System.out.println("文字列が空白、もしくはnull値になっています");
			return;
		}

		//空白ごとに文字列を配列に要素として格納し、空白を削除します。
		String[] outputTxt = inputTxt.split("[\\s]+");

		//配列を逆順に出力します。
		for (int i = outputTxt.length - 1; 0 <= i; i--) {
			System.out.print(outputTxt[i] + " ");
		}
	}
}