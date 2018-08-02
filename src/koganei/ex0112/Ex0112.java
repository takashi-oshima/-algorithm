package koganei.ex0112;

import java.util.Scanner;

/**
 * 入力された半角カナ文字の判定を行います
 *
 * @author 小金井 広輝
 */
public class Ex0112 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);

		//キーボードから入力された文字列を取得します
		System.out.println("文字列：");
		String inputString = scanner.nextLine();

		//文字列のエラーチェックを行い、正しく入力されていたら半角カナ文字判定を行います
		if (stringErrorCheck(inputString)) {
			//判定を行います。
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
	 * 半角カナが含まれるかの判定を行います
	 *
	 * @param inputString 入力された文字列
	 * @return 判定結果の詳細
	 */
	public static String charJudgment(String inputString) {
		final String HALFWIDTH_KANA = ".*[\\uFF65-\\uFF9F].*";
		if (inputString.matches(HALFWIDTH_KANA)) {
			return "半角カナが含まれます";
		} else {
			return "許可する文字列です";
		}
	}
}
