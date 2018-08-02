package tsuruta.ex0242;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 整数値を入力し、その行数分の二等辺三角形を出力します
 *
 * @author 鶴田竜也
 */
public class Ex0242 {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int inputNumber;

		System.out.println("input number：");
		try {
			inputNumber = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}
		if(inputNumber < 0) {
			System.out.println("マイナスの値を入力しないでください");
			return;
		}
		// 入力された数値分の行数を繰り返します
		for (int i = 1; i <= inputNumber; i++) {
			for (int j = 1; j <= inputNumber - i; j++) {
				System.out.print(" ");
			}
			// 2n-1の数だけ*を出力します
			for (int k = 0; k < 2*i-1; k++) {
				System.out.print("*");
			}System.out.println();
		}
	}
}