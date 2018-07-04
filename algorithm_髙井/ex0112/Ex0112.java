package ex0112;

import java.util.Scanner;

/**
 * 文字列に許可しない文字が含まれていないかどうかを判定するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0112 {

	public static void main(String[] args) {
		/** 検索対象文字列 */
		String inputTxt = "";
		/** 半角カナのチェック */
		final String HALFWIDTH_KANA = ".*[\\uFF65-\\uFF9F].*";

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		//入力値を代入します。
		System.out.println("文字列を入力してください");
		System.out.println("文字列：");
		inputTxt = scan.next();

		//NULL・空文字チェック
		if (inputTxt == null || inputTxt.isEmpty()) {
			System.out.println("1つ目の文字列が空白、もしくはnull値になっています");
			return;
		}

		//入力した文字列の中に、許可しない文字が含まれていないか判定します
		if (inputTxt.matches(HALFWIDTH_KANA)) {
			//許可しない文字が含まれていた時、どの文字がどこに存在するかを出力し、
			//許可する文字列かという判定をfalseに設定します。
			System.out.println("許可しない文字(半角カナ)が含まれます");
		}else{
			System.out.println("許可する文字列です。");
		}
	}
}