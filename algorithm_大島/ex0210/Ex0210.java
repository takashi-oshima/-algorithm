package ex0210;

import java.text.DecimalFormat;

/**
 * 九九の表を出力します。
 *
 * @author 大島
 */
public class Ex0210 {

	public static void main(String[] args) {
		// 数字のフォーマットをします。
		final DecimalFormat df = new DecimalFormat("00");

		// 九九の表を出力します。
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(df.format(i * j) + " ");
			}
			System.out.println();
		}
	}
}