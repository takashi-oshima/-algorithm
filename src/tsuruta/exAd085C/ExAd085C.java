package exAd085C;

/**
 * 実行用クラスになります。
 *
 * お年玉袋にはお札がN枚入っていて、合計Y円であるか否かを判定し結果を出力します。
 * 結果が真である場合、お年玉袋の中身を表示し、
 * 結果が偽である場合、-1-1-1と表示します。
 * 入力形式は以下の通りです。
 * >N Y
 *
 * @author 鶴田竜也
 */
public class ExAd085C {

	public static void main(String[] args) {
		InputNumber inputnumber = new InputNumber();
		Otoshidama otosidama = new Otoshidama();

		// 入力チェックをします
		if (inputnumber.isValidInput()) {
			// お年玉袋の中身の判定結果を出力します
			System.out.println(otosidama.calcOtoshidama(inputnumber));
		}
	}
}
