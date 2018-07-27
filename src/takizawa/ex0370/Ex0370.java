package takizawa.ex0370;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * コマンドライン引数から入力した正解値を当てる
 * ヒット&ブローゲームをします
 *
 * @author 瀧澤
 */
public class Ex0370 {
	public static void main(String[] args) {

		// コマンドライン引数が未入力の場合
		if (args.length == 0) {
			System.out.println("コマンドラインから正解値を入力してください");
			return;
		}

		/** ゲームの回数 */
		int count = 0;
		/** 正解の数値 */
		String rightNumber = args[0];
		/** 入力可能桁数上限 */
		final int MAX_NUMBER = 4;
		/** ゲームを終了するか */
		boolean isGameSet = false;

		Pattern p1 = Pattern.compile("[^0-9]");
		Matcher m1 = p1.matcher(rightNumber);

		// コマンドライン引数で数字以外が与えられた場合
		if (m1.find() == true) {
			System.out.println("正解値には数字を使用してください");
			return;
		}

		// ゲームが終了するまで続けます
		while (!isGameSet) {
			String inputNumber = "";
			count++;
			System.out.print("(" + count + "回目) 予測数字を入力してください:");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			inputNumber = scanner.nextLine();

			// 入力値が999でならループを抜けます
			if (giveUp(inputNumber, rightNumber)) {
				break;
			}

			// 999でもなく4桁でもなかったら再度入力させます
			if (inputNumber.length() != MAX_NUMBER) {
				System.out.println("入力する場合は4桁\nパスする場合は999を入力してください\n");
				continue;
			}

			// 予測値が未入力の場合
			if (inputNumber == null || inputNumber.isEmpty()) {
				System.out.println("予測値が未入力です\n");
				continue;
			}

			Pattern p2 = Pattern.compile("[^0-9]");
			Matcher m2 = p2.matcher(inputNumber);

			// 数字以外が見つかったら再度入力させます
			if (m2.find() == true) {
				System.out.println("文字が含まれています\n");
				continue;
			}

			/** ヒット数 */
			int hitCount = 0;
			/** ブロー数 */
			int blowCount = 0;
			for (int i = 0; i < rightNumber.length(); i++) {

				// 位置と数字が一致していた場合
				if (inputNumber.charAt(i) == rightNumber.charAt(i)) {
					hitCount++;
				}

				// 入力値に正解値が含まれていた場合
				if (inputNumber.indexOf(rightNumber.charAt(i)) != -1) {
					blowCount++;
				}
			}
			System.out.println("ヒット:" + hitCount + "  ブロー:" + (blowCount - hitCount));

			// ヒット数が4で正解の時
			if (hitCount == 4) {
				isGameSet = true;
				System.out.println("おめでとう！大正解です！");
				break;
			}
		}
	}

	/**
	 * 999を入力してギブアップをします
	 *
	 * @param inputNumber 予測値
	 * @param rightNumber 正解値
	 * @return isGiveUp   ギブアップか
	 */
	public static boolean giveUp(String inputNumber, String rightNumber) {
		boolean isGiveUp = false;
		if (inputNumber.length() != 3) {
			return isGiveUp;
		}
		if (inputNumber.equals("999")) {
			isGiveUp = true;
			System.out.println("正解は" + rightNumber + "でした。");
		}
		return isGiveUp;
	}
}