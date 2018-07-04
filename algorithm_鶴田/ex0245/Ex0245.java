package ex0245;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから2つの数値を入力し、最大公約数を出力します（ユークリッドの互除法）
 *
 * @author 鶴田竜也
 */
public class Ex0245 {

	public static void main(String[] args) {
		// キーボードから入力値を取得できるようにします
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int inputInt1 = 0;
		int inputInt2 = 0;

		// キーボードから入力された整数を取得します
		System.out.println("input number1：");
		try {
			inputInt1 = scanner.nextInt();
			System.out.println("input number1：");
			inputInt2 = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		// 入力された2つの整数を比較し、最大値、最小値を求め、格納します
		int max = Math.max(inputInt1, inputInt2);
		int min = Math.min(inputInt1, inputInt2);

		// 余りを保存する変数（remainder）を用意し、余りを表す１を代入します
		int remainder = 1;

		// 計算結果の余りが0の場合、minが最大公約数になり、while文を終えます
		// 余りが存在する間、割り算を繰り返します
		while (remainder != 0) {
			// maxをminで割った余りを保存します
			remainder = max % min;
			//remainderを0と比較します
			if (remainder == 0) {
				System.out.println("最大公約数 = " + min);
			}
			// 割る値と余りを使って計算を繰り返します
			max = min;
			min = remainder;
		}
	}
}