package ex0114;

import java.util.Scanner;

/**
 * キーボドから文字列を入力し、文字列内の半角空白で単語に分解します
 * 分解後 、単語を逆順で出力します
 * 半角空白が連続で入力された場合は無視します
 *
 * @author 小金井 広輝
 */
public class Ex0114 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);

		//キーボードから入力された文字列を取得します
		System.out.println("文字列：");
		String inputString = scanner.nextLine();

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
	 * 読み込める文字列かチェック
	 *
	 * @param inputString 入力された文字列
	 * @return 正しい文字列かの真偽
	 */
	public static boolean stringErrorCheck(String inputString) {
		if (inputString == null) {
			//文字列がnullの場合
			System.out.println("入力された値がnullです");
			return false;
		} else if (inputString.equals("")) {
			//文字列が空の場合
			System.out.println("文字列が入力されていません");
			return false;
		}
		//正しく入力されている場合
		return true;
	}

	/**
	 * 文字列内に全角空白がある場合、単語に分解し逆順で返します
	 *
	 * @param inputString 入力された文字列
	 * @return 逆順にした文字列
	 */
	public static String halfSpacesJudgment(String inputString) {
		//空白で分解した単語を配列に格納します
		String[] splitString = inputString.split(" ");
		String ansText = "結果：";
		//配列を逆順に参照します
		for (int i = splitString.length - 1; 0 <= i; i--) {
			if (!splitString[i].equals("")) {
				//配列に単語が格納されていた場合
				ansText = ansText + splitString[i] + " ";
			}
		}
		return ansText;
	}
}
