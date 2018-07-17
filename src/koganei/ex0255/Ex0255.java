package koganei.ex0255;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * キーボードから「月の始まりの曜日の番号」と「月末の日の数字」を入力し、
 * カレンダーを出力します。
 *
 * @author 小金井 広輝
 */
public class Ex0255 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int monthStart;
		int monthEnd;

		//キーボードから入力された整数を取得します。
		try {
			System.out.println("月の始まりの曜日(0～6)を数字で入力してください：");
			System.out.println("日曜: 0 月曜: 1 火曜: 2 水曜: 3 木曜: 4 金曜: 5 土曜: 6");
			monthStart = scanner.nextInt();
			System.out.println("月末の日(28～31)を数字で入力してください：");
			monthEnd = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//入力された数字が範囲内かの判別を行います
		if (monthStart < 0 || monthStart > 6) {
			System.out.println("月の始まり -- 範囲内(0～6)の数値を入力してください");
			return;
		}
		if (monthEnd < 28 || monthEnd > 31) {
			System.out.println("月末の日 -- 範囲内(28～31)の数値を入力してください");
			return;
		}

		//月の始まり前の空白から月末までの日付を配列に入れていきます
		List<String> dayList = new ArrayList<>();
		for (int i = 0; i < monthStart; i++) {
			dayList.add("  ");
		}
		for (int day = 1; day <= monthEnd; day++) {
			dayList.add(String.format("%02d", day));
		}

		//カレンダーを表示します
		System.out.println("日 月 火 水 木 金 土");
		System.out.println("--------------------");
		for (int i = 0; i < dayList.size(); i++) {
			System.out.print(dayList.get(i) + " ");
			if ((i + 1) % 7 == 0 && i + 1 != dayList.size()) {
				System.out.println("\n");
			}
		}
		System.out.println("\n--------------------");
	}
}
