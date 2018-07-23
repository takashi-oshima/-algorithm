package takizawa.ex0210;
/**
 * 九九の表を表示します
 *
 * @author 瀧澤
 */
public class Ex0210 {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if( i * j < 10) {
					System.out.print("0");
				}
				System.out.print(i * j + " ");
			}
			System.out.print("\n");
		}
	}
}