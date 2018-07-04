package ex0110;

import java.util.Scanner;

/**
 * キーボードから文字列の入力を受け付けます。
 * 入力された文字列は辞書順に並び替えられます。
 *
 * @author 鶴田竜也
 */
public class Ex0110 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner stdIn = new Scanner(System.in);
		System.out.println("文字列1：");
		// inputStr1に文字列を読み込みます
		String inputStr1 = stdIn.nextLine();
		System.out.println("文字列2：");
		// inputStr2に文字列を読み込みます
		String inputStr2 = stdIn.nextLine();

		// 空文字、nullチェックをします
		if (!inputStr1.isEmpty() && !inputStr2.isEmpty() && !inputStr1.equals(null) && !inputStr2.equals(null)) {
			// 2つの文字列を比較し辞書順に並び替えます
			int num = inputStr1.compareTo(inputStr2);
			if (num == 0) {
				//numが0の時はそのままの順で出力します
				System.out.println("2つの文字列は同じです  " + inputStr1);
			} else if (num < 0) {
				// 昇順で並び替えます
				System.out.println(inputStr1 + "  " + inputStr2);
			} else {
				// 降順で並び替えます
				System.out.println(inputStr2 + "  " + inputStr1);
			}
		} else {
			System.out.println("空文字もしくはnullです。文字列を入力してください");
		}
	}
}