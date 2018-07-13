package algorithm.ex0255;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから「月の始まりの曜日の番号」と「月末の数字」を入力し、
 * カレンダーを出力します
 *
 * @author 粟野真司
 */
public class Ex0255 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		//入力ストリームを生成します
		Scanner scan = new Scanner(System.in);
		//入力された数字を格納する変数を宣言します
		int startWeekDay = 0;
		int endDate = 0;

		try {
			//入力フォームを表示します
			System.out.println("月始まりの曜日を数字で入力してください: ");
			startWeekDay = scan.nextInt();
			System.out.println("月末の日を数字で入力してください: ");
			endDate = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("文字列は不正な入力です。数字を入力してください。");
			return;
		}

		//月始まりの曜日の番号が正しく入力されているかどうか確認します
		if (startWeekDay < 0 || startWeekDay > 6) {
			System.out.println("月始まりの曜日の入力数字が範囲外です。");
			return;
		}

		//月末の日の数字が正しく入力されているかどうか確認します
		if (endDate < 0 || endDate > 31) {
			System.out.println("月末の日の入力数字が範囲外です。");
			return;
		}

		//曜日をString型の配列に格納します
		String[] weekDays = { "日", "月", "火", "水", "木", "金", "土" };

		//カレンダー上に曜日を表示します
		for (int i = 0; i < weekDays.length; i++) {
			System.out.print(weekDays[i] + " ");
		}
		System.out.println("\n--------------------");

		//カウンタ変数を宣言します
		int day = 1;
		int i;
		//1週目の日にちを表示します
		for (i = 0; i < startWeekDay; i++) {
			System.out.print("   ");
		}
		for (i = startWeekDay; i < 7; i++) {
			System.out.print("0" + day + " ");
			day++;
		}
		System.out.println();

		//2週目以降の日にちを表示します
		for (i = 0; day <= endDate; i++) {
			for (int j = 0; j < 7 && day <= endDate; j++) {
				if (day < 10)
					System.out.print("0" + day + " ");
				else
					System.out.print(day + " ");
				day++;
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
}