package exAd096A;

/**
 * 月の数と日の数が同じ日を高橋という。
 *　2018年1月1日から2018年a月b日までに高橋は何日あるか。
 *　グレゴリオ暦を採用している。
 *
 * 実行用クラスになります。
 * @author 鶴田竜也
 */
public class ExAd096A {

	public static void main(String[] args) {

		InputDate inputDate = new InputDate();
		CountTakahashi countTakahashi = new CountTakahashi();

		System.out.println("高橋がいくつあるか数えます。実行例(5 5)");
		System.out.println("月と日に応じた半角数字を半角スペース1つで区切って入力してください");
		// 入力形式に問題がなければ、「高橋」がいくつあるかカウントして表示します
		if (inputDate.checkDate()) {
			countTakahashi.showTakahshi(inputDate);
		}
	}
}