package takizawa.exAdInput;

import java.util.Scanner;

/**
 * ExAd071B用に、配列に格納せずにString型として用意したinputクラス
 *
 * @author 瀧澤
 */
public class Input3 {
	public String string() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		return str;
	}
}
