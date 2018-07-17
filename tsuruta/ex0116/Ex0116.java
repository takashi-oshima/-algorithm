package tsuruta.ex0116;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 2つの整数値inputNumber1,inputNumber2を入力します。
 * inputNumber1が偶数であり、かつinputNumber2が偶数の場合、「2つの値ともに偶数です」と表示します。
 * inputNumber1が奇数であり、かつinoutNumber2が偶数の場合、「inputNumber1は奇数です。inputNumber2は偶数です」と表示します。
 * inputNumber1が偶数であり、かつinputNumber2が奇数の場合、「inputNumber1は偶数です。inputNumber2は奇数です」と表示します。
 * inputNumber1が奇数であり、かつinputNumber2が奇数の場合、「2つの値ともに奇数です」と表示します。
 *
 * @author 鶴田竜也
 */
public class Ex0116 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("inputNumber1");

		// try catch文を使うためinputNumber1、inputNumber2を初期化しておく
		int inputNumber1 = 0;
		int inputNumber2 = 0;

		// inputNumber1に整数を読み込む
		try {
			inputNumber1 = scan.nextInt();
			// inputNumber2に整数を読み込む
			System.out.println("inputNumber2");
			inputNumber2 = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字以外を入力しないでください");
		}

		if ((inputNumber1 % 2 == 0) && (inputNumber2 % 2 == 0)) {
			System.out.println("2つの値ともに偶数です");
		} else if ((inputNumber1 % 2 != 0) && (inputNumber2 % 2 == 0)) {
			System.out.println("inputNumber1は奇数です。inputNumber2は偶数です");
		} else if ((inputNumber1 % 2 == 0) && (inputNumber2 % 2 != 0)) {
			System.out.println("inputNumber1は偶数です。inputNumber2は奇数です");
		} else if ((inputNumber1 % 2 != 0) && (inputNumber2 % 2 != 0)) {
			System.out.println("2つの値ともに奇数です");
		}
	}
}