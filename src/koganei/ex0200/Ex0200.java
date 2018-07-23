package koganei.ex0200;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力された整数nを取得し、１からnまでの和を求め、結果を出力します
 *
 * @author 小金井 広輝
 */
public class Ex0200 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int n;

		//キーボードから入力された整数を取得します。
		System.out.println("input number：");
		try {
			n = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//正数かの判定を行います
		if (n < 0) {
			System.out.println("正数を入力してください");
			return;
		}

		//1から入力された整数値までの和を求め、結果を表示します
		int total = 0;
		for (int i = 1; i <= n; i++) {
			total = total + i;
		}
		System.out.println("合計値＝" + total);
	}
}
