package ex0360;

import ex0360.PutOthelloDisc.DiscColor;

/**
 * Boardクラスはオセロ盤の情報を管理し、盤上の駒数を数えたり勝敗判定をしたりする機能を持ちます。
 *
 * @author 大島
 */
public class Board {
	/** オセロ盤、8*8の盤面に駒を置けない範囲を設定するため10*10に設定 */
	private int[][] othelloBoard = {
			{ 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 },
			{ 9, 0, 0, 0, 0, 0, 0, 0, 0, 9 },
			{ 9, 0, 0, 0, 0, 0, 0, 0, 0, 9 },
			{ 9, 0, 0, 0, 0, 0, 0, 0, 0, 9 },
			{ 9, 0, 0, 0, 2, 1, 0, 0, 0, 9 },
			{ 9, 0, 0, 0, 1, 2, 0, 0, 0, 9 },
			{ 9, 0, 0, 0, 0, 0, 0, 0, 0, 9 },
			{ 9, 0, 0, 0, 0, 0, 0, 0, 0, 9 },
			{ 9, 0, 0, 0, 0, 0, 0, 0, 0, 9 },
			{ 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 } };

	/**
	 * BoardInfoは、オセロ盤の範囲と置ける駒数の最小と最大を表す列挙型です。
	 *
	 * @author 大島
	 */
	public enum BoardInfo {
		/** オセロ盤の最小範囲 */
		MinRange(1),
		/** オセロ盤の最大範囲 */
		MaxRange(9),
		/** オセロ盤にある駒の最小数 */
		MinDisc(0),
		/** オセロ盤にある駒の最大数 */
		MaxDisc(64);

		final int info;

		public int getInfo() {
			return info;
		}

		private BoardInfo(int info) {
			this.info = info;
		}
	}

	/**
	 * 盤面をゲームの進行状況に従って出力します。
	 */
	public void outputBoard() {
		System.out.print("  ");
		for (int i = BoardInfo.MinRange.getInfo(); i < BoardInfo.MaxRange.getInfo(); i++) {
			System.out.print(i + " ");
		}
		for (int i = BoardInfo.MinRange.getInfo(); i < BoardInfo.MaxRange.getInfo(); i++) {
			System.out.print("\r\n" + i + " ");
			for (int j = BoardInfo.MinRange.getInfo(); j < BoardInfo.MaxRange.getInfo(); j++) {
				if (othelloBoard[i][j] == DiscColor.Empty.getState()) {
					System.out.print("□ ");
				} else if (othelloBoard[i][j] == DiscColor.White.getState()) {
					System.out.print("○ ");
				} else if (othelloBoard[i][j] == DiscColor.Black.getState()) {
					System.out.print("● ");
				} else {
					System.out.print(" ");
				}
			}
		}
		System.out.println("\r\n");
	}

	/**
	 * 現在の盤上の駒数を取得します。
	 *
	 * @param coler DiscColorクラス
	 * @return 現在の盤上の駒数
	 */
	public int discCount(DiscColor coler) {
		int discCount = 0;
		for (int i = BoardInfo.MinRange.getInfo(); i < BoardInfo.MaxRange.getInfo(); i++) {
			for (int j = BoardInfo.MinRange.getInfo(); j < BoardInfo.MaxRange.getInfo(); j++) {
				if (othelloBoard[i][j] == coler.getState()) {
					++discCount;
				}
			}
		}
		return discCount;
	}

	/**
	 * 現在の盤上の駒数を表示します。
	 *
	 * @return 現在の盤上の駒数の表示文
	 */
	public String outputDiscCount() {
		return "●：" + discCount(DiscColor.Black) + " ○：" + discCount(DiscColor.White);
	}

	/**
	 * ゲームの進行状況に従い、駒が盤面にそれぞれ何駒ずつ置かれているかと、現在どちらのターンかを表示します。
	 *
	 * @param disc PutOthelloDiscクラス
	 */
	public void progressGame(PutOthelloDisc disc) {
		if (disc.getTurn() == DiscColor.White.getState()) {
			System.out.println(outputDiscCount());
			System.out.print("\r\n白の手(行、列) > ");
		} else {
			System.out.println(outputDiscCount());
			System.out.print("\r\n黒の手(行、列) > ");
		}
	}

	/**
	 * オセロ盤の駒の数を元に、ゲームが終わったかどうかの判定を行います。
	 *
	 * @return ゲームが終わったかどうかの判定です。
	 */
	public boolean isGameEnd() {
		if (discCount(DiscColor.Black) + discCount(DiscColor.White) == BoardInfo.MaxDisc.getInfo()
				|| discCount(DiscColor.Black) == BoardInfo.MinDisc.getInfo()
				|| discCount(DiscColor.White) == BoardInfo.MinDisc.getInfo()) {
			return true;
		}
		return false;
	}

	/**
	 * オセロ盤の駒の数を元に、勝敗表示を行います。
	 */
	public void gameResult() {
		if (discCount(DiscColor.Black) < discCount(DiscColor.White)) {
			System.out.println(outputDiscCount() + "白の勝ち");
		} else if (discCount(DiscColor.Black) > discCount(DiscColor.White)) {
			System.out.println(outputDiscCount() + "黒の勝ち");
		} else {
			System.out.println(outputDiscCount() + "引き分け");
		}
	}

	/**
	 * @return othelloBoard オセロ盤
	 */
	public int[][] getOthelloBoard() {
		return othelloBoard;
	}

	/**
	 * @param othelloBoard オセロ盤
	 */
	public void setOthelloBoard(int[][] othelloBoard) {
		this.othelloBoard = othelloBoard;
	}
}