package algorithm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから2桁の数値の入力を受け取り、
 * 九九の表にあるかどうか出力します
 *
 * @author 粟野真司
 */
public class Ex0240 {
	public static void main(String[] args) {
		// 入力した整数を格納する変数を宣言します
		int number;
		// 入力ストリームを生成します
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		try {
			//入力フォームを表示します
			System.out.println("input number：");
			number = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("文字列は不正な入力です。2桁の数値を入力してください。");
			return;
		}

		// 2桁の数値が入力されているかどうか確認します
		if (number < 10 || number > 99) {
			System.out.println("2桁の数値を入力してください");
			return;
		}

		// 2桁の数値の入力を受け取り、九九の表にあるかどうか判定します
		boolean judgement = false;
		int result = 0;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				result = (i * j);
				if (number == result) {
					System.out.println("九九の表（" + i + " * " + j + "）にあります");
					judgement = true;
				}
			}
		}
		if (judgement == false) {
			System.out.println("九九の表にありません");
		}
	}
}