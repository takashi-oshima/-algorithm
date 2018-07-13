package ex0116;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードからふたつの正数を入力し、奇数か偶数かの判別を行います。
 * 判別後、結果を表示します。
 *
 * @author 小金井 広輝
 */
public class Ex0116 {

	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします。
		Scanner scanner = new Scanner(System.in);
		//整数値の入力数
		final int COUNT = 2;
		//入力された数字の取得用配列
		int[] inputInt = new int[COUNT];

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

		//正しく入力されていたら奇数偶数判定を行います。
		//奇数偶数判定を行います。
		String[] oddOrEven = judgeOddOrEven(inputInt);
		//結果表示の判定を行います。
		String ans = resultJudgement(oddOrEven);
		//結果を表示します。
		System.out.println("\r\n" + ans);

	}

	/**
	 * 入力された整数配列の奇数偶数の判定を行い、結果を奇数、偶数で返します。
	 *
	 * @param inputInteger 入力された整数配列
	 * @return 奇数、偶数を判定した配列
	 */
	public static String[] judgeOddOrEven(int[] inputInteger) {
		String[] oddOrEven = new String[inputInteger.length];
		//入力された整数配列の奇数偶数の判定を行います。
		for (int i = 0; i < inputInteger.length; i++) {
			if (inputInteger[i] % 2 == 0) {
				//偶数の場合
				oddOrEven[i] = "偶数";
			} else {
				//奇数の場合
				oddOrEven[i] = "奇数";
			}
		}
		return oddOrEven;
	}

	/**
	 * 入力された数字がすべて奇数、すべて偶数、それ以外の判定を行い、結果を返します。
	 *
	 * @param oddOrEven 奇数、偶数を判定した配列
	 * @return 奇数、偶数判定結果表示文
	 */
	public static String resultJudgement(String[] oddOrEven) {
		String ansText = "";
		if (!Arrays.asList(oddOrEven).contains("奇数")) {
			//偶数のみの場合
			ansText = oddOrEven.length + "つの値はすべて偶数です。";
		} else if (!Arrays.asList(oddOrEven).contains("偶数")) {
			//奇数のみの場合
			ansText = oddOrEven.length + "つの値はすべて奇数です。";
		} else {
			//それ以外の場合
			for (int i = 0; i < oddOrEven.length; i++) {
				ansText = ansText + "i" + (i + 1) + "は" + oddOrEven[i] + "です。";
			}
		}
		return ansText;
	}
}
