package koganei.ex090B;

import koganei.Input;

/**
 * 入力されたふたつの数字A,Bのうち、
 * 回文数となるものの個数を求め、結果を表示します
 *
 * @author 小金井 広輝
 */
public class Ex090B {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgeNumber number = new JudgeNumber();

		//入力された文字列が正しく入力できているかチェック
		if (!number.judgeNumer(inputString)) {
			return;
		}

		CountPalindrome Palindrome = new CountPalindrome();
		//結果を表示します
		System.out.println(Palindrome.getCountPalindrome(number));
	}
}
