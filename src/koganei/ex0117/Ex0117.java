package koganei.ex0117;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 英語、数学の試験の点数を入力し、
 * 両方の点数が80点以上の場合、進級
 * どちらかが80点を下回る場合、再試験
 * 両方の点数とも80点を下回る場合、留年
 * と表示する
 *
 * @author 小金井 広輝
 */
public class Ex0117 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		int e_score;
		int m_score;

		//キーボードから入力された文字列を取得します
		try {
			System.out.println("input english score:");
			e_score = scanner.nextInt();
			System.out.println("input math score:");
			m_score = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("数字を入力してください");
			return;
		}

		//点数の判別を行い、結果を表示します
		if(e_score < 0 || m_score < 0 || e_score > 100 || m_score > 100){
			System.out.println("\n正しい点数を入力してください");
		}else if(e_score >= 80 && m_score >= 80) {
			System.out.println("\n進級");
		}else if(e_score < 80 && m_score < 80) {
			System.out.println("\n留年");
		}else {
			System.out.println("\n再試験");
		}
	}
}
