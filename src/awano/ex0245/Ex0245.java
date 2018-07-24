package awano.ex0245;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから2つの整数値を入力し、最大公約数を出力します
 *
 * @author 粟野真司
 */
public class Ex0245 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 入力した整数を格納する変数を宣言します
		int number1 = 0;
		int number2 = 0;
		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		try {
			//入力フォームを表示します
			System.out.println("input number1：");
			number1 = scanner.nextInt();
			System.out.println("input number2：");
			number2 = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("文字列は不正な入力です。数値を入力してください。");
			return;
		}
		// 2桁の数値が正しく入力されているか確認します
		if (number1 <= 0 || number2 <= 0) {
			System.out.println("1以上の数値を入力してください");
			return;
		}

		int commonDivisor;
		//ユークリッドの互除法により最大公約数を求めます
		while ((commonDivisor = number1 % number2) != 0) {
			number1 = number2;
			number2 = commonDivisor;
		}
		System.out.println("最大公約数 =" + number2);
	}
}