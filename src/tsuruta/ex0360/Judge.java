package ex0360;

import java.util.Scanner;

/**
 *  コマを入力位置に置けるか判定、裏返し判定、オセロ終了の判定を行います。
 *
 * @author 鶴田竜也
 */
public class Judge {
	/** 入力された行 */
	private int line;
	/** 入力された列 */
	private int column;

	/**
	 * 入力した内容に応じて数字を返します。
	 * 1:入力した場所にコマを置ける
	 * 9:パス(相手のターン)
	 * 0：コマを置けない（再び自分のターン）
	 *
	 * @param board オセロ盤クラス
	 * @param judge 審判（判定）クラス
	 * @param player プレイヤークラス
	 * @return 入力内容に応じた数字
	 */
	public int inputNumber(Board board, Judge judge, Player player) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println(player.getMyPieceColor() + "の手(行,列) >");

		String inputNum = scan.nextLine();

		// 9を入力したときは自分のターンをパスします
		if (inputNum.equals("9")) {
			System.out.println("パスします。次は相手のターンです");
			return 9;
		}

		String[] inputNumber = inputNum.split(",");

		// 2文字のみ入力を受け付けるようにします
		if (inputNumber.length != 2) {
			System.out.println("入力形式が違います。(行,列)の形で1から8までの半角数字を入力してください");
			return 0;
		}

		int line = 0;
		int column = 0;

		try {
			// キーボード入力の行の数字をline、列の数字をcolumnに代入します
			line = Integer.parseInt(inputNumber[0]);
			column = Integer.parseInt(inputNumber[1]);

		} catch (NumberFormatException e) {
			// 数字以外を入力したとき、再び自分のターンを行います
			System.out.println("数字以外を入力しないでください");
			board.showPieceCount();
			return 0;
		}

		if (line < 1 || line > 8 || column < 1 || column > 8) {
			System.out.println("1から8以外の数字が入力されています。(行,列)の形で半角数字を入力してください");
			return 0;
		}

		// 入力可能であれば1を返します
		judge.setLine(line);
		judge.setColumn(column);
		return 1;
	}

	/**
	 * コマの裏返し処理を行います。コマを裏返せればtrueを、そうでなければfalseを返します。
	 *
	 * @param line 入力された行
	 * @param column 入力された列
	 * @param board オセロ盤クラス
	 * @param myPiece オセロ盤に置かれている自分のコマ
	 * @param enemyPiece オセロ盤に置かれている相手のコマ
	 * @return コマを裏返せるかの真偽
	 */
	public boolean flip(Board board, Player currentPlayer) {
		boolean isFlip = false;

		// 既にコマが置いてある場合
		if (!board.getBoard()[line][column].equals("□")) {
			return isFlip;
		}

		String enemyPiece = currentPlayer.getEnemyPiece();

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				// コマ置いた(行,列)では、特に何もしないで処理を終えます
				if (j == 0 && i == 0) {
					continue;
				}

				int nextLine = line + i;
				int nextColumn = column + j;
				/* 辿った先が"1"や" "（壁）,"□"、 自分の駒だった場合は処理を終えて次の座標を見ます
				       例 : □○ → ○○                                              */
				if (board.getBoard()[nextLine][nextColumn] != enemyPiece) {
					continue;
				}

				/* 裏返しの真偽をresultに返します */
				boolean result = judgeFlip(i, j, currentPlayer, board);
				if (result) {
					isFlip = true;
				}
			}
		}
		return isFlip;
	}

	/**
	 * 裏返しの判定を行います。裏返せればtrue、裏返せなければfalseを返します。
	 *
	 * @param i 入力された行に足す数字
	 * @param j 入力された列に足す数字
	 * @param currentPlayer 入力するプレイヤー
	 * @param board オセロ盤
	 * @return 裏返しの真偽
	 */
	public boolean judgeFlip(int i, int j, Player currentPlayer, Board board) {

		int nextLine = line + i;
		int nextColumn = column + j;

		String myPiece = currentPlayer.getMyPiece();
		String enemyPiece = currentPlayer.getEnemyPiece();

		while (true) {
			if (board.getBoard()[nextLine][nextColumn] == myPiece) {
				int flipLine = line;
				int flipColumn = column;

				while (flipLine != nextLine || flipColumn != nextColumn) {
					board.setBoard(flipLine, flipColumn, myPiece);
					flipLine += i;
					flipColumn += j;
				}
				return true;
			} else if (board.getBoard()[nextLine][nextColumn] != enemyPiece) {
				return false;
			}
			nextLine += i;
			nextColumn += j;
		}
	}

	/**
	 * ターンを交代します。
	 *
	 * @param currentPlayer 入力するプレイヤー
	 * @param player1 プレイヤー1
	 * @param player2 プレイヤー2
	 * @return 入力するプレイヤー
	 */
	public Player turnChange(Player currentPlayer, Player player1, Player player2) {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
		return currentPlayer;
	}

	/**
	 * オセロを終了するか判定します。終了であればtrueを、続行するのであればfalseを返します。
	 *
	 * @param board オセロ盤
	 * @return オセロを終了するかの真偽
	 */
	public boolean judgeEndOthello(Board board) {
		// オセロ盤に置かれているコマの数を代入します
		int pieceCount = board.getBlackCount() + board.getWhiteCount();
		// オセロ盤のマス 64マス(8*8)
		final int ALL_OF_THE_TROUT = 64;

		// オセロのマスが全部（64マス）埋まった時、黒コマ、白コマが0の時、オセロを終了します
		if (pieceCount == ALL_OF_THE_TROUT || board.getBlackCount() == 0 || board.getWhiteCount() == 0) {
			System.out.println("これ以上打てる場所がありません。オセロを終了します");
			System.out.println("結果…●：" + board.getBlackCount() + "個  ○" + board.getWhiteCount() + "個");

			if (board.getBlackCount() > board.getWhiteCount()) {
				System.out.println("黒の勝ち");
			} else {
				System.out.println("白の勝ち");
			}
			return true;
		}
		return false;
	}

	/**
	 * 入力された行を取得します。
	 *
	 * @return 入力された行
	 */
	public int getLine() {
		return line;
	}

	/**
	 * 入力された行をセットします。
	 *
	 * @param 入力された行
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * 入力された列を取得します。
	 *
	 * @return 入力された列
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * 入力された列をセットします。
	 *
	 * @param 入力された列
	 */
	public void setColumn(int column) {
		this.column = column;
	}
}
