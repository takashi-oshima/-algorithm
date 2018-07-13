package exAdInput;

import java.util.Scanner;

/**
 * キーボードからの入力を受け取れるようにするクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Input {

	public String[] scan() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String[] inputTxt = scan.nextLine().split(" ");

		return inputTxt;
	}
}