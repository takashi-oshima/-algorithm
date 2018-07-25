package koganei.ex079B;

import koganei.Input;

/**
 * 入力された数字NのN番目のリュカ数を表示します
 * リュカ数はi番目のリュカ数Liとすると
 * L0 = 2
 * L1 = 1
 * Li = L(i-1) + L(i-2)  (i >= 2)
 * と定義される数を指します
 *
 * @author 小金井 広輝
 */
public class Ex079B {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgeNumber number = new JudgeNumber();

		//入力された文字列が正しく入力できているかチェック
		if (!number.judgeNumber(inputString)) {
			return;
		}

		RyukaNumber ryukaNumber = new RyukaNumber();
		//結果を表示します
		System.out.println(ryukaNumber.getRyukaNumber(number));
	}
}
