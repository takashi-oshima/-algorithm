package takizawa.ex0160;

import java.util.Scanner;

/**
 * 2つの数字をもとに、占いの結果を出力します
 *
 * @author 瀧澤
 */
public class Ex0160 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("１つめの数字(0～5)");
		//number1に整数を読み込む
		int number1 = scanner.nextInt();
		System.out.println("２つめの数字(0～5)");
		//number2に整数を読み込む
		int number2 = scanner.nextInt();
		//2次元配列に占いの結果を格納します
		String[][] fortune = new String[][] {
				{ "吉", "吉", "凶", "凶", "凶", "吉" },
				{ "吉", "吉", "凶", "吉", "凶", "吉" },
				{ "凶", "凶", "吉", "吉", "吉", "吉" },
				{ "凶", "吉", "吉", "吉", "凶", "凶" },
				{ "凶", "凶", "凶", "吉", "吉", "凶" },
				{ "凶", "吉", "吉", "凶", "凶", "凶" } };

		//キーボード入力した時に、占いの結果が表示されるようにします
		System.out.println("占いの結果は" + fortune[number1][number2] + "です");
	}
}