package ex0110;

import java.util.Scanner;

/**
 * キーボードから入力された2つの文字列を、辞書順にソートするクラスです
 *
 * @author 高井勇輝
 *
 */
public class Ex0110 {

	public static void main(String[] args) {
		/** 一つ目の文字列 */
		String inputTxt1 = "";
		/** 二つ目の文字列 */
		String inputTxt2 = "";

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		//入力値をそれぞれに代入します。
		System.out.println("文字列を2つ入力してください");
		System.out.println("文字列1：");
		inputTxt1 = scan.nextLine();
		System.out.println("文字列2：");
		inputTxt2 = scan.nextLine();

		//NULL・空文字チェック
		if (inputTxt1 == null || inputTxt1.isEmpty()) {
			System.out.println("1つ目の文字列が空白、もしくはnull値になっています");
			return;
		}
		if (inputTxt2 == null || inputTxt2.isEmpty()) {
			System.out.println("2つ目の文字列が空白、もしくはnull値になっています");
			return;
		}

		//一つ目の文字列と二つ目の文字列を比較します。
		if (inputTxt1.compareTo(inputTxt2) < 0) {
			//負数が帰ってきたら一つ目の文字列が小さい。
			System.out.println(inputTxt1 + "  " + inputTxt2);
		} else if (inputTxt1.compareTo(inputTxt2) > 0) {
			//整数が帰ってきたら二つ目の文字列が小さい。
			System.out.println(inputTxt2 + "  " + inputTxt1);
		} else {
			//0が帰ってきたら文字列は等しい
			System.out.println("二つの文字列は同じです ->" + inputTxt1);
		}
	}
}