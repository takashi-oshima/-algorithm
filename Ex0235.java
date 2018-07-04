package algorithm;

import java.util.Scanner;

/**
 * キーボードに入力された0～255の範囲の10進数整数値を
 * 2進数と16進数に変換して出力します
 *
 * @author 粟野真司
 */
public class Ex0235 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		// 入力フォームを表示します
		System.out.println("0～255の範囲の10進数:");
		int number = scanner.nextInt();

		// 入力された数値が範囲内の数値か確認します
		if (number < 0 || number > 255) {
			System.out.println("範囲外の数値が入力されています");
			return;
		}

		// 入力された数値を2進数に変換します
		String binaryNum = Integer.toBinaryString(number);

		// Integer型に変換したものをiに代入します
		int i = Integer.parseInt(binaryNum);

		// 2進数の0埋めをします
		binaryNum = String.format("%08d", i);

		// 入力された数値を16進数に変換します
		String hex = Integer.toHexString(number);

		// 2進数、16進数への変換結果を出力します
		System.out.println("2進数の変数結果:" + binaryNum);
		System.out.println("16進数の変数結果:" + hex.toUpperCase());
	}
}