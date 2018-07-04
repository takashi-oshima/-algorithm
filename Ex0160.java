package algorithm;

import java.util.Scanner;

/**
 * キーボードから0～5の範囲の2つの数字を元に、
 * 占い結果を出力します
 *
 * @author 粟野真司
 */
public class Ex0160 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		// 入力フォームを表示します
		System.out.println("1つ目の数字(0～5):");
		int number1 = scanner.nextInt();
		System.out.println("2つ目の数字(0～5):");
		int number2 = scanner.nextInt();

		// 0～5の数値が正しく入力されているかチェックします
		if (number1 < 0 || number1 > 5 || number2 < 0 || number2 > 5) {
			System.out.println("0～5の数値を入力してください");
			return;
		}

		// 占い結果を格納する多次元配列を生成します
		String divination[][] = {
				{ "吉", "吉", "凶", "凶", "凶", "吉" },
				{ "吉", "吉", "凶", "吉", "凶", "吉" },
				{ "凶", "凶", "吉", "吉", "吉", "吉" },
				{ "凶", "吉", "吉", "吉", "凶", "凶" },
				{ "凶", "凶", "凶", "吉", "吉", "凶" },
				{ "凶", "吉", "吉", "凶", "凶", "凶" } };
		System.out.println("占い結果は" + divination[number1][number2] + "です");
	}
}