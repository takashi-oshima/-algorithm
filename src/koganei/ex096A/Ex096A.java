package koganei.ex096A;

import koganei.Input;

/**
 * 2018年1月1日から2018年a月b日までに「高橋」は何日あるかを求めます
 * 「高橋」は月の数と日の数が同じ日を言います
 *
 * @author 小金井 広輝
 */
public class Ex096A {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgeDate date = new JudgeDate();

		//入力された文字列を日付に変換できるかチェック
		if (!date.judgeConversion(inputString)) {
			return;
		}

		TakahashiCount takahashiCount = new TakahashiCount();
		//結果を表示します
		System.out.println(takahashiCount.getTakahashiCount(date));
	}
}
