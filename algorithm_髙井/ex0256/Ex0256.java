package ex0256;

import java.util.Scanner;

/**
 * 入力された文字列が、指定した日付形式か否か出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0256 {

	public static void main(String[] args) {
		/** 1つ目の文字列 */
		String inputDay = "";

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//入力値を代入します。
			System.out.println("input date：");
			inputDay = scan.nextLine();
		} catch (Exception e) {
			System.out.println("不適な文字列です。");
			return;
		}

		//NULL・空文字チェック
		if (inputDay == null || inputDay.isEmpty()) {
			System.out.println("文字列が空白、もしくはnull値になっています");
			return;
		}

		//指定した日付形式か判定します。
		if (inputDay.matches("^[0-9]{4}/[0-1]{1}[0-2]{1}/[0-3]{1}[0-9]{1}$")) {
			System.out.println("指定した形式です。");
		} else {
			System.out.println("指定した形式ではありません。");
		}
	}
}