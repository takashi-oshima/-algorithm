package ex0115;

import java.util.Scanner;

/**
 * キーボードからの文字列を入力し、文字列内で単語に分解します。
 * 分解後、単語の出力順序が偶数と奇数でそれぞれ結合して出力します。
 *
 * @author 鶴田竜也
 */
public class Ex0115 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("文字列：");
		//inputStringに文字列を読み込みます
		String inputString = scan.nextLine();

		//inputStringを配列に格納し、半角空白１つ毎に入力された文字列を分割します
		String[] words = { inputString };
		words = inputString.split(" ");

		System.out.print("奇数番目: ");
		//分割後の文字列を順に見ていき、奇数番目が見つかり次第出力します
		for (int i = 0; i < words.length; i++) {
			if (i % 2 == 0) {
				System.out.print(words[i] + " ");
			}
		}
		System.out.println();

		System.out.print("偶数番目: ");
		//分割後の文字列を順に見ていき、偶数番目が見つかり次第出力します
		for (int i = 0; i < words.length; i++) {
			if (i % 2 != 0) {
				System.out.print(words[i] + " ");
			}
		} //空文字、nullチェックをします
		if (inputString.isEmpty() || inputString == null) {
			System.out.println("空文字またはnullです");
		}
	}
}