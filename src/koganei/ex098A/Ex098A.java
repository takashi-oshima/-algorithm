package koganei.ex098A;

import koganei.Input;

/**
 * 入力されたふたつの整数A、BのA+B ,A-B,A*Bで最大の値を表示します
 *
 * @author 小金井 広輝
 */
public class Ex098A {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgeNumber number = new JudgeNumber();

		//入力された文字列が正しく入力できているかチェック
		if (!number.judgeConversion(inputString)) {
			return;
		}

		Maxnum max = new Maxnum();
		//結果を表示します
		System.out.println(max.getMax(number));
	}
}
