package algorithm;

import java.util.Scanner;

/**
 * キーボードから2桁の数値を入力し、その数値が100以下の素数か
 * 判断し出力します
 * 数値が素数か否かの判断は、100以下の素数を要素に持つ配列の中から
 * 二分探索を使用して行います
 *
 * @author 粟野真司
 */
public class Ex0250 {
	public static void main(String[] args) {

		// 入力ストリームを生成します
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		// 入力された数値を格納する変数を宣言します
		String number = "";
		int inputNumber = 0;
		try {
			//入力フォームを表示します
			System.out.println("input number：");
			number = scanner.nextLine();
			// 変数numberをint型変数に変換します
			inputNumber = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			System.out.println("不正な入力です");
			return;
		}
		// 100以下の素数を持つ配列を生成します
		int[] primeNumber = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
				89, 97 };

		// 2桁の数値が正しく入力されているかの確認をします
		if (number.length() != 2) {
			System.out.println("2桁の数値を入力してください");
			return;
		}
		// 判定judgementを宣言します
		boolean judgement = false;
		// 探索範囲の先頭のIndexと末尾のIndexを設定します
		int firstIdx = 0;
		int endIdx = primeNumber.length - 1;

		// 二分探索を行います
		while (firstIdx <= endIdx) {
			// 中央要素のIndex
			int mid = (endIdx + firstIdx) / 2;
			// 探索成功を判断します
			if (primeNumber[mid] == inputNumber) {
				judgement = true;
				break;
			} else if (primeNumber[mid] > inputNumber) {
				// 探索範囲を前半に絞り込みます
				endIdx = mid - 1;
			} else {
				// 探索範囲を後半に絞り込みます
				firstIdx = mid + 1;
			}
		}

		// 素数であるかないかの結果を表示します
		if (judgement == true) {
			System.out.println("素数です");
		} else {
			System.out.println("素数ではありません");
		}
	}
}
