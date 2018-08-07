package awano.exAd085C;

/**
 * 紙幣、10000円札、5000円札、1000円札があります。以下、「お札」とはこの３種を指します。
 * 田中くんが言うには、彼が祖父かえあ受け取ったお年玉袋にはお札がN枚入っていて、
 * 合計Y円だったそうですが、ウソかもしれません。このような状況がありうるか判定し、
 * ありうる場合はお年玉袋の中身の候補を出力します。
 * N枚のお札の合計金額がY円となることがあり得ない場合は「-1 -1 -1」と出力します。
 *
 * @author 粟野真司
 */
public class Lottery {
	/**
	 * お年玉袋の中身予測します。
	 *
	 * @param inputAmount InputAmountクラス
	 */
	public void predictLottery(InputAmount inputAmount) {
		//お年玉袋の中身
		int otoshidama = inputAmount.getTotalAmount();
		//お年玉袋の中身の札数(N枚)
		int nSheet = inputAmount.getBillCount();
		//10000円の札数
		int xSheet = 0;
		//5000円の札数
		int ySheet = 0;
		//1000円の札数
		int zSheet = 0;

		//お年玉袋の中身を予測し、結果を出力します。
		for (int x = 0; x <= nSheet; x++) {
			xSheet = x;
			for (int y = 0; y <= nSheet - x; y++) {
				ySheet = y;
				zSheet = nSheet - xSheet - ySheet;

				if (10000 * xSheet + 5000 * ySheet + 1000 * zSheet == otoshidama) {
					System.out.println(xSheet + " " + ySheet + " " + zSheet);
					return;
				}
			}
		}
		System.out.println("-1 -1 -1");
	}
}