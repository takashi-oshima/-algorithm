package koganei.ex0115;

import java.util.Scanner;

/**
 * キーボードから文字列を入力し、文字列内の半角空白で単語に分解します
 * 分解後 、単語の出力順序が偶数と奇数でそれぞれ結合して出力します
 *
 * @author 小金井 広輝
 */
public class Ex0115 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);

		//キーボードから入力された文字列を取得します
		System.out.println("文字列：");
		String inputString = scanner.nextLine();

		System.out.println("\n\n");

		//文字列のエラーチェックを行い、正しく入力されていたら
		//半角空白の判定を行います
		if (stringErrorCheck(inputString)) {
			//判定を行います
			String ans = halfSpacesJudgment(inputString);
			//結果を表示します
			System.out.println(ans);
		}
	}

	/**
	 * 読み込める文字列かチェックします
	 *
	 * @param inputString 入力された文字列
	 * @return 正しい文字列かの真偽
	 */
	public static boolean stringErrorCheck(String inputString) {
		if (inputString.equals("") || inputString == null) {
			//文字列が空の場合
			System.out.println("文字列が入力されていません");
			return false;
		}
		//正しく入力されている場合
		return true;
	}

	/**
	 * 半角空白で単語に分解し、単語の出力順序を偶数と奇数でそれぞれ結合するようにします
	 *
	 * @param inputString 入力された文字列
	 * @return 奇数と偶数の分別結果
	 */
	public static String halfSpacesJudgment(String inputString) {
		//空白で分解した単語を配列に格納します
		String[] splitString = inputString.split(" ");
		String oddText = "奇数番目：";
		String evenText = "偶数番目：";
		boolean odd = true;
		for (int i = 0; i < splitString.length; i++) {
			if (!splitString[i].equals("")) {
				//配列に単語が格納されていた場合
				if (odd) {
					//奇数番目のとき
					oddText = oddText + splitString[i] + " ";
					odd = false;
				} else {
					//偶数番目のとき
					evenText = evenText + splitString[i] + " ";
					odd = true;
				}
			}
		}
		//奇数と偶数の分別結果を返します
		return oddText + "\n" + evenText;
	}
}
