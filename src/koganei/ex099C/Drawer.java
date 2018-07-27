package koganei.ex099C;

/**
 * 引き出せる金額の最少の回数を返すクラス
 *
 * @author 小金井 広輝
 */
public class Drawer {

	/** 6のまとまりを示すもの*/
	final int SIX = 6;
	/** 9のまとまりを示すもの*/
	final int NINE = 9;

	/**
	 * 与えられた金額の最少引出回数を取得するため全通りループで回します
	 * 全通りの中で最も少ない回数を返します
	 * やり方は以下の通りです
	 * 例 入力された金額 127
	 * 6の数...21 9の数...0 1の数...1  36:3 6:3 1:1 .......計 7回
	 * 6の数...19 9の数...1 1の数...4  36:3 6:1 9:1 1:4 ...計 9回
	 * 6の数...18 9の数...2 1の数...1  36:3 9:2 1:1 .......計 6回
	 * 				:
	 * 				:
	 * というように9の数を徐々に増やしていきます
	 *
	 * @param priceTotal 入力された金額
	 * @return 最少引出回数
	 */
	public int getMinCount(JudgePrice priceTotal) {

		//入力された金額
		int price = priceTotal.getPrice();

		int chunk6 = 0;
		int chunk9 = 0;
		int count = 0;
		int minCount = Integer.MAX_VALUE;

		while(price >= 0) {
			count = 0;

			chunk6 = price / SIX;
			count = price % SIX;

			count = count + chunkCheck(chunk6, SIX);
			count = count + chunkCheck(chunk9, NINE);

			if(count < minCount) {
				minCount = count;
			}

			chunk9++;
			price = price - NINE;
		}

		return minCount;
	}

	/**
	 * numのまとまりcnunk数の中で累乗のまとまりがいくつあるかとあまりを取得し
	 * その合計を返します
	 * 例
	 * chunk = 19 num = 6（6の数が19個 元の数字は6*19=114）
	 * 結果は36:3, 6:1 で、4を返す
	 *
	 * @param chunk まとまりの数
	 * @param num numのまとまり
	 * @return 合計
	 */
	public static int chunkCheck(int chunk, int num) {
		int remainder = 0;
		while(chunk >= num) {
			remainder = remainder + chunk % num;
			chunk = chunk / num;
		}
		return remainder + chunk;
	}
}
