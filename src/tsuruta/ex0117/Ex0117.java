package tsuruta.ex0117;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 実行用のクラスになります。
 * 英語の試験の点数e-score、数学の試験の点数m_scoreを入力します。
 * 両方の点数が80点以上の場合、「進級」と表示します。
 * 点数どちらかが80点を下回る場合、「再試験」と表示します。
 * 両方の点数とも80点を下回る場合、「留年」と表示します。
 *
 * @author 鶴田竜也
 */
public class Ex0117 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("文字列：");
		System.out.println("input english score:");
		// englishScoreに整数を読み込みます

		int mathScore = 0, englishScore = 0;
		try {
			englishScore = scan.nextInt();
			//mathScore2に整数を読み込む
			System.out.println("inout math score:");
			mathScore = scan.nextInt();
			// 不正な値が含まれているかチェックします
		} catch (InputMismatchException e) {
			System.out.println("数字以外を入力しないでください");
		}

		//不正な値が含まれているかチェックします
		if (englishScore < 0 || englishScore > 100 || mathScore < 0 || mathScore > 100) {
			System.out.println("マイナスの値もしくは100以上の不正な値が入っています。");
		}
		// 入力された点数によって出力を変えます
		else if (englishScore >= 80 && mathScore >= 80) {
			System.out.println("進級");
		} else if (englishScore < 80 && mathScore < 80) {
			System.out.println("留年");
		} else {
			System.out.println("再試験");
		}
	}
}