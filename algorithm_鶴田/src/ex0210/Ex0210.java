package ex0210;

/**
 * 九九の表を出力します
 *
 * @author 鶴田竜也
 */
public class Ex0210 {

	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				// 答えが１桁の時のみ、前に0を入れます。
				if (i * j < 10) {
					System.out.print("0");
				}
				//掛け算の結果を出力します
				System.out.print(i * j);
				//空白を出力します
				System.out.print(" ");
			}
			//改行を出力します
			System.out.print("\n");
		}
	}
}