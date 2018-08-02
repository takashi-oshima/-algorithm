package ex0370;

import java.util.Scanner;

/**
 * 起動時引数として正解の4桁の重複しない数字列を与えます
 * 「999」を入力してギブアップするか、正解を入力するまで
 * 予想数字の入力とあたり判定の入力結果を出力し続けます
 *
 * ヒット：位置も数字も一致している数
 * ブロー：位置は一致していないが、数字が一致している数
 *
 * @author 鶴田竜也
 */
public class Ex0370 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		final String GIVEUP = "999";
		// 入力回数をカウントします
		int inputCnt = 0;
		String inputNumber = "";

		// 起動時引数の確認
		if (args.equals(null) || args[0].length() != 4) {
			System.out.println("エラー：コマンドライン引数に半角数字4桁を設定してください。");
			return;
		}

		String answer = args[0];

		System.out.println("数当てゲームを開始します。4ケタの数字を入力してください「");

		// 正解の数字もしくは999(ギブアップ)が入力されるまで繰り返します
		while (!inputNumber.equals(answer)) {
			inputCnt++;
			System.out.println("(" + inputCnt + "回目) 予測数字を入力してください");

			Scanner scan = new Scanner(System.in);
			inputNumber = scan.nextLine();

			// ギブアップの場合、答えを表示して終了
			if (inputNumber.equals(GIVEUP)) {
				System.out.println("正解は" + answer + "でした");
				return;
			}

			// 入力数字が半角数字4桁以外の場合
			if (!isValidInput(inputNumber)) {
				System.out.println("入力形式が違います。4桁の半角数字を入力してください");
				continue;
			}
			// hit判定
			judgeHit(answer, inputNumber);
			// blow判定
			judgeBlow(answer, inputNumber);
		}
		System.out.println("正解！  正解は" + answer + "でした");
	}

	/**
	 * ヒットの判定を行います。ヒットがあればカウントします。
	 *
	 * @param answer 答えの数字(起動時引数)
	 * @param inputNumber 入力された数字
	 */
	public static void judgeHit(String answer, String inputNumber) {
		int hitCount = 0;

		// 引数と入力数字が一致すればヒット
		for (int i = 0; i < answer.length(); i++) {
			if (inputNumber.charAt(i) == answer.charAt(i)) {
				hitCount++;
			}
		}
		System.out.print("ヒット：" + hitCount + "  ");
	}

	/**
	 * ブローの判定を行います。ブローがあればカウントします。
	 *
	 * @param answer 答えの数字(起動時引数)
	 * @param inputNumber 入力された数字
	 */
	public static void judgeBlow(String answer, String inputNumber) {
		int blowCount = 0;

		for (int i = 0; i < answer.length(); i++) {

			if (inputNumber.charAt(i) != answer.charAt(i)) {
				if (answer.contains(String.valueOf(inputNumber.charAt(i))))
					blowCount++;
			}
		}
		System.out.println("ブロー：" + blowCount);
	}

	/**
	 * 入力形式の妥当性をチェックします。入力形式が正しければtrue、誤りであればfalseを返します
	 *
	 * @param inputNumber 入力された数字
	 * @return 入力形式の真偽
	 */
	public static boolean isValidInput(String inputNumber) {
		return inputNumber.matches("[0-9]{4}");
	}
}
