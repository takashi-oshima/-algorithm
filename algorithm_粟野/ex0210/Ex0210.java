package algorithm.ex0210;

/**
 * 九九の表を出力します
 *
 * @author 粟野真司
 */
public class Ex0210 {
	public static void main(String[] args) {

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				// 答えが1桁のとき、0を前につけます
				if (i * j <= 9) {
					System.out.print("0");
				}
				// 掛け算の結果を出力します
				System.out.print(i * j +" ");
				// 空白を出力します
				System.out.print(" ");
			}
			// 改行を出力します
			System.out.print("\n");
		}
	}
}
