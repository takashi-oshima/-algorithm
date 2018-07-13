package ex0256;

import java.util.Scanner;

/**
 * キーボードから文字列を入力し、その文字列が指定した日付形式か否か出力します。
 * 日付形式は「YYYY/MM/DD」とします。
 *
 * @author 大島
 */
public class Ex0256 {

	public static void main(String[] args) {
		// 入力した文字列を格納する変数です。
		String inputDate = "";

		// キーボード入力を受け付け、入力内容を変数に格納します。
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input date：");
		inputDate = scanner.nextLine();

		// nullと空文字チェックします。
		if (inputDate == null || inputDate.isEmpty()) {
			System.out.println("文字列がnullまたは空文字です。");
			return;
		}
		// 形式を指定し、指定通りの形式で入力されているかどうかで表示文を変更します。
		boolean flag = inputDate.matches(".*[0-9]{4}/[0-1]{1}[0-9]{1}/[0-3]{1}[0-9]{1}.*");
		if (flag == true) {
			System.out.println("指定した形式です。");
		} else {
			System.out.println("指定した形式ではありません。");
		}
	}
}