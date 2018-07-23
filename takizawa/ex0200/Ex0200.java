package takizawa.ex0200;

import java.util.Scanner;

/**
 * 1つの整数値nを入力して、1からnまでの和を求めます
 *
 * @author
 */
public class Ex0200 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number:");
		//numberに整数を読み込む
		int number = scanner.nextInt();
		int total = 0;
		//numberまでの和を先頭から求めるために通常forを使います
		for (int i = 0; i <= number; i++) {
			total += i;
		}
		System.out.println("\r\n合計値 =" + total);
	}

}