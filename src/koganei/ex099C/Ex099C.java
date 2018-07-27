package koganei.ex099C;

import koganei.Input;

/**
 * 銀行からちょうどN円引き出すには少なくとも何回の操作が必要か求め結果を表示します
 * 引き出せる金額は以下の通りです
 * 1円
 * 6円,36円,216円・・・
 * 9円, 81円, 729円・・・
 *
 * @author 小金井 広輝
 */
public class Ex099C {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgePrice price = new JudgePrice();

		//入力された文字列が正しく入力できているかチェック
		if (!price.judgeConversion(inputString)) {
			return;
		}

		Drawer operation = new Drawer();
		//結果を表示します
		System.out.println(operation.getMinCount(price));
	}

}
