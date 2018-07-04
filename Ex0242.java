package algorithm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 整数値を入力し、その行数分の二等辺三角形を出力します
 *
 * @author 粟野真司
 */
public class Ex0242 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 入力した整数を格納する変数を宣言します
		int number;
		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		try {
			//入力フォームを表示します
			System.out.println("input number：");
			number = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("文字列は不正な入力です。数値を入力してください。");
			return;
		}

		// 入力された値が正数かの判定をします
		if (number < 0) {
			System.out.println("正数を入力してください。");
		}
		for (int i = 1; i <= number; i++) {
			// 半角空白で左上側直角三角形を表示します
			for (int j = 1; j <= (number - i); j++)
				System.out.print(" ");
			// 二等辺三角形を表示します
			for (int k = 1; k <= 2 * i - 1; k++)
				System.out.print("*");
			System.out.println();
		}
	}
}