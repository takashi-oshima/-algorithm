package takai.ex0160;

import java.util.Scanner;

/**
 * 二つの入力値から占いを行うクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0160 {

	public static void main(String[] args) {
		/** 1つ目の文字列 */
		int inputNumber1 = 0;
		/** 2つ目の文字列 */
		int inputNumber2 = 0;
		/** 占い結果の格納用 */
		String fortuneResult = "";

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//入力値をそれぞれに代入します。
			System.out.println("１つ目の数字（0～5）：");
			inputNumber1 = Integer.parseInt(scan.nextLine());
			System.out.println("２つ目の数字（0～5）：");
			inputNumber2 = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("不適な文字列です。整数を入力してください。");
			return ;
		}

		//コマンドによって計算式を変化させます。
		switch(inputNumber1) {
		case 0:
			switch(inputNumber2) {
			case 0:
			case 1:
			case 5:
				fortuneResult = "吉";
				break ;
			default:
				fortuneResult = "凶";
			}
			break;
		case 1:
			switch(inputNumber2) {
			case 0:
			case 1:
			case 3:
			case 5:
				fortuneResult = "吉";
				break ;
			default:
				fortuneResult = "凶";
			}
			break;
		case 2:
			switch(inputNumber2) {
			case 2:
			case 3:
			case 4:
			case 5:
				fortuneResult = "吉";
				break ;
			default:
				fortuneResult = "凶";
			}
			break;
		case 3:
			switch(inputNumber2) {
			case 1:
			case 2:
			case 3:
				fortuneResult = "吉";
				break ;
			default:
				fortuneResult = "凶";
			}
			break;
		case 4:
			switch(inputNumber2) {
			case 3:
			case 4:
				fortuneResult = "吉";
				break ;
			default:
				fortuneResult = "凶";
			}
			break;
		case 5:
			switch(inputNumber2) {
			case 1:
			case 2:
				fortuneResult = "吉";
				break ;
			default:
				fortuneResult = "凶";
			}
			break;
		default:
			System.out.println("入力値が不正です。");
			return;
		}
		System.out.println("占いの結果は " + fortuneResult + "です。");
	}
}