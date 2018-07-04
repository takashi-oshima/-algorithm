package ex0235;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力された0～255の範囲の10進数整数値を2進数と16進数に
 * 変換して出力します
 *
 * @author 小金井 広輝
 */
public class Ex0235 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int inputInt;

		//キーボードから入力された整数を取得します。
		System.out.println("0～255の範囲の10進数：");
		try {
			inputInt = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//入力された数字が範囲内（0～255）かの判別を行います
		if (inputInt < 0 || inputInt > 255) {
			System.out.println("範囲内の数字を入力してください");
			return;
		}

		//進数計算を行い結果を取得します
		String ansBinary = String.format("%08d", Integer.parseInt(decimalCcalculation(inputInt, 2)));
		String ansHex = decimalCcalculation(inputInt, 16);

		//結果を表示します
		System.out.println("2進数の変換結果：" + ansBinary);
		System.out.println("16進数の変換結果：" + ansHex);
	}

	/**
	 * 10進数を指定された進数に変換して結果を返します(2進数～16進数まで)
	 *
	 * @param inputInt 入力された数字（10進数）
	 * @param decimal 指定された進数
	 * @return 計算結果
	 */
	public static String decimalCcalculation(int inputInt, int decimal) {
		final String[] HEX = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		String ans = "";

		//進数計算を行います
		for (int i = inputInt; i > 0; i = i / decimal) {
			if (i % decimal == 0) {
				ans = "0" + ans;
			} else {
				ans = HEX[i % decimal - 1] + ans;
			}
		}
		if (ans.equals("")) {
			//入力された数字が0だった場合
			ans = "0";
		}
		return ans;
	}
}
