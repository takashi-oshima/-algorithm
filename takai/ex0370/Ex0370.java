package takai.ex0370;

import java.util.Scanner;

/**
 * コマンドライン引数として正解の4桁の数値を与え、ヒット＆ブローを行うクラスです。
 * 999と入力しギブアップするか、正解を入力するまで続きます。
 *
 * @author 高井勇輝
 *
 */
public class Ex0370 {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		/** 正解の文字列 */
		String answerTxt = args[0];
		/** 入力した文字列 */
		String inputTxt;
		/** 文字列の長さ */
		final int NUMBERS_LENGTH = 4;
		/** ゲームが終わったか */
		boolean gameFinish = false;

		//正解の桁数確認
		if (answerTxt.length() != NUMBERS_LENGTH) {
			System.out.println("答えが不正です。4桁の数字にしてください。");
			return;
		}

		//コマンドライン引数が数字かの確認
		if (!isIntTxt(answerTxt)) {
			System.out.println("不適な文字列です。正数を入力してください。");
			return;
		}

		int count = 1;
		while (!gameFinish) {
			//キーボードから入力値を取得
			Scanner scan = new Scanner(System.in);
			//入力値を代入します。
			System.out.print("(" + count + "回目) 予測数字を入力してください:");
			inputTxt = scan.nextLine();
			count++;

			//NULL・空文字チェック
			if (inputTxt == null || inputTxt.isEmpty()) {
				System.out.println("文字列が空白、もしくはnull値になっています。\r\n");
				continue;
			}

			//入力値が数字かの確認
			if (!isIntTxt(inputTxt)) {
				System.out.println("不適な文字列です。正数を入力してください。\r\n");
				continue;
			}

			//ギブアップ
			if (isGiveUp(inputTxt)) {
				System.out.println("正解は" + answerTxt + "でした。");
				return;
			}

			//入力値の桁数確認
			if (inputTxt.length() != NUMBERS_LENGTH) {
				System.out.println("答えが不正です。4桁の数字にしてください。\r\n");
				continue;
			}

			/** ヒットカウント */
			int hit = 0;
			/** ブローカウント */
			int blow = 0;
			for (int i = 0; i < answerTxt.length(); i++) {
				//入力値のi番と正解のi番が等しければ
				if (inputTxt.charAt(i) == answerTxt.charAt(i)) {
					hit++;
				}

				//正解に入力値のi番目があれば
				if (answerTxt.indexOf(inputTxt.charAt(i)) != -1) {
					blow++;
				}
			}
			System.out.println("ヒット:" + hit + " ブロー:" + (blow - hit) + "\r\n");

			if (hit == 4) {
				break;
			}
		}
		System.out.println("正解です。");
	}

	/**
	 * ギブアップかどうかを判定して返します
	 *
	 * @param inputTxt 入力値
	 * @return isGiveUp ギブアップかどうか
	 */
	private static boolean isGiveUp(String inputTxt) {
		boolean isGiveUp = false;
		if (inputTxt.length() != 3) {
			return isGiveUp;
		}

		if ("999".equals(inputTxt)) {
			isGiveUp = true;
		}
		return isGiveUp;
	}

	/**
	 * 与えられた文字列が数字かを判定して返します。
	 *
	 * @param str 文字列
	 * @return isInt 数字かどうか
	 */
	private static boolean isIntTxt(String str) {
		boolean isInt = false;
		int i = 0;
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return isInt;
		}
		if(0 < i) {
			isInt = true;
		}
		return isInt;
	}
}