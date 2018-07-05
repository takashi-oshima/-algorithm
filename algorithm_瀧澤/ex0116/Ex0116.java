package ex0116;

import java.io.IOException;
import java.util.Scanner;

/**
 * 2つの値を比較して、何が奇数か偶数かを求めるクラスです。
 *
 * @author 瀧澤
 */
public class Ex0116 {

	public static void main(String[] args) throws IOException {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("inputNumber1 :");
		//i1に整数を読み込む
		int i1 = scanner.nextInt();
		//i2に整数を読み込む
		System.out.println("inputNumber2 :");
		int i2 = scanner.nextInt();
		//i1 が偶数であり、かつi2 が偶数の場合
		if ((i1 % 2) == 0 && (i2 % 2) == 0) {
			System.out.println("2つの値ともに偶数です");
			//i1 が奇数であり、かつi2 が偶数の場合
		} else if ((i1 % 2) != 0 && (i2 % 2) == 0) {
			System.out.println("i1は奇数です。i2は偶数です");
			//i1 が偶数であり、かつi2 が奇数の場合
		} else if ((i1 % 2) == 0 && (i2 % 2) != 0) {
			System.out.println("i1は偶数です。i2は奇数です");
			//i1 が奇数であり、かつi2 が奇数の場合
		} else {
			System.out.println("2つの値ともに奇数です");
		}
	}
}
