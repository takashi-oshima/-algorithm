package ex0256;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 文字列を入力し、日付形式「yyyy/MM/dd」と一致してるかを
 * 求めます
 *
 * @author 瀧澤
 */
public class Ex0256 {
	public static void main(String[] args) {
		String inputDate = "";

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input date:");
		inputDate = scanner.nextLine();
		if (inputDate == null || inputDate.isEmpty()) {
			System.out.println("\r\n文字列が確認できませんでした\n処理を終了します");
		}

		// SimpleDateFormatのsdf変数にyyyy/MM/dd形式を格納
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// 日付の妥当性チェック
		sdf.setLenient(false);
		try {
			String date = sdf.format(sdf.parse(inputDate));

			if(inputDate.equals(date)) {
				System.out.println("\r\n指定した形式です");
			}else {
				System.out.println("\r\n指定した形式ではありません");
			}
		} catch (ParseException e) {
			System.out.println("\r\n日付として認識できない文字が含まれています");
			return;
		}
	}
}