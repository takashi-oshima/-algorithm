package takai.ex0117;

import java.util.Scanner;

/**
 * 2科目の成績を参照し、進級の判定をするクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0117 {

	public static void main(String[] args) {
		/** 一つ目の文字列 */
		String inputEnglishScore = "";
		/** 二つ目の文字列 */
		String inputMathScore = "";

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		//入力値をそれぞれに代入します。
		System.out.println("input english score：");
		inputEnglishScore = scan.nextLine();
		System.out.println("input math score：");
		inputMathScore = scan.nextLine();

		//NULL・空文字チェック
		if (inputEnglishScore == null || inputEnglishScore.isEmpty()) {
			System.out.println("input english scoreが空白、もしくはnull値になっています");
			return;
		}
		if (inputMathScore == null || inputMathScore.isEmpty()) {
			System.out.println("input math scoreが空白、もしくはnull値になっています");
			return;
		}
		System.out.println(promotionDecision(inputEnglishScore, inputMathScore));
	}

	/**
	 * それぞれの入力値が80以上か否かを判定し、結果の文字列を返します。
	 *
	 * @param englishScore 入力された文字列1
	 * @param mathScore 入力された文字列2
	 * @return 判定結果
	 */
	private static String promotionDecision(String inputEnglishScore, String inputMathScore) {
		try {
			int englishScore = Integer.parseInt(inputEnglishScore);
			int mathScore = Integer.parseInt(inputMathScore);

			if (80 <= englishScore && 80 <= mathScore) {
				return "進級";
			} else if (englishScore < 80 && mathScore < 80) {
				return "留年";
			} else {
				return "再試験";
			}
		} catch (NumberFormatException e) {
			return "整数以外のものが入力されています。";
		}
	}
}