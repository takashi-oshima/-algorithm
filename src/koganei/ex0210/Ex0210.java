package koganei.ex0210;

/**
 * 九九の表を出力します
 *
 * @author 小金井 広輝
 */
public class Ex0210 {
	public static void main(String[] args) {
		//九九表を表示します
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(String.format("%02d", i * j) + " ");
			}
			System.out.println("\r\n");
		}
	}
}
