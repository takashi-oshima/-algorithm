package takizawa.ex0117;

import java.util.Scanner;

/**
 * 2つのテストを比較して、3つの段階に分けるクラスです
 *
 * @author 瀧澤
 */
public class Ex0117 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("input english score:");
		//e_scoreに整数を読み込む
		int e_score = scanner.nextInt();
		System.out.println("input math score");
		//m_scoreに整数を読み込む
		int m_score = scanner.nextInt();
		//両方の点数が80 点以上の場合
		if (e_score >= 80 && m_score >= 80) {
			System.out.println("進級");
			//点数のどちらかが80 点を下回る場合
		} else if ((e_score < 80 && m_score >= 80) || (m_score < 80 && e_score >= 80)) {
			System.out.println("再試験");
			//両方の点数とも80 点を下回る場合
		} else {
			System.out.println("留年");
		}
	}
}