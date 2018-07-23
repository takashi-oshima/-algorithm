package takizawa.ex0255;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 月始まりの曜日と、月末の日の数字を入力すると
 * カレンダーを出力します。
 *
 * @author 瀧澤
 */
public class Ex0255 {

	public static void main(String[] args) {
		int weekday = 0;
		int endDate = 0;

		// 入力処理とエラー処理
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("月の始まりの曜日を数字で入力してください:\n日曜:0 月曜:1 火曜:2 水曜:3 木曜:4 金曜:5 土曜:6");
		try {
			weekday = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\r\n数字以外が入力されました\n処理を終了します");
			return;
		}
		System.out.println("月末の日を数字で入力してください:");
		endDate = scanner.nextInt();

		if (weekday < 0 || weekday > 6 || endDate < 28 || endDate > 31) {
			System.out.println("\r\n範囲外の数字が入力されました\n処理を終了します");
			return;
		}
		System.out.println("\r\n");
		// リストに、日曜日から月曜日までを入れています
		List<String> weekdayList = new ArrayList<>();
		Collections.addAll(weekdayList, "日", "月", "火", "水", "木", "金", "土");

		// weekdayListに入っている曜日を順番通りに表示します
		for (int i = 0; i < weekdayList.size(); i++) {
			System.out.print(weekdayList.get(i) + " ");
		}
		System.out.println("\n---------------------");
		// 始まりの曜日が日曜日以外の時に、空白を表示させます
		for (int j = 0; j < weekday; j++) {
			System.out.print("   ");
		}
		// 1日から月末の日までを表示します
		for (int k = 1; k <= endDate; k++) {

			// 10を下回る日数には数字の前に0を付けます
			if (k < 10) {
				System.out.print("0");
			}
			System.out.print(k + " ");

			// 始まりの曜日と日数を足した物が、改行させる必要のある
			// 土曜日の時点で、割った余りが0ならば改行をしてあげます
			if ((weekday + k) % weekdayList.size() == 0) {
				System.out.println();
			}
		}

		if (weekday == 0 && endDate == 28) {
			System.out.println("---------------------");
		} else {
			System.out.println("\n---------------------");
		}
	}
}