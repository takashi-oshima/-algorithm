package takizawa.exAdInput;

import java.util.Scanner;

/**
 * ExAd079C用に空白なし４桁の数字を文字列に格納させる
 *
 * @author 瀧澤
 */
public class Input2 {
	public String[] string() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String[] str = scanner.nextLine().split("");

		return str;
	}
}
