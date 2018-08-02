package koganei.ex097A;

import koganei.Input;

/**
 * AさんとCさんが直接または間接的に会話できるかどうかの判定を行います
 * 間接的とはAさんとBさん、BさんとCさんが直接会話できることを指します
 * 入力形式は以下の通りです
 * ＞a b c d
 *
 * a.....Aさんの地点
 * b.....Bさんの地点
 * c.....Cさんの地点
 * d.....ふたりの直接会話できる距離
 *
 * @author 小金井 広輝
 */
public class Ex097A {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgeDistance distance = new JudgeDistance();

		//入力された文字列が距離に変換できるかチェック
		if (!distance.judgeConversion(inputString)) {
			return;
		}

		Transceiver transceiver = new Transceiver();
		//結果を表示します
		System.out.println(transceiver.judgeTalking(distance));
	}
}
