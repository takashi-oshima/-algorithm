package exAd085C;

/**
 * お年玉の中身のパターンを調べます。
 *
 * @author 鶴田竜也
 */
public class Otoshidama {

	/**
	 * お年玉の中身を求めます。
	 *
	 * @param inputNumber 貰ったお年玉の枚数、お年玉の合計値
	 * @return お年玉の中身の判定
	 */
	public String calcOtoshidama(InputNumber inputNumber) {
		// お年玉の枚数
		int numberOfOtoshidama = inputNumber.getNumberN();
		// お年玉の合計金額
		int otoshidamaTotal = inputNumber.getNumberY();

		// 1万円の枚数を格納します
		int count10000 = 0;
		// 5千円の枚数を格納します
		int count5000 = 0;
		// 千円の枚数を格納します
		int count1000 = 0;

		// 外側のfor文で1万円を数えます
		for (int i = 0; i <= numberOfOtoshidama; i++) {
			count10000 = i;
			// 内側のfor文で5000円と1000円を数えます
			for (int j = 0; j <= numberOfOtoshidama - i; j++) {
				count5000 = j;
				count1000 = numberOfOtoshidama - count10000 - count5000;

				// お年玉の金額と一致したら終了します
				if (otoshidamaTotal == (count10000 * 10000) + (count5000 * 5000) + (count1000 * 1000)) {
					return "1万円" + count10000 + "枚、5千" + count5000 + "枚、千円" + count1000 + "枚";
				}
			}
		}
		// N枚の合計金額がYになることがあり得ない場合
		return "-1-1-1";
	}
}
