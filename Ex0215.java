package ex0215;

import java.util.Scanner;

/**
 * キーボードから複数の数字を入力し、足して10になる2つの数値をペアとして出力します
 *
 * @author 鶴田竜也
 */
public class Ex0215 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("input number：");
		String inputString = scan.nextLine();

		// 半角空白2つ以上を半角空白1つに置き換えます
		inputString = inputString.replaceAll(" {2,}", " ");

		// キーボード入力された文字列を半角空白1つ毎に分割し、配列に格納します
		String[] numList = inputString.split(" ");

		// numLIst.lengthをint配列に代入します
		int[] number = new int[numList.length];

		for (int i = 0; i < numList.length; i++) {
			// 文字列numListの要素をInteger型に変換し、numberに代入する
			number[i] = Integer.parseInt(numList[i]);
		}

		int ten = 0;
		// iが0の時、jは一つ右の1を見ていく、これの繰り返しになります
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = i + 1; j < number.length; j++) {
				if (number[i] + number[j] == 10) {
					ten = number[i] + number[j];
					System.out.print(number[i] + "と" + number[j] + "、");
				}
			}
		}
		//上のfor文でten==10のペアが存在した場合
		if (ten == 10) {
			System.out.print("は足して10となるペアです");
		} else {
			System.out.println("ペアとなる数字はありません");
		}
	}
}