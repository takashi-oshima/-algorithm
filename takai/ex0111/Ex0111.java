package takai.ex0111;

import java.util.Scanner;
/**
 * 文字列に許可しない文字が含まれていないかどうかを判定するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0111 {

	public static void main(String[] args) {
		/** 検索対象文字列 */
		String inputTxt = "";
		/** 許可しない文字 */
		String disallowChar[] = {"①","③","⑤","⑦","⑨"};
		/** 許可しない文字の判定 */
		int result = 0;
		/** 許可する文字列かの判定 */
		boolean disallowString = true;

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
		for (String string : disallowChar) {
			result = inputTxt.indexOf(string);
			if(result != -1) {
				//許可しない文字が含まれていた時、どの文字がどこに存在するかを出力し、
				//許可する文字列かという判定をfalseに設定します。
				System.out.println("許可しない文字(文字：" + string + " " + (result+1) +"桁目)が含まれます");
				disallowString = false;
			}
		}
		if(disallowString == true) {
			System.out.println("許可する文字列です。");
		}
	}
}
