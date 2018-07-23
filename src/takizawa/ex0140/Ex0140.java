package takizawa.ex0140;

import java.util.Scanner;

/**
 * 2つの整数値とコマンドを入力して
 * 計算結果を出力します
 *
 * @author 瀧澤
 */
public class Ex0140 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number1:");
		//number1に整数を読み込む
		int number1 = scanner.nextInt();
		System.out.println("input number2:");
		//number2に整数を読み込む
		long number2 = scanner.nextInt();
		System.out.println("input command:");
		//commandに整数を読み込む
		int command = scanner.nextInt();

		System.out.print("\r\n計算結果 =");
		switch (command) {
		//commandが0だった場合加算します
		case 0:
			System.out.print(number1 + number2);
			break;
		//commandが1だった場合減算します
		case 1:
			System.out.print(number1 - number2);
			break;
		//commandが2だった場合乗算します
		case 2:
			System.out.print(number1 * number2);
			break;
		//commandがそれ以外の数字だった場合除算します
		default:
			System.out.print(number1 / number2);
		}
	}
}