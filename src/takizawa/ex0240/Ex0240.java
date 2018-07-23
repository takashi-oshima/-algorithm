package takizawa.ex0240;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 2桁の数字を入力すると、九九の表に値があるか
 * どうかを出力します
 *
 * @author 瀧澤
 */
public class Ex0240 {

	public static void main(String[] args) {
		int number = 0;
		boolean flag = false;

		//入力処理の用意
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input number:");

		try {
			number = scanner.nextInt();

			// エラー文の表示等
			if (number < 0) {
				System.out.println("\r\n負数が入力されました\n"
						+ "処理を終了します");
				return;
			}else if(0 <= number && number < 10 || number >= 100) {
				System.out.println("\r\n範囲外の数値が入力されました\n"
					+ "処理を終了します");
				return;
			}
		} catch (InputMismatchException e) {
			System.out.println("\r\n数値以外が入力されました\n"
					+ "処理を終了します");
			return;
		}

		// 九九の表を辿っていき、もし入力した値と
		// 九九が一致した時、flagをtrueにして結果を表示させる
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (number == i * j) {
					flag = true;
					System.out.println("\r\n九九の表"
							+ "（" + i + "*" + j + "）にあります");
				}
			}
		}

		// 九九の表から入力した値が見つからなかった時の表示
		if (flag == false) {
				System.out.println("\r\n九九の表にありません");
				return;
		}
	}
}