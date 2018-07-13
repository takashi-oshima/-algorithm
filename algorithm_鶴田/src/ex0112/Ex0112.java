package ex0112;

import java.util.Scanner;

/**
 * キーボードから文字列を受け付け、半角カナチェックをします
 *
 * @author 鶴田竜也
 */
public class Ex0112 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("文字列：");
		// 入力文字列をinputStringに格納します
		String inputString = scan.nextLine();
		System.out.println("この文字" + inputString + "は許可されますか");

		// 半角カナの正規表現（^[｡-ﾟ+]+$）をTABOO_CHARS（禁止文字）に代入します
		final String TABOO_CHARS = "^[｡-ﾟ+]+$";

		// 半角カナチェックをします
		if (inputString.matches(TABOO_CHARS))
			System.out.println("半角カナが含まれます");
		// 空文字、nullチェックをします
		else if (inputString.isEmpty() || inputString == null) {
			System.out.println("許可されません。空文字またはnullです");
		} else {
			System.out.println("許可する文字列です");
		}
	}
}