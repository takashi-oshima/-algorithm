package tsuruta.ex0200;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから1つの整数値をｎを入力し、1からｎまでの和を出力します。

 * @author 鶴田竜也
 */
public class Ex0200 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("input number");
		System.out.println("1からnまでの和を求めます");
		System.out.print("nの値：");

		int n = 0;
		try {
			n = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}
		//for文を抜けた後を変数sumを使用するためfor文の外に定義します
		int sum = 0;
		//1からnまでの和を求めます
		for (int i = 1; i <= n; i++) {
			//1からnまでの値をsumに値を代入していきます(合計値のアルゴリズム：課題0130参考)
			sum += i;
		}
		System.out.println("合計値 =" + sum);
	}
}