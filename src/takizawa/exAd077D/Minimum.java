package takizawa.exAd077D;

import java.util.ArrayList;
import java.util.List;

/**
 * Nの正の倍数の10進法における各桁の和としてありうる最小値を求めます
 *
 * @author 瀧澤
 */
public class Minimum {

	/**
	 * Nの正の倍数の数字和の中での最小値を出します
	 *
	 * @param check Checkクラス
	 */
	public void minimum(Check check) {
		String multiArray[] = new String[271];        // 乗算結果を格納する配列
		String arrayForAdd[] = new String[271];       // 数字和を出すための足し算を行う用の配列
		int result = 0; 							    // 数字和
		List<Integer> numericSum = new ArrayList<>(); // 数字和を格納する用のリスト

		// 入力した数字 * 1～271までの結果を配列に格納
		for (int  i = 0; i < multiArray.length; i++) {
			multiArray[i] = String.valueOf((1 + i) * check.getInputN());
		}

		// 配列の0番目から1つずつ検索していく
		for (int i = 0; i < multiArray.length; i++) {

			// 配列のi番目を取り出して文字列の数字とします
			String strNumber = multiArray[i];
			// 取り出した文字列を１文字ずつ配列に格納します
			arrayForAdd = strNumber.split("");

			// 配列の0番目から足していき、int型でresultに入れます
			for (int j = 0; j < arrayForAdd.length; j++) {
				result += Integer.parseInt(arrayForAdd[j]);
			}
			// 数字和格納用配列に結果を入れていきます。
			numericSum.add(result);

			// resultの値が更新されないように、初期化します
			result = 0;
		}
		// listの中から、一番小さな数字を探します。
		int min = numericSum.get(1);
		for (int i = 1; i < numericSum.size(); i++) {
			int searchVal = numericSum.get(i);

			// 現在の探索数値よりも、最小値の方がが大きければ、最小値を更新
			if (searchVal < min) {
				min = searchVal;
			}
		}
		System.out.println(min);
	}
}