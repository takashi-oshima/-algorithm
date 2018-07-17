package takai.ex0360;

/**
 * オセロ盤の情報を持つクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Board {
	/** どちらのターンかを表すフラグ */
	boolean isWhiteTurn = false;
	//-1:調整用要素 0:置けない 1:黒 2:白
	//ヘッダーの数値と書き込み位置を合わせる為に[9][9]配列
	int[][] board = { { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 1, 2, 0, 0, 0 },
			{ -1, 0, 0, 0, 2, 1, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 } };

	/**
	 * @return turnFlg
	 */
	public boolean isIsWhiteTurn() {
		return isWhiteTurn;
	}

	/**
	 * @param isWhiteTurn セットする turnFlg
	 */
	public void setIsWhiteTurn(boolean isWhiteTurn) {
		this.isWhiteTurn = isWhiteTurn;
	}

	public enum DiskColor {
		Unkown(0), Black(1), White(2);

		final int state;

		public int getState() {
			return state;
		}

		private DiskColor(int state) {
			this.state = state;
		}
	}

	public enum BoardRange {
		Start(1);

		final int range;

		public int getRange() {
			return range;
		}

		private BoardRange(int range) {
			this.range = range;
		}
	}

	/**
	 * 現在のオセロ盤の状況を表示します。
	 */
	public void callBoard() {
		System.out.println("  1 2 3 4 5 6 7 8");
		/** 左ヘッダー用 */
		int count = 1;
		for (int i = 1; i < board.length; i++) {
			System.out.print(count + " ");
			count++;
			for (int j = 1; j < board[i].length; j++) {
				char disk;
				if (board[i][j] == DiskColor.Black.getState()) {
					disk = '●';
				} else if (board[i][j] == DiskColor.White.getState()) {
					disk = '○';
				} else {
					disk = '□';
				}
				System.out.print(disk);
			}
			System.out.println();
		}
		System.out.println("●:" + blackDiskCount() + " ○:" + whiteDiskCount());
	}

	/**
	 * 盤上の黒い駒の数を計算して返します。
	 *
	 * @return blackCount 黒い駒の数
	 */
	public int blackDiskCount() {
		int blackCount = 0;
		for (int[] i : board) {
			for (int j : i) {
				if (j == DiskColor.Black.getState()) {
					++blackCount;
				}
			}
		}
		return blackCount;
	}

	/**
	 * 盤上の白い駒の数を計算して返します。
	 *
	 * @return whiteCount 白い駒の数
	 */
	public int whiteDiskCount() {
		int whiteCount = 0;
		for (int[] i : board) {
			for (int j : i) {
				if (j == DiskColor.White.getState()) {
					++whiteCount;
				}
			}
		}
		return whiteCount;
	}

	/**
	 * 指定した位置に駒が置けるか判定し、置けたら置いてターンを渡します。
	 *
	 * @param disk Diskクラス
	 */
	public void putDisk(Disk disk) {
		/** 行 */
		int row = disk.getRow();
		/** 列 */
		int column = disk.getColumn();
		/** 駒を置けるかの判定 */
		boolean isInBoard = disk.isCanPutDisk();
		/** ターンプレイヤーの駒の色 */
		int diskColor = DiskColor.Unkown.getState();

		if (!isWhiteTurn) {
			diskColor = DiskColor.Black.getState();
		} else {
			diskColor = DiskColor.White.getState();
		}

		if (!isInBoard) {
			System.out.println("この位置には置くことができません");
			return;
		}

		if (board[row][column] != DiskColor.Unkown.getState()) {
			System.out.println("この位置には既に駒が置かれています");
			return;
		}

		//反転できるか見る
		boolean canFlip = flipConfirmation(diskColor, row, column);
		if (canFlip) {
			board[row][column] = diskColor;
			turnSwitch();
		} else {
			System.out.println("この位置には置くことができません");
		}
	}

	/**
	 * 置いた駒の周囲に、ひっくり返せる相手の駒があるか調べます。
	 *
	 * @param diskColor ターンプレイヤーの駒の色
	 * @param row 行
	 * @param column 列
	 * @return 駒を置けるかの判定
	 */
	public boolean flipConfirmation(int diskColor, int row, int column) {
		/** 周囲に相手の駒があるかの判定 */
		boolean flag = false;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++) {
				if (flipDisk(diskColor, row, column, i, j)) {
					flag = true;
				}
			}
		}
		return flag;
	}

	/**
	 * 周囲に相手の駒があるか、あったら、その先に自分の駒があるかを調べます。
	 * 自分の駒があればtrueを返し途中の相手の駒を裏返します。
	 * 自分の駒がない、もしくは空いているマスがあればfalseを返します。
	 *
	 * @param diskColor ターンプレイヤーの駒の色
	 * @param row 指定した行
	 * @param column 指定した列
	 * @param referenceRow 参照している行
	 * @param referenceColumn 参照している列
	 * @return 裏返せる駒があるか
	 */
	public boolean flipDisk(int diskColor, int row, int column, int referenceRow, int referenceColumn) {

		//確認箇所が盤上かの判定
		if (referenceRow < BoardRange.Start.getRange() || referenceRow >= board.length
				|| referenceColumn < BoardRange.Start.getRange() || referenceColumn >= board.length) {
			return false;
		}

		//確認箇所に自分の駒があるかの判定
		if (board[referenceRow][referenceColumn] == diskColor) {
			return false;
		}

		//確認箇所が空マスかの判定
		if (board[referenceRow][referenceColumn] == DiskColor.Unkown.getState()) {
			return false;
		}

		/** 確認箇所が横軸のどの方向かの確認。負数なら左方向、正数なら右方向*/
		int rowVector = referenceRow - row;
		/** 確認箇所が縦軸のどの方向かの確認。負数なら上方向、正数なら下方向*/
		int columnVector = referenceColumn - column;

		//方向に合わせて1ずつ足す(単位ベクトル)
		referenceRow += rowVector;
		referenceColumn += columnVector;

		//オセロ盤上である限りループ
		while (referenceRow >= BoardRange.Start.getRange() && referenceRow < board.length
				&& referenceColumn >= BoardRange.Start.getRange() && referenceColumn < board.length) {

			//空マスがあるか
			if (board[referenceRow][referenceColumn] == DiskColor.Unkown.getState()) {
				return false;
			}

			//自分の駒があるか
			if (board[referenceRow][referenceColumn] == diskColor) {
				//自分の駒の位置から、駒を置いた位置まで駒を反転させるループ
				while (!(referenceRow == row && referenceColumn == column)) {
					//ベクトル反転用
					final int REVERSE_VECTOR = -1;
					board[referenceRow][referenceColumn] = diskColor;
					referenceRow += (rowVector * REVERSE_VECTOR);
					referenceColumn += (columnVector * REVERSE_VECTOR);
				}
				return true;
			}
			referenceRow += rowVector;
			referenceColumn += columnVector;
		}
		return false;
	}

	/**
	 * 各プレイヤーターンの切り替えを行います。
	 */
	public void turnSwitch() {
		if (!isWhiteTurn) {
			setIsWhiteTurn(true);
		} else {
			setIsWhiteTurn(false);
		}
	}

	/**
	 * ゲームが終わったかの判定をします。
	 *
	 * @param isGameFinish 現在のゲーム終了判定
	 * @return 判定結果
	 */
	public boolean finishCheck(boolean isGameFinish) {
		/** 盤上に存在する駒の最大数 */
		final int ALL_DISK_COUNT = 64;
		/** 黒い駒の数 */
		int blackCount = blackDiskCount();
		/** 白い駒の数 */
		int whiteCount = whiteDiskCount();
		/** 現在盤上に存在する駒の合計 */
		int diskCount = blackCount + whiteCount;

		if (ALL_DISK_COUNT == diskCount || blackCount == 0 || whiteCount == 0) {
			isGameFinish = true;
		}
		return isGameFinish;
	}

	/**
	 * 勝敗を表示します。
	 */
	public void gameResult() {
		/** 黒い駒の数 */
		int blackCount = blackDiskCount();
		/** 白い駒の数 */
		int whiteCount = whiteDiskCount();

		System.out.print("●:" + blackCount + "対  ○:" + whiteCount + "で、");

		if (blackCount > whiteCount || whiteCount == 0) {
			System.out.println("●の勝ちです");
		} else if (blackCount < whiteCount || blackCount == 0) {
			System.out.println("○の勝ちです");
		} else {
			System.out.println("引き分けです");
		}
	}
}