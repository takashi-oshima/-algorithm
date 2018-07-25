package koganei.ex080B;

import koganei.Input;

/**
 * 入力された数字がハーシャッド数であるか判定し結果を変えします
 * ハーシャッド数とは整数Xの各桁の和をf(X)としたとき、Xがf(X)で割り切れる数
 * を指します
 *
 * @author 小金井 広輝
 */
public class Ex080B {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgeNumber number = new JudgeNumber();

		//入力された文字列が正しく入力できているかチェック
		if (!number.judgeNumber(inputString)) {
			return;
		}

		HarshadNumber harshadNumber = new HarshadNumber();
		//結果を表示します
		System.out.println(harshadNumber.judgeHarshad(number));
	}
}
