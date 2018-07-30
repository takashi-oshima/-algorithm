package ex0360;

/**
 * オセロ盤を管理します。
 *
 * @author 鶴田竜也
 */
public class Board {
	/** オセロ盤 */
	private String[][] board;
	/** オセロ盤に置かれている黒コマの数を格納します */
	private int blackCount = 2;
	/** オセロ盤に置かれている白コマの数を格納します */
	private int whiteCount = 2;

	/** オセロ盤の初期状態 */
	public Board() {
		// オセロ開始時点のオセロ盤の状態を格納します " "と"数字"は壁の役割
		String[][] board = {
				{ " ", "1", "2", "3", "4", "5", "6", "7", "8", " " },
				{ "1", "□", "□", "□", "□", "□", "□", "□", "□", " " },
				{ "2", "□", "□", "□", "□", "□", "□", "□", "□", " " },
				{ "3", "□", "□", "□", "□", "□", "□", "□", "□", " " },
				{ "4", "□", "□", "□", "●", "○", "□", "□", "□", " " },
				{ "5", "□", "□", "□", "○", "●", "□", "□", "□", " " },
				{ "6", "□", "□", "□", "□", "□", "□", "□", "□", " " },
				{ "7", "□", "□", "□", "□", "□", "□", "□", "□", " " },
				{ "8", "□", "□", "□", "□", "□", "□", "□", "□", " " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
		};
		// オセロ開始時のオセロ盤の状態をthis.boardに格納します
		this.board = board;
	}

	/* 現時点でオセロ盤に置かれている黒コマ、白コマの数を表示します */
	public void showPieceCount() {
		this.blackCount = 0;
		this.whiteCount = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				// オセロ盤の出力
				System.out.print(board[i][j]);
				System.out.print(" ");

				// 盤上の黒コマを数えます
				if (board[i][j].contains("●")) {
					this.blackCount++;
				}

				// 盤上の白コマを数えます
				if (board[i][j].contains("○")) {
					this.whiteCount++;
				}
			}
			System.out.println();
		}
		System.out.println("●：" + this.blackCount + " ○：" + this.whiteCount);
	}

	/**
	 * 現時点のオセロ盤状態（置かれているコマの状況）を取得します
	 *
	 * @return 現時点のオセロ盤状態
	 */
	public String[][] getBoard() {
		return board;
	}

	/**
	 * プレイヤーが入力した場所にコマをセットします
	 *
	 * @param line 入力した行
	 * @param column 入力した列
	 * @param piece コマ
	 */
	public void setBoard(int line, int column, String piece) {
		this.board[line][column] = piece;
	}

	/**
	 * オセロ盤に置かれている黒コマの数を取得します
	 *
	 * @return オセロ盤に置かれている黒コマの数
	 */
	public int getBlackCount() {
		return blackCount;
	}

	/**
	 * オセロ盤に置かれている白コマの数を取得します
	 *
	 * @return オセロ盤に置かれている白コマの数
	 */
	public int getWhiteCount() {
		return whiteCount;
	}
}
