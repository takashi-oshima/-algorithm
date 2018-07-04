package ex0160;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力された0～5の範囲のふたつの数字をもとに、占い結果を出力します
 *
 * @author 小金井 広輝
 */
public class Ex0160 {
	public static void main(String[] args) {

		//占い結果一覧
		final String FORTUNE[][] = {
				{ "吉", "吉", "凶", "凶", "凶", "吉" },
				{ "吉", "吉", "凶", "吉", "凶", "吉" },
				{ "凶", "凶", "吉", "吉", "吉", "吉" },
				{ "凶", "吉", "吉", "吉", "凶", "凶" },
				{ "凶", "凶", "凶", "吉", "吉", "凶" },
				{ "凶", "吉", "吉", "凶", "凶", "凶" } };

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int inputInt1;
		int inputInt2;

		//キーボードから入力された数字を取得します
		try {
			System.out.println("ひとつ目の数字（0～5）:");
			inputInt1 = scanner.nextInt();
			System.out.println("ふたつ目の数字（0～5）:");
			inputInt2 = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}
		//入力された数字のエラーチェックを行い、正しく入力されていたら
		//占い判定を行います
		if (stringErrorCheck(inputInt1, inputInt2)) {
			//占い結果を取得します
			String ans = fortuneJudgment(inputInt1, inputInt2, FORTUNE);
			//結果を表示します
			System.out.println(ans);
		}
	}

	/**
	 * 入力された数字が占いのできる数字かの判定
	 *
	 * @param inputInt1 ひとつ目の入力された数字
	 * @param inputInt2 ふたつ目の入力された数字
	 * @return 正しく入力されているかの真偽
	 */
	public static boolean stringErrorCheck(int inputInt1, int inputInt2) {
		if (inputInt1 < 0 || inputInt2 < 0 || inputInt1 > 5 || inputInt2 > 5) {
			//入力された数字が0～5以外の場合
			System.out.println("範囲内（0～5）の数字を入力してください");
			return false;
		}
		//正しく入力されている場合
		return true;
	}

	/**
	 * 入力された数字に従い、占い判定を行います。
	 *
	 * @param inputInt1 ひとつ目の入力された数字
	 * @param inputInt2 ふたつ目の入力された数字
	 * @param fortune 占い結果一覧
	 * @return 占い結果の詳細
	 */
	public static String fortuneJudgment(int inputInt1, int inputInt2, String[][] fortune) {
		return "占いの結果は" + fortune[inputInt1][inputInt2] + "です";
	}
}
