package takai.ex0113;

import java.util.Scanner;

/**
 * 入力された文字列に全角数字が含まれていたら、半角数字に置換するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0113 {

	public static void main(String[] args) {
		/** 検索対象文字列 */
		String inputTxt = "";

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

		StringBuffer checkTxt = new StringBuffer(inputTxt);

		//全角数字があれば、半角数字に置換します
		for(int i = 0 ; i < inputTxt.length(); i++) {
			char inputChar = inputTxt.charAt(i);
			if('０' <= inputChar && inputChar <= '９') {
				checkTxt.setCharAt(i,(char)(inputChar - '０' + '0'));
			}
		}
		//置換後の文字列を出力
		System.out.println(checkTxt.toString());
	}
}