package takai.ex0360;

import java.util.Scanner;

import takai.ex0360.Board.BoardRange;

/**
 * 駒の情報を持つクラスです
 *
 * @author 高井勇輝
 *
 */

public class Disk {
	/** 一つ目の入力値 */
	String inputTxt = "";
	/** 駒が置けるかを表すフラグ */
	boolean canPutDisk = false;
	/** 行 */
	int row = 0;
	/** 列 */
	int column = 0;

	/**
	 * @return canPutDisk
	 */
	public boolean isCanPutDisk() {
		return canPutDisk;
	}

	/**
	 * @return inputTxt
	 */
	public String getInputTxt() {
		return inputTxt;
	}

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
	 * @param canPutDisk セットする canPutDisk
	 */
	public void setCanPutDisk(boolean canPutDisk) {
		this.canPutDisk = canPutDisk;
	}

	/**
	 * @param inputTxt セットする inputTxt
	 */
	public void setInputTxt(String inputTxt) {
		this.inputTxt = inputTxt;
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

	/**
	 * 入力された文字列を分割し、駒の配置として保存して、文字配列を返します。
	 *
	 * @return inputNumber 分割済みの入力された文字列
	 */
	@SuppressWarnings("resource")
	public String[] inputDiskPosition(Board board) {
		//キーボードから入力値を取得できるようにします。
		Scanner scan = new Scanner(System.in);
		//入力値を代入します。
		inputTxt = scan.nextLine();
		String[] inputNumber = inputTxt.split(",");

		if (inputNumber.length == 1) {
			return inputNumber;
		} else if (inputNumber.length > 2) {
			System.out.println("入力された文字列が多すぎます。(行,列)の形で半角整数を2つ入力してください。");
			return inputNumber;
		}

		if (!isIntNumber(inputNumber[0]) || !isIntNumber(inputNumber[1])) {
			System.out.println("不適な文字列です。,(カンマ)区切りで半角整数を2つ入力してください。");
			return inputNumber;
		}

		int row = Integer.parseInt(inputNumber[0]);
		int column = Integer.parseInt(inputNumber[1]);

		if (BoardRange.Start.getRange() > row || row > board.board.length || BoardRange.Start.getRange() > column
				|| column > board.board.length) {
			System.out.println("不適切な数値です。1～8の値を入力してください。");
			return inputNumber;
		}
		setRow(row);
		setColumn(column);
		setCanPutDisk(true);
		return inputNumber;
	}

	/**
	 * 現在がどちらのプレイヤーターンかを判別し返します。
	 *
	 * @return str プレイヤーターンの手番
	 */
	public String turnCheck(boolean turnFlg) {
		String str = "";
		if (!turnFlg) {
			str = "黒の手(行,列) >";
		} else {
			str = "白の手(行,列) >";
		}
		return str;
	}

	/**
	 * 入力値が数値かどうかを判定します
	 *
	 * @param arg 入力文字列
	 * @return isInt 数値かの判定
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
}