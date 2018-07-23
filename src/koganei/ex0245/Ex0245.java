package koganei.ex0245;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードからふたつの整数値を入力し、最大公約数を出力します
 *
 * @author 小金井 広輝
 */
public class Ex0245 {
	public static void main(String[] args) {

		//キーボードから取得する数
		final int COUNT = 2;

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int[] inputInt = new int[COUNT];

		//キーボードから入力された整数を取得します。
		for (int i = 0; i < COUNT; i++) {
			System.out.println("input number" + (i + 1) + "：");
			try {
				inputInt[i] = scanner.nextInt();
				if (inputInt[i] < 0) {
					System.out.println("正数を入力してください");
					return;
				}
			} catch (InputMismatchException e) {
				System.out.println("数字を入力してください");
				return;
			}
		}

		//入力されたふたつの数字のどちらが高いかを求めます
		int inputIntMin = getMin(inputInt);
		//最大公約数を求めます
		int ans = getGreatestCommonDivisor(inputInt, inputIntMin);
		//結果を表示します
		System.out.println("最大公約数= " + ans);
	}

	/**
	 * 入力された数字の中で一番小さい数字を返します
	 *
	 * @param inputInt 入力された数字群
	 * @return もっとも小さい値
	 */
	public static int getMin(int[] inputInt) {
		int min = inputInt[0];
		for (int i = 1; i < inputInt.length; i++) {
			if (min > inputInt[i]) {
				min = inputInt[i];
			}
		}
		return min;
	}

	/**
	 * 最大公約数を求め結果を返します
	 *
	 * @param inputInt 入力された数字群
	 * @param inputIntMin 入力された数字の中で一番小さい数字
	 * @return 最大公約数
	 */
	public static int getGreatestCommonDivisor(int[] inputInt, int inputIntMin) {
		int greatestCommonDivisor = 1;
		boolean divisorFlg = true;
		//ひとつずつ約数を調べながら最大公約数を求めます。
		for (int divisor = 1; divisor <= inputIntMin; divisor++) {
			for (int i = 0; i < inputInt.length; i++) {
				if (inputInt[i] % divisor != 0) {
					divisorFlg = false;
					break;
				}
			}
			if (divisorFlg) {
				//入力された数字がすべて割り切れたとき
				greatestCommonDivisor = divisor;
			}
			divisorFlg = true;
		}
		return greatestCommonDivisor;
	}
}
