package takai.ex0380;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * オセロ盤の情報を持つクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Board {
	/** 一つ目の入力値 */
	String inputTxt = "";
	/** 駒が置けるかを表すフラグ */
	boolean canPutDisk = false;
	boolean isOpen[][] = new boolean[10][10];
	boolean isMines[][] = new boolean[10][10];
	int nearMines[][] = new int[10][10];
	/** 行 */
	int row = 0;
	/** 列 */
	int column = 0;
	//-5:調整用要素 0:置けない 1:黒 2:白
	//ヘッダーの数値と書き込み位置を合わせる為に[10][10]配列
	int[][] board = { { -5, -5, -5, -5, -5, -5, -5, -5, -5, -5 },
			{ -5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ -5, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	/**
	 * @return row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param row セットする row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @param column セットする column
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	public enum DiskColor {
		Mine(-1), Unkown(0), Blank(10);

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

	//10個の地雷をセットする
	public void setMine() {
		List<Integer> setRow = new ArrayList<>();
		List<Integer> setColumn = new ArrayList<>();
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				isOpen[i][j] = false;
				isMines[i][j] = false;
				nearMines[i][j] = 0;
			}
		}
		for (int i = 9; i >= 0; i--) {
			setRow.add(i);
			setColumn.add(i);
		}

		//リストに追加した数値をシャッフル
		while (true) {
			Collections.shuffle(setRow);
			Collections.shuffle(setColumn);
			//盤外に地雷が行くのを防ぐためシャッフル後に0番目に0があったらもう一度シャッフルする
			if (0 != setRow.get(0) && 0 != setColumn.get(0)) {
				break;
			}
		}

		int i = 0;
		while (i < setRow.size()) {
			//要素が0の時、要素数を要素値として持たせる
			if (setRow.get(i) == 0) {
				setRow.set(i, i);
			}
			if (setColumn.get(i) == 0) {
				setColumn.set(i, i);
			}
			int thisRow = setRow.get(i);
			int thisColumn = setColumn.get(i);
			//地雷がセットされていなければセットする
			if (board[thisRow][thisColumn] != DiskColor.Mine.getState()) {
				board[thisRow][thisColumn] = DiskColor.Mine.getState();
				isMines[thisRow][thisColumn] = true;
				minesCount(i, thisRow, thisColumn);
				i++;
			}
		}
	}

	//地雷セット後の周囲のマスの要素を1増やす
	public void minesCount(int number, int thisRow, int thisColumn) {
		for (int referenceRow = thisRow - 1; referenceRow <= thisRow + 1; referenceRow++) {
			for (int referenceColumn = thisColumn - 1; referenceColumn <= thisColumn + 1; referenceColumn++) {
				if (isInBoard(referenceRow, referenceColumn)
						&& board[referenceRow][referenceColumn] != DiskColor.Mine.getState()) {
					nearMines[referenceRow][referenceColumn] += 1;
				}
			}
		}
	}

	//周囲のマスが盤上かの確認
	public boolean isInBoard(int referenceRow, int referenceColumn) {
		//確認箇所が盤上かの判定
		boolean isInBoard = false;
		if (referenceRow >= BoardRange.Start.getRange() && referenceRow < board.length
				&& referenceColumn >= BoardRange.Start.getRange() && referenceColumn < board.length) {
			isInBoard = true;
		}
		return isInBoard;
	}

	/**
	 * 現在のオセロ盤の状況を表示します。
	 */
	public void callBoard() {
		System.out.println("  1 2 3 4 5 6 7 8 9");
		/** 左ヘッダー用 */
		int count = 1;
		for (int i = 1; i < board.length; i++) {
			System.out.print(count + " ");
			count++;
			for (int j = 1; j < board[i].length; j++) {
				if (!isOpen[i][j]) {
					System.out.print("■");
				} else if (isMines[i][j]) {
					System.out.print("★");
				} else if (0 == nearMines[i][j]) {
					System.out.print("□");
				} else {
					System.out.print(" " + nearMines[i][j]);
				}
			}
			System.out.println();
		}
	}

	//引数を持たせる
	public void putDisk() {
		putDisk(row, column);
	}

	//空マスにする判定とその処理を行う
	public void putDisk(int row, int column) {

		if (BoardRange.Start.getRange() > row || row >= board.length || BoardRange.Start.getRange() > column
				|| column >= board.length) {
			return;
		}

		if (isOpen[row][column]) {
			return;
		}

		isOpen[row][column] = true;
		if (0 < nearMines[row][column]) {
			return;
		}
		//現在：周囲8マス
		//変更：上下左右だけ見るように
		if (!isMines[row][column] && DiskColor.Mine.getState() != board[row][column]) {
			if (BoardRange.Start.getRange() <= row && row <= board.length
					&& BoardRange.Start.getRange() <= column
					&& column <= board.length) {
				putDisk(row - 1, column);
				putDisk(row, column - 1);
				putDisk(row, column + 1);
				putDisk(row + 1, column);
			}
		}
	}

	/**
	 * 入力された文字列を分割し、駒の配置として保存して、文字配列を返します。
	 *
	 * @return inputNumber 分割済みの入力された文字列
	 */
	@SuppressWarnings("resource")
	public boolean inputDiskPosition() {
		//キーボードから入力値を取得できるようにします。
		Scanner scan = new Scanner(System.in);
		//入力値を代入します。

		System.out.println("空けるマスを選択して下さい。(行,列)　>");
		inputTxt = scan.nextLine();
		String[] inputNumber = inputTxt.split(",");

		if (inputNumber.length != 2) {
			System.out.println("入力された文字列が不正です。(行,列)の形で半角整数を2つ入力してください。");
			return canPutDisk;
		}

		if (!isIntNumber(inputNumber[0]) || !isIntNumber(inputNumber[1])) {
			System.out.println("不適な文字列です。,(カンマ)区切りで半角整数を2つ入力してください。");
			return canPutDisk;
		}

		int row = Integer.parseInt(inputNumber[0]);
		int column = Integer.parseInt(inputNumber[1]);

		if (BoardRange.Start.getRange() > row || row > board.length || BoardRange.Start.getRange() > column
				|| column > board.length) {
			System.out.println("不適切な数値です。1～8の値を入力してください。");
			return canPutDisk;
		}
		setRow(row);
		setColumn(column);
		canPutDisk = true;
		return canPutDisk;
	}

	/**
	 * 入力値が整数か判定し手返します。
	 *
	 * @param arg 入力文字列
	 * @return isInt 判定結果
	 */
	@SuppressWarnings("unused")
	static boolean isIntNumber(String arg) {
		boolean isInt = false;
		int i = 0;
		try {
			i = Integer.parseInt(arg);
		} catch (NumberFormatException e) {
			return isInt;
		}
		isInt = true;
		return isInt;
	}

	/**
	 * 地雷のあるマスが空いていないか確認します
	 *
	 * @return isOpenMines 地雷マスが空いているかの判定結果
	 */
	public boolean checkMines() {
		boolean isOpenMines = false;
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if(isOpen[i][j] && isMines[i][j]) {
					isOpenMines = true;
				}
			}
		}
		return isOpenMines;
	}

	/**
	 * ゲームが終わったかの判定をします。
	 *
	 * @param isGameFinish 現在のゲーム終了判定
	 * @return 判定結果
	 */
	public boolean finishCheck(boolean isGameFinish) {
		int count = 0;
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if(isOpen[i][j] && !isMines[i][j]){
					count++;
				}
			}
		}

		if(count == 71) {
			isGameFinish = true;
		}
		return isGameFinish;
	}
}