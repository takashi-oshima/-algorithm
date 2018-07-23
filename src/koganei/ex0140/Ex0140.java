package koganei.ex0140;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードからふたつの整数値とコマンドを入力し、計算結果を出力します
 * コマンドの意味は以下の通りです
 * 0：足し算
 * 1：引き算
 * 2：掛け算
 * その他：割り算
 *
 * @author 小金井 広輝
 */
public class Ex0140 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		//整数値の入力数
		final int COUNT = 2;
		//入力された数字の取得用配列
		int[] inputInt = new int[COUNT];
		//コマンド取得
		int command;

		//キーボードから入力されたCOUNT分の整数を取得します。
		for (int i = 0; i < inputInt.length; i++) {
			System.out.println("input number" + (i + 1) + "：");
			try {
				inputInt[i] = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("数字を入力してください");
				return;
			}
		}

		//キーボードから入力されたコマンドを取得します。
		System.out.println("input command：");
		try {
			command = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//計算処理を行います
		int ans = commandJudgment(inputInt, command);
		//計算結果を表示します
		System.out.println("\n計算結果＝" + ans);
	}

	/**
	 * コマンドに応じて計算処理を行います
	 *
	 * @param inputInt 入力された文字配列
	 * @param command コマンドの番号
	 * @return 計算結果
	 */
	public static int commandJudgment(int[] inputInt, int command) {
		int total = 0;
		switch (command) {
		case 0:
			//足し算の場合
			for (int i = 0; i < inputInt.length; i++) {
				total = total + inputInt[i];
			}
			break;
		case 1:
			//引き算の場合
			total = inputInt[0];
			for (int i = 1; i < inputInt.length; i++) {
				total = total - inputInt[i];
			}
			break;
		case 2:
			//掛け算の場合
			total = 1;
			for (int i = 0; i < inputInt.length; i++) {
				total = total * inputInt[i];
			}
			break;
		default:
			//その他（割り算の場合）
			total = inputInt[0];
			for (int i = 1; i < inputInt.length; i++) {
				total = total / inputInt[i];
			}
		}
		//計算結果
		return total;
	}
}
