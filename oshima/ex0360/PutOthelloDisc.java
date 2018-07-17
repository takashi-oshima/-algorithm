package oshima.ex0360;

import java.util.Scanner;

/**
 * OthelloDiscクラスは、駒の情報を管理し、駒の動作を操作する機能を持ちます。
 *
 * @author 大島
 */
public class PutOthelloDisc {
	/** 検索行、列を操作するために設定した値 */
	private final int OPPOSITE_DIRECTION = -1;
	/** turnの値を1か2にするために設定した値 */
	private final int CHANGE_SWITCH = 3;
	/** turnの値が1の時は白で、2の時は黒となります。 */
	private int turn = 1;
	/** オセロ盤の行 */
	private int row;
	/** オセロ盤の列 */
	private int col;

	/**
	 * DiskColorは、オセロ盤に置かれている駒の色を表す列挙型です。
	 *
	 * @author 大島
	 */
	public enum DiscColor {
		/** オセロ盤上で何も置かれていない位置を指す値 */
		Empty(0),
		/** 白を指す値 */
		White(1),
		/** 黒を指す値 */
		Black(2),
		/** オセロ盤上で駒を置くことの出来ない位置を指す値 */
		Wall(9);

		final int state;

		public int getState() {
			return state;
		}

		private DiscColor(int state) {
			this.state = state;
		}
	}

	/**
	 * 入力値の値から駒を置く場所を指定またはパスを入力します。
	 */
	public int inputNumber() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String[] inputStrings = scanner.nextLine().split(",");
		int inputLength = 0;

		if (inputStrings.length == 1 && inputStrings[0].equals("9")) {
			inputLength = 1;
		}
		if (inputStrings.length == 2 && inputStrings[0].matches("[1-8]") && inputStrings[1].matches("[1-8]")) {
			this.row = Integer.parseInt(inputStrings[0]);
			this.col = Integer.parseInt(inputStrings[1]);
			inputLength = 2;
		}
		return inputLength;
	}

	/**
	 * 駒が置かれるか、パスが選択されるとターンが変わります。 turnの値が1の時は白のターン、2の時は黒のターンです。
	 */
	public void changeTurn() {
		turn = CHANGE_SWITCH - turn;
	}

	/**
	 * 指定した位置に駒が置かれていなければ、指定した位置の周囲8マスに裏返せる駒があるか探して裏返します。
	 *
	 * @param board Boardクラス
	 * @return 駒を置くことが出来たかどうか
	 */
	public boolean isPutDisc(Board board) {
		// 自分の駒の色
		int myDiscColor = turn;
		boolean isPut = false;

		if (board.getOthelloBoard()[row][col] != DiscColor.Empty.getState()) {
			return isPut;
		}
		// 指定した位置の周囲8マスを検索し、裏返せる相手の駒があれば指定した位置に駒を置きます。
		for (int searchRow = row - 1; searchRow <= row + 1; searchRow++) {
			for (int searchCol = col - 1; searchCol <= col + 1; searchCol++) {

				if (canFlipDisc(searchRow, searchCol, board)) {
					board.getOthelloBoard()[row][col] = myDiscColor;
					isPut = true;
				}
			}
		}
		return isPut;
	}

	/**
	 * 指定した位置に隣接した周囲8マスを見て、相手の駒があったらその直線状に自分の駒があるか検索します。
	 * 直線状に自分の駒がなければ駒を置けず、駒があればその間にある相手の駒を裏返すことが出来ます。
	 *
	 * @param searchRow 指定した位置を元に検索される行。
	 * @param searchCol 指定した位置を元に検索される列。
	 * @param board Boardクラス
	 *
	 * @return 裏返せる駒があるかどうか
	 */
	public boolean canFlipDisc(int searchRow, int searchCol, Board board) {
		// 自分の駒の色
		int myDiscColor = turn;
		// 相手の駒の色
		int opponentDiscColor = CHANGE_SWITCH - turn;
		// 値が正なら上、負なら下方向を指します。
		int directionRow = searchRow - row;
		// 値が正なら右、負なら左方向を指します。
		int directionCol = searchCol - col;

		if (board.getOthelloBoard()[searchRow][searchCol] != opponentDiscColor) {
			return false;
		}
		// 1マス先を検索します。
		searchRow += directionRow;
		searchCol += directionCol;

		// searchRowとsearchColの値が盤内である限りループ処理します。
		while (searchRow != DiscColor.Wall.getState() && searchCol != DiscColor.Wall.getState()) {

			if (board.getOthelloBoard()[searchRow][searchCol] == DiscColor.Empty.getState()) {
				return false;
			}

			if (board.getOthelloBoard()[searchRow][searchCol] == DiscColor.Wall.getState()) {
				return false;
			}

			// 直線状にある相手駒を挟んだ自分の駒の位置まで行き、挟んでいる相手駒を裏返しつつ駒を置いた位置まで戻ります。
			if (board.getOthelloBoard()[searchRow][searchCol] == myDiscColor) {
				while (searchRow != row || searchCol != col) {
					board.getOthelloBoard()[searchRow][searchCol] = myDiscColor;
					searchRow += directionRow * OPPOSITE_DIRECTION;
					searchCol += directionCol * OPPOSITE_DIRECTION;
				}
				return true;
			}
			searchRow += directionRow;
			searchCol += directionCol;
		}
		return false;
	}

	/**
	 * @return int型の数値 1または2で、白黒どちらのターンかを示します。
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * @param turn int型の数値 1または2で、白黒どちらのターンかを示します。
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}
}