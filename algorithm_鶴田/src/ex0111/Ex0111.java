package ex0111;

import java.util.Scanner;

/**
 * キーボードから文字列を入力し、禁止文字（①、③、⑤、⑦、⑨）が含まれているか判定します
 *
 * @author 鶴田竜也
 */
public class Ex0111 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("文字列：");
		// inputStringにキーボード入力した文字列が入ります
		String inputStr = scan.nextLine();

		// 禁止文字を配列に入れます
		final String[] TABOO_CHARS = { "①", "③", "⑤", "⑦", "⑨" };

		/* 判定 judgeを用意します。 judgeがtrueなら"許可しない文字
		   (文字：" + tabooChar + " " + (result + 1) + "桁目)が含まれています"出力します */
		boolean judge = true;
		for (String tabooChar : TABOO_CHARS) {
			int result = inputStr.indexOf(tabooChar);
			if (result != -1) {
				// for文を終えた後のif文を実行させないためにjudgeをtrueからfalseに変えます
				judge = false;
				System.out.println("許可しない文字(文字：" + tabooChar + " " + (result + 1) + "桁目)" + "が含まれています");
			}
		}
		if (judge == true) {
			System.out.println("許可する文字列です");
		}
		// 空文字、nullチェックをします
		if (inputStr.isEmpty() || inputStr == null) {
			System.out.println("空文字もしくはnullです。");
			return;
		}
	}
}