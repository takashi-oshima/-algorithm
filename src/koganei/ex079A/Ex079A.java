package koganei.ex079A;

import koganei.Input;

/**
 * 入力された数字が良い整数かどうか判定し結果を表示します
 * 良い整数とは「1118」のような連続した数字が3つ以上並んだ4桁の整数を
 * 指します
 *
 * @author 小金井 広輝
 */
public class Ex079A {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgeNumber number = new JudgeNumber();

		//入力された文字列が正しく入力できているかチェック
		if (!number.judgeNumber(inputString)) {
			return;
		}

		GoodNumber goodNumber = new GoodNumber();
		//結果を表示します
		System.out.println(goodNumber.judgeGoodNumber(number));
	}
}
