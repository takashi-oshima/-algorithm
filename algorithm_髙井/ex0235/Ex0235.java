package ex0235;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 入力された10進数の値を2進数と16進数に変換するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0235 {

	public static void main(String[] args) {
		/** 1つ目の文字列 */
		int inputNumber = 0;
		/** 2進数に変換するための入力文字格納場所 */
		int binaryNumberConverting = 0;
		/** 16進数に変換するための入力文字格納場所 */
		int hexNumberConverting = 0;
		/** 2進数に変換した文字列の格納用 */
		String binaryNumber = "";
		/** 2進数に変換した文字列の格納用 */
		String hexNumber = "";
		/** 2進数から16進数への判定切り替え用 */
		boolean decisionSwitching = false;

		//キーボードから入力値を取得できるようにします。
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		try {
			//入力値を代入します。
			System.out.println("input number：");
			inputNumber = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("不適な文字列です。整数を入力してください。");
			return;
		}
		if (inputNumber < 0 || inputNumber > 255) {
			System.out.println("不適な数値です。0～255の間で入力してください");
			return;
		}

		//入力された数値をそれぞれの変換用変数に格納します。
		binaryNumberConverting = inputNumber;
		hexNumberConverting = inputNumber;
		do {
			//2進数への変換を行います。
			binaryNumber = decimalConversion(binaryNumberConverting, decisionSwitching) + binaryNumber;
			binaryNumberConverting = binaryNumberConverting / 2;
		} while (binaryNumberConverting > 0);
		//変換を2進数から16進数に切り替えます。
		decisionSwitching = true;
		do {
			//16進数への変換を行います。
			hexNumber = decimalConversion(hexNumberConverting, decisionSwitching) + hexNumber;
			hexNumberConverting = hexNumberConverting / 16;
		} while (hexNumberConverting > 0);
		System.out.println("2進数：" + String.format("%08d", Integer.parseInt(binaryNumber)));
		System.out.println("16進数：" + hexNumber);
	}

	/**
	 * 10進数をn進数に変換する処理を行います。
	 *
	 * @param decimalNumber 入力された数値
	 * @param decisionSwitching n進数の判定
	 * @return 変換の文字列
	 */
	public static String decimalConversion(int decimalNumber, boolean decisionSwitching) {
		int divisor = 0;
		String assignmentChar = "";

		if (decisionSwitching == false) {
			divisor = 2;
		} else if (decisionSwitching == true) {
			divisor = 16;
		} else {
			return "変換する進数値が不正です。";
		}

		switch (decimalNumber % divisor) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			assignmentChar = Integer.toString(decimalNumber % divisor);
			break;
		case 10:
			assignmentChar = "A";
			break;
		case 11:
			assignmentChar = "B";
			break;
		case 12:
			assignmentChar = "C";
			break;
		case 13:
			assignmentChar = "D";
			break;
		case 14:
			assignmentChar = "E";
			break;
		case 15:
			assignmentChar = "F";
			break;
		default:
			return "変換する進数値が不正です。";
		}
		return assignmentChar;
	}
}