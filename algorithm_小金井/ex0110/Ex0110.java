package ex0110;

import java.util.Scanner;

/**
 * ふたつの文字列を比較し辞書順に表示します
 *
 * @author 小金井 広輝
 */
public class Ex0110 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします。
		Scanner scanner = new Scanner(System.in);

		//キーボードから入力された２つの文字列を取得します
		System.out.println("文字列１：");
		String str1 = scanner.nextLine();
		System.out.println("文字列２：");
		String str2 = scanner.nextLine();

		//文字列のエラーチェックを行い、正しく入力されていたら辞書順に並び替えます
		if(strCheck(str1, str2)) {
			//比較を行います
			String ans = dictionaryOrder(str1, str2);
			//結果を表示します
			System.out.println(ans);
		}
	}

	/**
	 * ２つの文字列を比較し辞書順に並び替えます
	 *
	 * @param str1 文字列１
	 * @param str2 文字列２
	 * @return 辞書順結果
	 */
	public static String dictionaryOrder(String str1, String str2){
		if(str1.compareTo(str2) < 0) {
			//文字列１が文字列２より辞書順で小さい場合
			return str1 + " " + str2;
		}
		if(str1.compareTo(str2) > 0) {
			//文字列２が文字列１より辞書順で小さい場合
			return str2 + " " + str1;
		}
		if(str1.compareTo(str2) == 0) {
			//文字列１と文字列２が同じ場合
			return "２つの文字列は同じです ->" + str1;
		}
		return "エラー：辞書順に並び替えできませんでした。";
	}

	/**
	 * 辞書順に並び替えられる文字列かの判定を行います
	 *
	 * @param str1 文字列１
	 * @param str2 文字列２
	 * @return 正しい文字列かの真偽
	 */
	public static boolean strCheck(String str1,String str2) {
		if(str1.equals(null) || str2.equals(null)) {
			//文字列がnullの場合
			System.out.println("入力された値がnullです");
			return false;
		}else if(str1.equals("") || str2.equals("")){
			//文字列が空の場合
			System.out.println("文字列が入力されていません");
			return false;
		}else if(str1.contains(" ") || str2.contains(" ") || str1.contains("　") || str2.contains("　")) {
			//文字列に空白が含まれる場合
			System.out.println("文字列に空白が含まれています");
			return false;
		}
		//正しく入力されている場合
		return true;
	}
}
