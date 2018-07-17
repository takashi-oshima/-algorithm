package oshima.ex0235;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * キーボードから入力された 0～255の範囲の10進数整数値を2進数と16進数に変換して出力します。
 *
 * @author 大島
 */
public class Ex0235 {

	public static void main(String[] args) {
		// 入力した整数を格納する変数です。
		int inputNumber = 0;
		// 16進数の数値を設定します。
		final char[] HEX_NUM = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		// キーボード入力を受け付け、入力内容を変数に格納します。
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("0～255 の範囲の 10 進数：");
			inputNumber = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("入力値が不正です。");
			return;
		}
		if (inputNumber < 0 || inputNumber > 255) {
			System.out.println("0~255の範囲ではありません。");
			return;
		}
		// コメントアウトしている行では、APIを使って処理を行っています。
		// String binaryApi = Integer.toBinaryString(inputNumber);
		// int binaryApi2 = Integer.parseInt(binaryApi);
		// String zeroBinaryApi = String.format("%08d", binaryApi2);
		// String hexApi = Integer.toHexString(inputNumber);
		// System.out.println("2 進数の変換結果： " + zeroBinaryApi + "\r\n16 進数の変換結果： " +
		// hexApi +
		// "\r\n");

		// 2進数の0埋め処理をします。
		int binary = Integer.parseInt(convertBinary(inputNumber));
		String zeroBinary = String.format("%08d", binary);

		System.out.println("2 進数の変換結果： " + zeroBinary);
		System.out.println("16 進数の変換結果： " + convertHex(inputNumber, HEX_NUM));
	}

	/**
	 * 2進数に変換するメソッドです。
	 *
	 * @param inputNumber 2進数に変換される整数
	 * @return 2進数に変換した結果
	 */
	public static String convertBinary(int inputNumber) {
		String result = "";
		// 繰り返し処理
		do {
			if (0 == (inputNumber % 2))
				result = "0" + result;
			else
				result = "1" + result;
			inputNumber = inputNumber / 2;
		} while (0 < inputNumber);
		return result;
	}

	/**
	 * 16進数に変換するメソッドです。
	 *
	 * @param inputNumber 16進数に変換される整数
	 * @param HEX_NUM 16進数で使われる数値
	 * @return 16進数に変換した結果
	 */
	public static String convertHex(int inputNumber, char[] HEX_NUM) {
		int hex = 0;
		String result = "";
		// 余りの計算
		hex = inputNumber % 16;
		// 商の計算
		inputNumber = inputNumber / 16;
		// 1けた目の数値の文字を代入
		result = Character.toString(HEX_NUM[hex]);
		// 商が0の時が16進数の計算が終了する時なのでループを脱出
		while (inputNumber != 0) {
			hex = inputNumber % 16;
			inputNumber = inputNumber / 16;
			// 2けた目以上の数値の文字を代入
			result = Character.toString(HEX_NUM[hex]) + result;
		}
		return result;
	}
}