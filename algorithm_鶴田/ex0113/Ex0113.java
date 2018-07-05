package ex0113;

import java.util.Scanner;

/**
 * キーボードから文字列を入力し、文字列内に全角数字が含まれる場合は
 * 半角数字にして出力します。
 *
 * @author 鶴田竜也
 */
public class Ex0113 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("文字列：");
		//入力文字列をinputStringに格納
		String inputString = scan.nextLine();

		for (int i = 0; i < inputString.length(); i++) {
			// i番目の文字列を抜き出してcに代入します
			int c = (int) inputString.charAt(i);
			//0xFF10はユニコードの全角数字0、0xFF19はユニコードの全角数字９
			//cから0xFEE0（ユニコード上の半角数字までの距離）を引きます
			if (c >= 0xFF10 && c <= 0xFF19) {
				i = (char) (c - 0xFEE0);
			}
		}
		//Strin型に変換し、inputStringに代入します
		inputString = inputString.toString();
		System.out.println("結果：" + inputString);
	}
}