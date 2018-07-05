package algorithm.ex0116;

import java.util.Scanner;

/**
 * 2つの整数値入力を受け取り、入力された値が
 * それぞれ偶数か奇数かを表示します
 *
 * @author 粟野真司
 */
public class Ex0116 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		// 入力フォームを表示します
		System.out.println("input number1:");
		int number1 = scanner.nextInt();
		System.out.println("input number2:");
		int number2 = scanner.nextInt();

		// input number1とinput number2の入力値が偶数か奇数かによって表示を変更します
		if (number1 % 2 == 0 && number2 % 2 == 0) {
			System.out.println("2つの値ともに偶数です");
		} else if (number1 % 2 != 0 && number2 % 2 == 0) {
			System.out.println("i1は奇数です。i2は偶数です");
		} else if (number1 % 2 == 0 && number2 % 2 != 0) {
			System.out.println("i1は偶数です。i2は奇数です");
		} else if (number1 % 2 != 0 && number2 % 2 != 0) {
			System.out.println("2つの値ともに奇数です");
		}
	}
}
