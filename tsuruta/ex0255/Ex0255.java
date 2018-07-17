package tsuruta.ex0255;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから「月の始まりの曜日の番号と「月末の日の数字」を入力し、カレンダーを出力します
 * 「月の始まりの曜日の番号」は、
 * 「日曜：0 月曜：1 火曜：2 水曜：3 木曜：4 金曜：5 土曜：6」となります
 *
 * @author 鶴田竜也
 */
public class Ex0255 {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int beginning_date, end_date;

		try {
			//キーボードから入力された整数を取得します
			System.out.println("月の始まりの曜日を数字で入力してください：");
			beginning_date = scan.nextInt();
			System.out.println("月末の日を数字で入力してください");
			end_date = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		// 不正な値のチェックをします
		if (beginning_date < 0 || beginning_date > 6) {
			System.out.println("月の始まりの数字が不正な値です");
			return;
		}

		String[] weekday = { "日", "月", "火", "水", "木", "金", "土" };

		// 曜日を出力します
		for (int i = 0; i < weekday.length; i++) {
			System.out.print(" " + weekday[i] + "  ");
		}
		System.out.print("\n---------------------\n");

		// beginning_dateの入力分の空白を出力します
		for (int i = 0; i < beginning_date; i++) {
			System.out.print("   ");
		}

		// 月の始まりから月末までの日数を繰り返します
		for (int k = 1; k <= end_date; k++) {
			// 1桁数字の前に0を付けます
			if (k < 10) {
				System.out.print("0");
			}
			System.out.print(k + " ");

			// 月始まりの曜日の数字と土曜日の日付を足して7で割り切れた時に改行します
			if ((beginning_date + k) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.print("\n---------------------\n");
	}
}