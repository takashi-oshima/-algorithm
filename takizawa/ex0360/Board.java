package takizawa.ex0360;

import java.util.Scanner;

/**
 * ボードに関する情報を持ちます
 *
 * @author 瀧澤
 */
public class Board {
	int low = 0;
	int column = 0;
	int[][] board = {
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 1, 2, 0, 0, 0 },
			{ -1, 0, 0, 0, 2, 1, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 }
	};

	// 初期マスと置いてある駒数の表示
	public void board() {
		System.out.println("  1 2 3 4 5 6 7 8");
		for (int i = 1; i < board.length; i++) {
			System.out.print(i);
			for (int j = 0; j <= 8; j++) {

				if (board[i][j] == 0) {
					System.out.print("□");

				} else if (board[i][j] == 1) {
					System.out.print("●");

				} else if (board[i][j] == 2) {
					System.out.print("○");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("●:" + blackDiskCount() + "  ○:" + whiteDiskCount());
	}

	/**
	 * 盤上に置いてある黒い駒の数を数えます
	 *
	 * @return blackDiskCount 黒い駒
	 */
	public int blackDiskCount() {
		int blackDiskCount = 0;
		for (int i = 1; i < board.length; i++) {
			for (int j = 0; j <= 8; j++) {

				if (board[i][j] == 1) {
					blackDiskCount++;
				}
			}
		}
		return blackDiskCount;
	}

	/**
	 * 盤上に置いてある白い駒の数を数えます
	 *
	 * @return whiteDiskCount 白い駒
	 */
	public int whiteDiskCount() {
		int whiteDiskCount = 0;
		for (int i = 1; i < board.length; i++) {
			for (int j = 0; j <= 8; j++) {

				if (board[i][j] == 2) {
					whiteDiskCount++;
				}
			}
		}
		return whiteDiskCount;
	}

	/**
	 * 入力値が正しいか調べる
	 *
	 * @return inputNumber 入力した数字
	 */
	public String[] vaildNumber() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String[] inputNumber = scanner.nextLine().split(",");

		// 1回目に正しい数値を入力させると、lowとcolumnにその情報が保存されるため、2回目に誤った
		// 数値を入力した際に、正しくないエラーが表示されてしまうのでメソッド内で初期化する
		low = 0;
		column = 0;

		if (inputNumber.length == 1) {
			return inputNumber;
		} else if (inputNumber.length >= 3) {
			System.out.println("入力文字数に誤りがあります。");
			return inputNumber;
		}

		if (!(numberCount(inputNumber[0])) || (!(numberCount(inputNumber[1])))) {
			System.out.println("1～8の間で入力してください");
			return inputNumber;
		}
		low = Integer.parseInt(inputNumber[0]);
		column = Integer.parseInt(inputNumber[1]);
		return inputNumber;
	}

	/**
	 * 数字が正しい範囲内かどうか、文字列でないかを調べます
	 *
	 * @param number	 数字
	 * @return	isNumber 数字かどうか
	 */
	public boolean numberCount(String number) {
		boolean isNumber = false;
		int numberCount = 0;

		try {
			numberCount = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return isNumber;
		}

		if (!(numberCount < board.length) || !(numberCount >= 1)) {
			return isNumber;
		}
		isNumber = true;
		return isNumber;
	}

	/**
	 * 駒が置けるかの判別
	 *
	 * @param disk 駒
	 */
	public void locateDisk(Disk disk) {
		int diskColor = disk.getColor();

		if (board[low][column] == -1) {
			return;
		}

		if (board[low][column] != 0) {
			System.out.println("すでに駒が置かれています！");
			return;
		}
		boolean isFlip = flip(low, column, diskColor);

		if (isFlip) {
			board[low][column] = diskColor;
			disk.turnSwitching();
		} else {
			System.out.println("そこには置けません");
		}
		return;
	}

	/**
	 * 相手の駒があるかどうかの確認
	 *
	 * @param low        行
	 * @param column     列
	 * @param diskColor  自分の駒
	 * @return
	 */
	private boolean flip(int low, int column, int diskColor) {
		boolean isOpponentDisk = false;

		for (int i = low - 1; i <= low + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++) {

				if (existDisk(low, column, diskColor, i, j)) {
					isOpponentDisk = true;
				}
			}
		}
		return isOpponentDisk;
	}

	/**
	 * 自らの駒の位置から見たときの8方向検索
	 *
	 * @param low	 	 	 行
	 * @param column 		 列
	 * @param diskColor 	 自分の駒
	 * @param currentLow 	 確認している行
	 * @param currentColumn 確認している列
	 * @return
	 */
	private boolean existDisk(int low, int column, int diskColor, int currentLow, int currentColumn) {

		// 確認している行、列がボードの範囲内じゃない場合
		if (!(currentLow < board.length) || !(currentLow >= 1)
				|| !(currentColumn < board.length) || !(currentColumn >= 1)) {
			return false;
		}

		// 周囲8マスを1マスずつ調べていった時に自分の駒があった場合
		if (board[currentLow][currentColumn] == diskColor) {
			return false;
		}
		//周囲8マスを1マスずつ調べていったときに空だった場合
		if (board[currentLow][currentColumn] == 0) {
			return false;
		}
		int newCurrentLow = currentLow - low;
		int newCurrentColumn = currentColumn - column;
		currentLow = newCurrentLow + low; // 現在どの行を見に行っているのかを取得
		currentColumn = newCurrentColumn + column; //現在どの列を見に行っているのかを取得

		// 確認している場所がボードの範囲内だった場合はループさせる
		while (currentLow < board.length && currentLow >= 1
				&& currentColumn < board.length && currentColumn >= 1) {

			// 現在確認している場所が空白だった場合
			if (board[currentLow][currentColumn] == 0) {
				return false;
			}

			// 現在確認している場所に自分の駒があった場合
			if (board[currentLow][currentColumn] == diskColor) {
				// 現在確認している場所が、入力した場所でないときループさせる
				while (!(currentLow == low && currentColumn == column)) {
					final int FLIP = -1;

					// 現在確認している場所から順に、入力した場所の前まで裏返す
					board[currentLow][currentColumn] = diskColor;
					currentLow = currentLow + newCurrentLow * FLIP;
					currentColumn = currentColumn + newCurrentColumn * FLIP;
				}
				return true;
			}
			// 確認する場所の更新
			currentLow = currentLow + newCurrentLow;
			currentColumn = currentColumn + newCurrentColumn;
		}
		return false;
	}

	/**
	 * ゲームの終わりの条件を決めます
	 *
	 * @return isGameSet ゲーム終了か
	 */
	public boolean GameSet() {
		boolean isGameSet = false;
		final int MAX_CELL = 64;
		int blackDisk = blackDiskCount();
		int whiteDisk = whiteDiskCount();

		// 盤上が埋まっている状態で、白の駒が多い場合または、黒い駒がなくなった場合
		if (MAX_CELL == blackDisk + whiteDisk && blackDisk < whiteDisk || blackDisk == 0) {
			isGameSet = true;
			System.out.println("白の勝利");

			// 盤上が埋まっている状態で、黒の駒が多い場合または、白い駒がなくなった場合
		} else if (MAX_CELL == blackDisk + whiteDisk && blackDisk > whiteDisk || whiteDisk == 0) {
			isGameSet = true;
			System.out.println("黒の勝利");

			// 盤上が埋まっている状態で、白い駒と黒い駒が同じ数の場合
		} else if (MAX_CELL == blackDisk + whiteDisk && blackDisk == whiteDisk) {
			isGameSet = true;
			System.out.println("引き分け");
		}
		return isGameSet;
	}
}
