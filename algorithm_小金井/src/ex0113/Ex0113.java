package ex0113;

import java.util.Scanner;

/**
 * 入力された文字列内に全角数字が含まれる場合、半角数字に置換して出力します
 *
 * @author 小金井 広輝
 */
public class Ex0113 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);

		//キーボードから入力された文字列を取得します
		System.out.println("文字列：");
		String inputString = scanner.nextLine();

		//文字列のエラーチェックを行い、正しく入力されていたら
		//全角数字と半角数字の置換判定を行います
		if (stringErrorCheck(inputString)) {
			//判定を行います
			String ans = charJudgment(inputString);
			//結果を表示します
			System.out.println(ans);
		}
	}

	/**
	 * 読み込める文字列かチェック
	 *
	 * @param inputString 入力された文字列
	 * @return 正しい文字列かの真偽
	 */
	public static boolean stringErrorCheck(String inputString) {
		if (inputString == null) {
			//文字列がnullの場合
			System.out.println("入力された値がnullです");
			return false;
		} else if (inputString.equals("")) {
			//文字列が空の場合
			System.out.println("文字列が入力されていません");
			return false;
		}
		//正しく入力されている場合
		return true;
	}

	/**
	 * 文字列内に全角数字がある場合、半角数字に置換し結果を返します
	 *
	 * @param inputString 入力された文字列
	 * @return 置換した文字列
	 */
	public static String charJudgment(String inputString) {
		StringBuilder sb = new StringBuilder(inputString);
		for (int i = 0; i < sb.length(); i++) {
			int inputChar = (int) sb.charAt(i);
			if (inputChar >= 0xFF10 && inputChar <= 0xFF19) {
				//全角数字がある場合
				sb.setCharAt(i, (char) (inputChar - 0xFEE0));
			}
		}
		return "結果：" + sb.toString();
	}
}
