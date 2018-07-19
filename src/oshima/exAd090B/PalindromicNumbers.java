package oshima.exAd090B;

/**
 * A 以上 B 以下の整数のうち、回文数となるものの個数を求めます。 但し、回文数とは先頭に 0 をつけない 10
 * 進表記を文字列として見たとき、前から読んでも後ろから 読んでも同じ文字列となるような正の整数のことを指します。
 *
 *
 * @author 大島
 */
public class PalindromicNumbers {

	/**
	 * 指定した数値の範囲から、回文数となる数値の個数を求めます。
	 *
	 * @param input Inputクラス
	 * @return 回文数の個数
	 */
	public int findPalindrome(Input input) {
		int palindromeCount = 0;
		int startNumber = Integer.parseInt(input.getInputNumberA());
		int endNumber = Integer.parseInt(input.getInputNumberB());

		for (int i = startNumber; i <= endNumber; i++) {
			String compareNumber = Integer.toString(i);

			if (compareNumber.charAt(0) == compareNumber.charAt(4)
					&& compareNumber.charAt(1) == compareNumber.charAt(3)) {
				palindromeCount++;
			}
		}
		return palindromeCount;
	}
}
