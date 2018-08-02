package takizawa.exAdInput;

import java.util.Scanner;

/**
 * アドバンス課題で使うinput
 *
 * @author 瀧澤
 */
public class Input {
	public String[] string() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String[] str = scanner.nextLine().split(" ");

		return str;
	}
}