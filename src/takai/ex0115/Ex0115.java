package takai.ex0115;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 文字列を取得し、半角空白ごとに単語に分解。
 * 分解後に単語を奇数番目と偶数番目で結合して出力するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0115 {

	public static void main(String[] args) {
		/** 入力された文字列 */
		String inputTxt = "";
		/** 偶数番目配列 */
		List<String> evenNumber = new ArrayList<>();
		/** 奇数番目配列 */
		List<String> oddNumber = new ArrayList<>();

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		//入力値を代入します。
		inputTxt = scan.nextLine();

		//NULL・空文字チェック
		if (inputTxt == null || inputTxt.isEmpty()) {
			System.out.println("文字列が空白、もしくはnull値になっています");
			return;
		}

		//空白ごとに文字列を配列に要素として格納し、空白を削除します。
		String[] outputTxt = inputTxt.split("[\\s]+");

		//配列を偶数番目と奇数番目で、それぞれ格納します。
		for (int i = 0; i < outputTxt.length; i++) {
			if (i % 2 == 1) {
				evenNumber.add(outputTxt[i]);
			} else if (i % 2 == 0) {
				oddNumber.add(outputTxt[i]);
			}
		}

		//配列を偶数番目と奇数番目で、それぞれ出力します。
		//この時、配列は0スタートですが、文字列が1スタートのため、
		//それぞれ奇数番目に偶数配列を、偶数番目に奇数配列を出力します。
		System.out.print("奇数番目：");
		for (String oddString : oddNumber) {
			System.out.print(oddString + " ");
		}
		System.out.print("\r\n偶数番目：");
		for (String evenString : evenNumber) {
			System.out.print(evenString + " ");
		}
	}
}