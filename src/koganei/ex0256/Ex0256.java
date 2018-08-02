package koganei.ex0256;

import java.util.Scanner;

/**
 * キーボードから入力された文字列を取得し、その文字列が指定した日付形式か否か出力します
 * 日付形式は「YYYY/MM/DD」とします
 *
 * @author 小金井 広輝
 */
public class Ex0256 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);

		//キーボードから入力された整数を取得します。
		System.out.println("input date：");
		String date = scanner.nextLine();

		//日付形式で入力されているかチェックします
		boolean dateCheck = true;
		if (date.matches(".*[0-9]{4}/[0-1]{1}[0-9]{1}/[0-3]{1}[0-9]{1}.*")) {
			String month = date.substring(5, 7);
			String day = date.substring(8);
			//月の値が範囲内（1～12）かの判別
			int monthInt = Integer.parseInt(month);
			if (monthInt < 1 || monthInt > 12) {
				dateCheck = false;
			}
			//日付の値が範囲内（1～31）かの判別
			int dateInt = Integer.parseInt(day);
			if (dateInt < 1 || dateInt > 31) {
				dateCheck = false;
			}
		} else {
			//「○○○○/○○/○○」の形式で入力されていない場合
			dateCheck = false;
		}

		//判定に応じて結果を表示します
		if (dateCheck) {
			System.out.println("指定した形式です");
		} else {
			System.out.println("指定した形式ではありません");
		}
	}
}
