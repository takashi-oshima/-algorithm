package tsuruta.ex0114;

import java.util.Scanner;

/**
 * キーボードから文字列を入力し、
 * 文字列内 の半角空白で単語に分解します
 * 分解後、単語を逆順で出力します。半角空白が連続 で入力 された場合 は無視します
 *
 * @author 鶴田竜也
 */
public class Ex0114 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("文字列：");
		// inputStringに文字列を読み込みます
		String inputString = scan.nextLine();

		// 半角空白2つ以上を半角空白1つに置き換える
		inputString = inputString.replaceAll(" {2,}"," ");
		//inputStringを配列に格納し、半角空白１つ毎に入力された文字列を分割します
		String[] words = {inputString};
		words = inputString.split(" ");

		// 分解後の単語を逆順に並び替えて出力します
		for (int i = words.length-1; i >= 0; i--) {
			System.out.print(words[i] + " ");
		}
		// 空文字、nullチェックをします
		if (inputString.isEmpty() || inputString == null) {
			System.out.println("空文字またはnullです");
		}
	}
}