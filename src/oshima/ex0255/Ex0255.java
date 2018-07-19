package oshima.ex0255;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから「月の始まりの曜日の番号」と「月末の日の数字」を入力し、カレンダーを出力します。
 *
 * @author 大島
 */
public class Ex0255 {

	public static void main(String[] args) {
		// 入力した整数を格納する配列です。
		int[] inputNumbers = new int[2];

		// キーボード入力を受け付け、入力内容を配列に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("月の始まりの曜日を数字で入力してください：");
			inputNumbers[0] = scanner.nextInt();
			System.out.println("月末の日を数字で入力してください：");
			inputNumbers[1] = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}
		// 入力の範囲をチェックします。
		if (inputNumbers[0] < 0 || inputNumbers[0] > 6 || inputNumbers[1] <= 27 || inputNumbers[1] >= 32) {
			System.out.println("入力値が正しい範囲ではありません。");
			return;
		}

		int monthStartDay = inputNumbers[0];
		int monthEndDate = inputNumbers[1];

		// カレンダーを出力します。
		System.out.println("\r\n日   月   火   水  木   金   土");
		System.out.println("---------------------");
		int day = 0;
		for (int rowCalendar = 0; rowCalendar < 6; rowCalendar++) {
			for (int colCalendar = 0; colCalendar < 7; colCalendar++) {
				// 01日が何曜かによって1行目をずらす処理
				if (colCalendar - 1 < monthStartDay - 1 && rowCalendar == 0) {
					System.out.print("   ");
				} else if (day < monthEndDate) {
					day++;
					// 日付表示
					System.out.print(String.format("%02d", day) + " ");
				}
			}
			// 改行を月末の日の数字以上は行わない
			if (day < monthEndDate) {
				System.out.print("\r\n");
			}
		}
		System.out.println("\r\n---------------------");
	}
}