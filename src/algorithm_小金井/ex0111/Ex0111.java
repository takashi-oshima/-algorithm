package ex0111;

import java.util.Scanner;

/**
 * 文字列内に許可しない文字が含まれるか判定します
 *
 * @author 小金井 広輝
 */
public class Ex0111 {
	public static void main(String[] args) {

		//キーボードから入力値を取得できるようにします
		Scanner scanner = new Scanner(System.in);
		//許可しない文字群を設定します
		final String[] DISALLOW_WORDS = { "①", "③", "⑤", "⑦", "⑨" };

		//キーボードから入力された文字列を取得します
		System.out.println("文字列：");
		String inputString = scanner.nextLine();

		//文字列のエラーチェックを行い、正しく入力されていたら「許可しない文字」の判定を行います
		if (stringErrorCheck(inputString)) {
			//比較を行います
			String ans = charJudgment(inputString, DISALLOW_WORDS);
			//結果を表示します
			System.out.println(ans);
		}
	}

	/**
	 * 読み込める文字列かチェックを行います
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
	 * 「許可しない文字」が含まれるか判定し判定結果を返します
	 *
	 * @param inputString 入力された文字列
	 * @param disallowWords 許可しない文字
	 * @return 判定結果の詳細
	 */
	public static String charJudgment(String inputString, String[] disallowWords) {
		//判定結果
		String ansTextAll = "";
		for (int i = 0; i < inputString.length(); i++) {
			for (int j = 0; j < disallowWords.length; j++) {
				//「許可しない文字」が含まれるか判定
				if (String.valueOf(inputString.charAt(i)).equals(disallowWords[j])) {
					//比較桁数
					int digit = i + 1;
					//警告文
					String ansText = "許可しない文字（文字：" + disallowWords[j] + " " +
							digit + "桁目）が含まれます\n";
					ansTextAll = ansTextAll + ansText;
				}
			}
		}
		if (ansTextAll.equals("")) {
			//判定にひっかからなかった場合
			ansTextAll = "許可する文字列です";
		}
		return ansTextAll;
	}
}
