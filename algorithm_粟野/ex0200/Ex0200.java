package algorithm.ex0200;

import java.util.Scanner;

/**
 * キーボードから1つの整数値nを入力し、
 * 1からnまでの和を求め、結果を出力します
 *
 * @author 粟野真司
 */
public class Ex0200 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		// 入力フォームを表示します
		System.out.println("input number:");
		int number = scanner.nextInt();
		// 入力された値が正数かの判定をします
		if (number < 0) {
			System.out.println("正数を入力してください");
			return;
		}

		// 入力された整数値までの和を求め、結果を表示します
		int index = 1;
		int sum = 0;
		while (index <= number) {
			sum = sum + index;
			index++;
		}
		System.out.println("合計値 = " + sum);
	}
}