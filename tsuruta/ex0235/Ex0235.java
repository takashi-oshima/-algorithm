package tsuruta.ex0235;

import java.util.Scanner;

/**
 * キーボードから入力された0～255までの数字を2進数、16進数にそれぞれ変換し出力します
 *
 * @author 鶴田竜也
 */
public class Ex0235 {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("0～255の範囲の10進数");
		int inputNumber = scan.nextInt();

		//2進数に変換します
		String binary = Integer.toBinaryString(inputNumber);
		//2進数をInteger型に変換し、iに代入します
		int i = Integer.parseInt(binary);
		//2進数が8ケタまで出るようにします
		binary = String.format("%08d", i);

		//16進数に変換します
		String hex = Integer.toHexString(inputNumber);
		//0～255までの入力を受け付けるためのチェックです。
		if (inputNumber >= 0 && inputNumber < 256) {
			System.out.println("2進数の変換結果:" + binary);
			System.out.println("16進数の変換結果：" + hex);
		} else if (inputNumber > 0 || inputNumber < 256) {
			System.out.println("エラー：不正な値です");
		}
	}
}