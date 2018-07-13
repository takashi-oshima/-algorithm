package ex0210;

/**
 * 九九の掛け算を表示するクラスです
 *
 * @author 高井勇輝
 *
 */
public class Ex0210 {

	public static void main(String[] args) {
		//掛け算の結果を2ケタに統一して出力します。
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(String.format("%02d", i * j) + " ");
			}
			System.out.println("\r\n");
		}
	}
}