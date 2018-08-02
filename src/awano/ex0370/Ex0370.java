package awano.ex0370;

import java.util.Scanner;

/**
 * 起動時引数として正解の4桁の数字を与え、
 * 正解を入力するまで予想数字の入力と当たり判定の結果を出力し続けます。
 * 999を入力するとギブアップします。
 *
 * @author 粟野真司
 */
public class Ex0370 {
	/**正解の値*/
	public static String answer = "";
	/**入力された文字列*/
	public static String inputNum = "";
	/**何回目の入力かのカウンタ変数*/
	public static int count = 1;
	/**入力された文字列を格納する配列*/
	public static char[] input = {};
	/**正解を格納する配列*/
	public static char[] number = {};
	/**ギブアップする場合の入力値*/
	public static final String GIVE_UP = "999";

	public static void main(String[] args) {
		//正解が空の場合
		if (args.length == 0) {
			System.out.println("正解が空です。コマンドライン引数を設定してください。");
			return;
			//正解が半角数値4桁の場合
		} else if (args[0].matches("^\\d{4}$")) {
			answer = args[0];
		} else {
			System.out.println("正解を半角数値4桁で設定してください。");
			return;
		}
		//予測数字が正解、もしくはギブアップするまでwhile文を回します
		while (true) {
			checkInput();
			count++;

			if (inputNum.equals(GIVE_UP)) {
				System.out.println("正解は" + answer + "でした。");
				break;
			}
			if (!inputNum.matches("^\\d{4}$")) {
				System.out.println("4桁の半角数字を入力するか、999でギブアップしてください。");
				continue;
			}

			if (inputNum.equals(answer)) {
				System.out.println("予測数字:" + inputNum + " " + "==>正解です");
				break;
			}
			countMatch();
			continue;
		}
	}

	/**
	 * 入力された文字列によって配列に格納するか判断します。
	 */
	public static void checkInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("(" + count + "回目) 予測数字を入力してください:");
		inputNum = scanner.nextLine();
		//入力された文字列をchar型の配列に変換し、格納します
		input = inputNum.toCharArray();
		number = answer.toCharArray();
	}

	/**
	 * 正解と配列型にした文字列を比較し、
	 * ヒット(位置も数字も一致している数)、
	 * ブロー(位置は一致していないが、数字が一致している数)をカウントします。
	 */
	public static void countMatch() {
		int hit = 0;
		int blow = 0;

		//ヒット数をカウントします
		for (int i = 0; i < number.length; i++) {
			if (input[i] == number[i]) {
				hit++;
			}
		}

		//ブロー数をカウントします
		for (int i = 0; i < number.length; i++) {
			if (inputNum.indexOf(number[i]) != -1) {
				blow++;
			}
		}
		System.out.println("ヒット:" + hit + "  " + "ブロー:" + (blow - hit));
	}
}