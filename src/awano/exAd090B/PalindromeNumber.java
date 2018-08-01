package awano.exAd090B;

/**
 * A以上、B以下の整数のうち、回文数となるものの個数を求めます。
 * 但し、回文数とは先頭に0をつけない10進数表記を文字列として見たとき、
 * 前から読んでも後ろから読んでも同じ文字列となるような整数のことを指します。
 *
 * @author 粟野真司
 */
public class PalindromeNumber {
	/**
	 * 回文数の個数を求めます。
	 *
	 * @param inputNumber InputNumberクラス
	 */
	public void countPalindromeNum(InputNumber inputNumber) {
		String startNum = String.valueOf(inputNumber.getANumber());
		//開始の数値
		int start = inputNumber.getANumber();
		//終了の数値
		int end = inputNumber.getBNumber();
		//回文数のカウンタ変数
		int count = 0;

		//開始の数値から終了の位置までの回文数の個数を求めます。
		for (int i = start; i <= end; i++) {
			startNum = String.valueOf(i);
			//要素番号で比較できるよう、char型配列に変換し、格納します。
			char[] charNum = startNum.toCharArray();

			/*
			 * 配列の要素[0]と要素[4]が同じでかつ、要素[1]要素[3]が同じの場合
			 * 回文数をカウントします。
			 */
			if (charNum[0] == charNum[4] && charNum[1] == charNum[3]) {
				count++;
			}
		}
		System.out.println(count);
	}
}