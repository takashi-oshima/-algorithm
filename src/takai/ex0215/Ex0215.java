package takai.ex0215;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 入力された文字列から10になる数値のペアを表示するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0215 {

	public static void main(String[] args) {
		/** 入力された文字列 */
		String inputTxt = "";
		/** 出力用の文字列の格納用 */
		List<String> outputTxt = new ArrayList<>();
		/** 出力用のListに格納するための一時格納用 */
		List<Integer> outputNumber = new ArrayList<>();

		//キーボードから入力値を取得できるようにして、入力値を代入します。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("input number:");
		inputTxt = scan.nextLine();
		//NULL・空文字チェック
		if (inputTxt == null || inputTxt.isEmpty()) {
			System.out.println("文字列が空白、もしくはnull値になっています");
			return;
		}

		//空白をごとに文字列を配列に要素として格納し、空白を削除します。
		String[] inputNumber = inputTxt.split("[\\s]+");
		//String型の配列をInteger型のListに格納します。
		try {
			for (String number : inputNumber) {
				outputNumber.add(Integer.parseInt(number));
			}
		} catch (NumberFormatException e) {
			System.out.println("不適な文字列です。整数を入力してください。");
			return;
		}

		//足して10になるペアがあればListに格納します。
		for (int i = 0; i < outputNumber.size() - 1; i++) {
			for (int j = i + 1; j < outputNumber.size(); j++) {
				int sum = 0;
				sum = outputNumber.get(i) + outputNumber.get(j);
				if (sum == 10) {
					outputTxt.add(outputNumber.get(i) + "と" + outputNumber.get(j));
				}
			}
		}

		if (outputTxt.size() == 0) {
			System.out.println("ペアとなる数字はありません");
			return;
		}

		//対象が複数件あった時に表示するためのループです。
		for (String result : outputTxt) {
			System.out.print(result + "、");
		}
		System.out.println("は足して10となるペアです");
	}
}