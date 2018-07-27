package koganei.ex086B;

import koganei.Input;

/**
 * 入力された２つの数字を繋げて読んだものが平方数かどうか判定し
 * 結果を表示します
 *
 * @author 小金井 広輝
 */
public class Ex086B {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgeNumber number = new JudgeNumber();

		//入力された文字列が正しく入力できているかチェック
		if (!number.judgeNumber(inputString)) {
			return;
		}

		SquareRoot root = new SquareRoot();
		//結果を表示します
		System.out.println(root.JudgeSquareRoot(number));
	}
}
