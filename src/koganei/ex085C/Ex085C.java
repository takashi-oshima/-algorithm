package koganei.ex085C;

import koganei.Input;

/**
 * お年玉にはお札がN枚入っていて合計Y円であるか否かを判別し結果を出力します
 * 結果が真である場合、お年玉袋の中身の候補を表示し、
 * 結果が偽である場合、-1 -1 -1と表示します
 * 入力形式は以下の通りです
 * >N Y
 *
 * @author 小金井 広輝
 */
public class Ex085C {
	public static void main(String[] args) {

		//文字列を入力させます
		Input inputString = new Input();
		JudgeBill bill = new JudgeBill();

		//入力された文字列が正しく入力できているかチェック
		if (!bill.judgeBill(inputString)) {
			return;
		}

		OtoshidamaBill OtoshidamaBill = new OtoshidamaBill();
		//結果を表示します
		System.out.println(OtoshidamaBill.getOtoshidamaBill(bill));
	}
}
