package algorithm;

import java.util.Scanner;

/**
 * 英語の試験と数学の試験の点数入力を受け取り、
 * 点数基準により、「進級」、「再試験」、「留年」を判定します
 *
 * @author 粟野真司
 */
public class Ex0117 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 入力ストリームを生成します
		Scanner scanner = new Scanner(System.in);

		// 入力フォームを表示します
		System.out.println("input english score:");
		int number1 = scanner.nextInt();
		System.out.println("input math score:");
		int number2 = scanner.nextInt();

		if(number1 < 0 || number1 > 100 || number2 < 0 || number2 > 100){
			System.out.println("不正な値が入力されています");
			return;
		}
		if (number1 >= 80 && number2 >= 80) {
			System.out.println("進級");
		} else if ((number1 >= 80 && number2 < 80) || (number1 < 80 && number2 >= 80)) {
			System.out.println("再試験");
		} else if (number1 < 80 && number2 < 80) {
			System.out.println("留年");
		}
	}
}
