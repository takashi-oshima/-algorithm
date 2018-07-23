package koganei.ex0215;

import java.util.Scanner;

/**
 * キーボードから入力された複数の数字を取得し、足して10になるふたつの数値をペア
 * として出力します
 *
 * @author 小金井 広輝
 */
public class Ex0215 {
	public static void main(String[] args) {

		//ペアの合計値
		final int TOTAL = 10;

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		String inputString;

		//キーボードから入力された整数を取得します。
		System.out.println("input number：");
		inputString = scanner.nextLine();

		int[] intList = null;
		//入力された文字列が入力されているかを行います
		if (stringErrorCheck(inputString)) {
			//半角空白で数字を分割し、int型に変換します
			//変換できない場合はエラー文を表示し、nullで返します
			intList = halfSpacesJudgment(inputString);
		}
		if (intList == null) {
			//変換できなかった場合
			return;
		}

		//ペアを探し結果を取得します
		String ans = findPair(intList, TOTAL);
		//結果を表示します
		System.out.println(ans);
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
	 * 入力されたString型文字列をint型に変換し返します
	 *
	 * @param inputString 入力された文字列
	 * @return int型に変換された文字列
	 */
	public static int[] halfSpacesJudgment(String inputString) {
		//空白で分解した単語を配列に格納します
		String[] splitString = inputString.split(" ");

		//String型の配列をint型の配列に型変換します
		int[] intList = new int[splitString.length];
		for (int i = 0; i < splitString.length; i++) {
			try {
				intList[i] = Integer.parseInt(splitString[i]);
				if (intList[i] < 0) {
					//負数だった場合
					System.out.println("正数で入力してください");
					intList = null;
					break;
				}
			} catch (NumberFormatException e) {
				//変換されなかった場合
				System.out.println("正しく入力されていません");
				intList = null;
				break;
			}
		}
		return intList;
	}

	/**
	 * 足して10になるペアを探し出し結果を返します
	 *
	 * @param intList 入力された文字列
	 * @param total ペアの合計値
	 * @return ペアを探し出した結果の詳細
	 */
	public static String findPair(int[] intList, int total) {
		int pair1;
		int pair2;
		String ansText = "";
		//ペアを探します
		for (int i = 0; i < intList.length; i++) {
			pair1 = intList[i];
			for (int j = i + 1; j < intList.length; j++) {
				pair2 = intList[j];
				if (total == pair1 + pair2) {
					//足して10のペアを見つけた場合
					ansText = ansText + pair1 + "と" + pair2 + "\n";
					intList[j] = total + 1;
					break;
				}
			}
		}
		//ペアが見つかったか見つからないかの判定を行います。
		if (ansText.equals("")) {
			ansText = "ペアとなる数字はありません";
		} else {
			ansText = ansText + "は足して" + total + "となるペアです";
		}
		return ansText;
	}
}
