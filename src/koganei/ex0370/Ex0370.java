package koganei.ex0370;

import java.util.Scanner;

/**
 * 起動時引数として正解の4桁の重複しない数字列を与える
 * 「999」を入力してギブアップするか、正解を入力するまで
 * 予想数字の入力とあたり判定の入力結果を出力し続ける
 *
 * ヒット：位置も数字も一致している数
 * ブロー：位置は一致していないが、数字が一致している数
 *
 * @author 小金井 広輝
 */
public class Ex0370 {

	/**
	 * InputPatternは入力値が何かを判定する 列挙型です。
	 *
	 * @author 小金井
	 */
	public enum InputPattern {
		InputOK, Error, GiveUp
	}

	//ギブアップするときの入力値を設定します
	public static final String GIVEUP_NUM = "999";
	//正解したときのヒット数を設定します
	public static final int ALLHIT = 4;
	//試行回数初期値を設定します
	public static final int START_COUNT = 1;

	public static void main(String[] args) {
		//起動時引数を代入するための変数です
		String answer = "";

		//起動時引数が正しく入力されているかの判定
		if (args.length == 1 && args[0].matches("[0-9]{4}")) {
			answer = args[0];
		} else {
			System.out.println("正解値が4桁の数字ではないまたは引数が一つではないです");
			return;
		}
		//試行回数初期値を設定します
		int count = START_COUNT;

		//正解を入力するまで予想数字の入力とあたり判定の入力結果を出力し続けます
		while (true) {
			System.out.print("（" + count + "回目）予測数字を入力してください：");
			//キーボードから入力値を取得できるようにします
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String inputNumber = scanner.nextLine();

			//入力された数値を判定しそれに応じて処理を行います
			switch (judgeInput(inputNumber)) {
			case GiveUp:
				System.out.println("正解は" + answer + "でした");
				return;
			case Error:
				System.out.println("読み込めません");
			case InputOK:
				if (judgeHitBlow(inputNumber, answer) == ALLHIT) {
					System.out.println("正解です");
					return;
				}
				count++;
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 入力された文字列の判定を行い結果を返します
	 *
	 * @param inputNumber 入力値
	 * @return 入力値の正否
	 */
	public static InputPattern judgeInput(String inputNumber) {
		if (inputNumber.equals(GIVEUP_NUM)) {
			return InputPattern.GiveUp;
		}
		if (!inputNumber.matches("[0-9]{4}")) {
			return InputPattern.Error;
		} else {
			return InputPattern.InputOK;
		}
	}

	/**
	 * ヒットとブローの判定を行い結果を表示した後、ヒット数を返します
	 *
	 * @param inputNumber 入力値
	 * @param answer 正解値
	 * @return ヒット数
	 */
	public static int judgeHitBlow(String inputNumber, String answer) {
		int hit = 0;
		int blow = 0;

		for (int i = 0; i < answer.length(); i++) {

			if (inputNumber.charAt(i) == answer.charAt(i)) {
				hit++;
			}
			if (inputNumber.charAt(i) != answer.charAt(i) && answer.indexOf(inputNumber.charAt(i)) != -1) {
				blow++;
			}
		}
		System.out.println("ヒット：" + hit + "  ブロー：" + blow);
		return hit;
	}
}