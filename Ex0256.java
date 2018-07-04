package ex0256;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * キーボードから文字列を入力し、その文字列が指定した形式か否か判断する
 * 日付形式は「YYYY/MM/DD」
 *
 * @author 鶴田竜也
 */
public class Ex0256 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println("input date");
		String inputDate = scan.nextLine();

		//空文字、nullチェック
		if (inputDate.isEmpty() || inputDate == null) {
			System.out.println("空文字またはnullが含まれています");
			return;
		}

		// SimpleDateFormatクラスを使用して、パターンを設定します
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		// 存在しない日付を入力したらParseExceptionの内容を出力します
		sdf.setLenient(false);

		try {
			sdf.parse(inputDate);
			System.out.println("正しい日付です");
		} catch (ParseException e) {
			//  Date型へ正しく変換できなかった場合
			System.out.println("正しい日付ではありません");
		}
	}
}