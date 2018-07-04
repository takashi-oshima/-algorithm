package ex0240;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 2桁の数字を入力すると九九の表に値があるかどうかを出力します
 *
 * @author 小金井 広輝
 */
public class Ex0240 {
	public static void main(String args[]) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int inputInt;

		//キーボードから入力された整数を取得します。
		System.out.println("input number：");
		try {
			inputInt = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//2桁の数字が入力されているかの確認
		if (inputInt < 10) {
			System.out.println("2桁の数字を入力してください（10以上）");
			return;
		}

		//九九の表に値があるかのチェックを行います
		String ans = KukuCheck(inputInt);
		//結果を表示します
		System.out.println(ans);
	}

	/**
	 * 入力された数字が九九表の中にあるか確認し結果を返します
	 *
	 * @param inputInt 入力された数字
	 * @return 結果の詳細
	 */
	public static String KukuCheck(int inputInt) {
		String ansText = "";
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (inputInt == i * j) {
					ansText = ansText + "九九の表（" + i + "*" + j + "）にあります\n";
				}
			}
		}
		if (ansText.equals("")) {
			//表にない場合
			ansText = "九九の表にありません";
		}
		return ansText;
	}
}
