package takizawa.ex0360;

import java.util.Scanner;

/**
 * ボードに関する処理を行います
 *
 * @author 瀧澤
 *
 */
public class Board {
	boolean endFlg = false;
	int low = 0;
	int column = 0;
	int board[][] = {
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 1, 2, 0, 0, 0 },
			{ -1, 0, 0, 0, 2, 1, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, 0 } };

	// 初期マスの表示と、各駒の数を出力
	public void board() {
		System.out.println("  1 2 3 4 5 6 7 8");
		for (int i = 1; i < board.length; i++) {
			System.out.print(i);
			for (int j = 0; j <= 8; j++) {

				if (board[i][j] == 1) {
					System.out.print("●");
				} else if (board[i][j] == 2) {
					System.out.print("○");
				} else if (board[i][j] == 0) {
					System.out.print("□");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("●:" + blackDiskCount() + "  ○:" + whiteDiskCount());
	}

	/**
	 * 盤上においてある黒い駒の数を考える
	 *
	 * @return blackDiskCount 黒い駒の数
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
	 * 盤上においてある白い駒の数を考える
	 *
	 * @return whiteDiskCount 白い駒の数
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
	 * 入力値が正しいかを調べます
	 *
	 * @return inputNumber キーボードからの入力値
	 */
	public String[] putDisk() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String[] inputNumber = scanner.nextLine().split(",");

		low = 0;
		column = 0;

		// もし入力値が1文字だった場合
		if (inputNumber.length == 1) {
			return inputNumber;
			// 入力値が3文字以上だった場合
		} else if (inputNumber.length >= 3) {
			System.out.println("入力文字数が間違っています");
			return inputNumber;
		}

		// 入力した文字の1文字目または、2文字目がボードの範囲外だったとき
		if (!numberCount(inputNumber[0]) || !numberCount(inputNumber[1])) {
			System.out.println("入力ミスしてます");
			return inputNumber;
		}
		low = Integer.parseInt(inputNumber[0]); // low ← 入力1文字目
		column = Integer.parseInt(inputNumber[1]); // column ← 入力2文字目
		return inputNumber;
	}

	/**
	 * 入力値が数字であるか、入力した数字が盤上に置ける数字かを調べる
	 *
	 * @param number
	 * @return isNumber	 数字かどうか
	 */
	public boolean numberCount(String number) {
		boolean isNumber = false;
		int numberCount = 0;

		// 文字列numberをint型に直し、数字かどうかの判定
		try {
			numberCount = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return isNumber;
		}

		// 入力した数字がボードの範囲外かどうかを調べる
		if (!(numberCount < board.length) || !(numberCount >= 1)) {
			return isNumber;
		}
		isNumber = true;
		return isNumber;
	}

	/**
	 * 駒が置けるか置けないかの判定
	 *
	 * @param disk 駒
	 */
	public void locateDisk(Disk disk) {
		int diskColor = disk.getColor();

		// 入力した数値の盤の位置が壁かどうかを判定する
		if (board[low][column] == -1) {
			return;
		}

		// 入力した数値の盤の位置が空白ではないとき
		if (board[low][column] != 0) {
			System.out.println("すでに駒が置かれています");
			return;
		}
		boolean isFlip = flip(low, column, diskColor);

		if (isFlip) {
			board[low][column] = diskColor;
			disk.turnSwitching();
		} else {
			System.out.println("置けないよ");
		}
		return;
	}

	/**
	 * 相手の駒があるかどうかを探す
	 *
	 * @param low	入力した行
	 * @param column 入力した列
	 * @param diskColor 自分の駒
	 * @return isOpponentPiece 相手の駒かどうか
	 */
	private boolean flip(int low, int column, int diskColor) {
		boolean isOpponentPiece = false;

		for (int i = low - 1; i <= low + 1; i++) {
			for (int j = column - 1; j <= column + 1; j++) {
				if (existDisk(low, column, diskColor, i, j)) {
					isOpponentPiece = true;
				}
			}
		}
		return isOpponentPiece;
	}

	/**
	 * 8方向検索
	 *
	 * @param low				行
	 * @param column			列
	 * @param diskColor			自分の駒
	 * @param referenceLow		周り8マスのうち1行(現在見ている行)
	 * @param referenceColumn  周り8マスのうち1列(現在見ている列)
	 * @return
	 */
	private boolean existDisk(int low, int column, int diskColor, int referenceLow, int referenceColumn) {

		// 確認している行、列がボードの範囲内じゃない場合
		if (!(referenceLow < board.length) || !(referenceLow >= 1) || !(referenceColumn < board.length)
				|| !(referenceColumn >= 1)) {
			return false;
		}

		// 周囲8マスを1マスずつ調べていった時に自分の駒があった場合
		if (board[referenceLow][referenceColumn] == diskColor) {
			return false;
		}

		//周囲8マスを1マスずつ調べていったときに空だった場合
		if (board[referenceLow][referenceColumn] == 0) {
			return false;
		}
		int newReferenceLow = referenceLow - low;
		int newReferenceColumn = referenceColumn - column;
		referenceLow = referenceLow + newReferenceLow; // どの方向を見に行っているのかを取得
		referenceColumn = referenceColumn + newReferenceColumn;

		// 確認している行、列がボードの範囲内だった場合ループさせる
		while (referenceLow < board.length && referenceLow >= 1 && referenceColumn < board.length
				&& referenceColumn >= 1) {

			// 周囲8マスが空白なら
			if (board[referenceLow][referenceColumn] == 0) {
				return false;
			}

			// 周囲8マスに自分の駒があったら
			if (board[referenceLow][referenceColumn] == diskColor) {

				// 現在確認している行、列が入力した行と列でないときループさせる
				while (!(referenceLow == low && referenceColumn == column)) {
					final int FLIP = -1;
					// 現在確認している場所から順に、入力した行と列の前まで裏返す
					board[referenceLow][referenceColumn] = diskColor;
					referenceLow = referenceLow + newReferenceLow * FLIP;
					referenceColumn = referenceColumn + newReferenceColumn * FLIP;
				}
				return true;
			}
			referenceLow = referenceLow + newReferenceLow; // どの方向を見に行っているのかを更新
			referenceColumn = referenceColumn + newReferenceColumn;
		}
		return false;
	}

	/**
	 * ゲームの終了判定をします
	 *
	 * @return isGameSet ゲームが終わるかどうか
	 */
	public boolean gameSet() {
		boolean isGameSet = false;
		final int MAX_DISK = 64;
		int blackDisk = blackDiskCount();
		int whiteDisk = whiteDiskCount();

		// 駒が盤上を埋め尽くし、白い駒の方が多かった時、または黒い駒が一つも無くなってしまったとき
		if (MAX_DISK == blackDisk + whiteDisk && blackDisk < whiteDisk || blackDisk == 0) {
			isGameSet = true;
			System.out.println("白さんの勝利です!\nお疲れ様でした");
			// 駒が盤上を埋め尽くし、黒い駒の方が多かった時、または白い駒が一つも無くなってしまったとき
		} else if (MAX_DISK == blackDisk + whiteDisk && blackDisk > whiteDisk || whiteDisk == 0) {
			isGameSet = true;
			System.out.println("黒さんの勝利です!\nお疲れ様でした");
			// 黒い駒と白い駒が平等だったとき
		} else if (MAX_DISK == blackDisk + whiteDisk && blackDisk == whiteDisk) {
			isGameSet = true;
			System.out.println("引き分けです!\nお疲れ様でした");
		}
		return isGameSet;
	}
}