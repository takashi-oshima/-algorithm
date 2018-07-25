package koganei.ex088A;

import koganei.Input;

/**
 * 一円玉A枚と500円玉を無限に待っており、
 * ちょうどN円支払うことができるかの判定をし、結果を表示します
 * 入力形式は
 * >N A
 *
 * @author 小金井 広輝
 */
public class Ex088A {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgePrice price = new JudgePrice();

		//入力された文字列が正しく入力できているかチェック
		if (!price.judgePrice(inputString)) {
			return;
		}

		JustPayment payment = new JustPayment();
		//結果を表示します
		System.out.println(payment.JudgeJustPayment(price));
	}
}
