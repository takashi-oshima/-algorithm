package ex0140;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから2つの整数値とコマンドを入力し、計算結果を表示させます。
 * コマンドの意味は0：足し算、1：引き算、2：掛け算、その他：割り算となります。
 *
 * @author 鶴田竜也
 */
public class Ex0140 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("文字列：");
		System.out.println("input number1");

		double inputNumber1 = 0;
		double inputNumber2 = 0;
		int inputCommand = 0;

		try {
			inputNumber1 = scan.nextDouble();
			System.out.println("input number2");
			inputNumber2 = scan.nextDouble();
			System.out.println("input Command");
			inputCommand = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//inputCommandの値によって処理を分けます
		switch (inputCommand) {
		case 0:
			System.out.println(inputNumber1 + inputNumber2);
			break;
		case 1:
			System.out.println(inputNumber1 - inputNumber2);
			break;
		case 2:
			System.out.println(inputNumber1 * inputNumber2);
			break;
		default:
			System.out.println(inputNumber1 / inputNumber2);
			break;
		}
	}
}