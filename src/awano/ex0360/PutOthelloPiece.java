package awano.ex0360;

import java.util.Scanner;

/**
 * オセロのコマの情報を管理するクラスです。
 *
 * @author 粟野真司
 */
public class PutOthelloPiece {
	/**黒コマ*/
	private String blackStone = "●";
	/**白コマ*/
	private String whiteStone = "○";
	/**空白(コマが置かれていない)の場所*/
	private String blank = "□";
	/**ターンに応じた自分が操作するコマの色*/
	private String pieceColor = "";
	/**入力された行*/
	private int line = 0;
	/**入力された列*/
	private int column = 0;
	/**ターン切り替えの判定変数*/
	boolean isBlackTurn = true;
	/**入力された数値を格納するための配列*/
	private String[] inputNum = {};
	/**パスをする場合の入力値*/
	final String PASS = "9";

	/**
	 * 入力数値を受け取り、格納された配列の長さを調べます
	 * @return 配列の長さ
	 *
	 */
	public int checkInputNum() {
		int inputLength = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		inputNum = scanner.nextLine().split(",");

		//入力で格納された配列の長さが2の時、かつ、行,列の数値が1～8の場合
		if (inputNum.length == 2 && inputNum[0].matches("[1-8]") && inputNum[1].matches("[1-8]")) {
			line = Integer.parseInt(inputNum[0]);
			column = Integer.parseInt(inputNum[1]);
			inputLength = 2;
		}
		//入力された配列の長さが1の時、かつ、入力値が9の場合
		if (inputNum.length == 1 && inputNum[0].equals(PASS)) {
			inputLength = 1;
		}
		return inputLength;
	}

	/**
	 * 自分が操作するコマの色によってターンを切り替えます
	 */
	public void changeTurn() {
		if (isBlackTurn) {
			this.isBlackTurn = false;
		} else {
			this.isBlackTurn = true;
		}
	}

	/**
	 * コマを置く場所から8方向を確認し、コマが打てる場所か確認します
	 * @param board Boardクラス
	 * @return コマを置くことができるかの判定
	 */
	public boolean canHit(Board board) {
		//コマを置くことができるかの判定変数
		boolean canHit = false;
		//裏返せるコマがある方向の数
		int reverseCount = 0;
		line = Integer.parseInt(inputNum[0]);
		column = Integer.parseInt(inputNum[1]);

		if (isBlackTurn) {
			pieceColor = "●";
		} else {
			pieceColor = "○";
		}
		//置くコマの下
		reverseCount += checkReverse(1, 0, board);
		//置くコマの上
		reverseCount += checkReverse(-1, 0, board);
		//置くコマの右
		reverseCount += checkReverse(0, 1, board);
		//置くコマの左
		reverseCount += checkReverse(0, -1, board);
		//置くコマの右上
		reverseCount += checkReverse(-1, +1, board);
		//置くコマの右下
		reverseCount += checkReverse(1, 1, board);
		//置くコマの左上
		reverseCount += checkReverse(-1, -1, board);
		//置くコマの左下
		reverseCount += checkReverse(1, -1, board);

		if (reverseCount != 0) {
			canHit = true;
		}
		return canHit;
	}

	/**
	 * 裏返しの処理をし、裏返す場合は1を、裏返すものがない場合は0を返します
	 *
	 * @param directionLine 調べる行
	 * @param directionColumn 調べる列
	 * @param board Boardクラス
	 * @return 裏返すコマがあるかどうか
	 */
	public int checkReverse(int directionLine, int directionColumn, Board board) {
		int result = 0;
		line = Integer.parseInt(inputNum[0]);
		column = Integer.parseInt(inputNum[1]);
		int targetLine = line + directionLine;
		int targetColumn = column + directionColumn;

		if (targetLine == 9 || targetColumn == 9 || targetLine == 0 || targetColumn == 0) {
			return result;
		}
		//置いたコマの位置から8方向が自分の操作する色のコマの時、
		//または、空白のとき0を返します
		if (board.getOcelloban()[targetLine][targetColumn] == pieceColor
				|| board.getOcelloban()[targetLine][targetColumn] == blank) {
			return result;
		}
		//行と列を1マスずつ見ていきます
		targetLine += directionLine;
		targetColumn += directionColumn;
		//置いたコマの1つ先の行,列の要素番号が0または9になるまで、while文を回します
		while (targetLine != 9 && targetColumn != 9 && targetLine != 0 && targetColumn != 0) {
			//置いたコマの位置から8方向が空白の時、0を返します
			if (board.getOcelloban()[targetLine][targetColumn] == blank) {
				return result;
			}
			if (board.getOcelloban()[targetLine][targetColumn] == pieceColor) {
				//裏返しの処理を行い、1を返します
				while (line != targetLine || column != targetColumn) {
					board.getOcelloban()[line][column] = pieceColor;
					line += directionLine;
					column += directionColumn;
				}
				result = 1;
				return result;

			}
			//行と列を1マスずつ見ていきます
			targetLine += directionLine;
			targetColumn += directionColumn;
		}
		return result;
	}

	/**
	 * 黒の手のターンを返します
	 *
	 * @return 黒の手のターン
	 */
	public boolean isBlackTurn() {
		return isBlackTurn;
	}

	/**
	 * 黒の手のターンを設定します
	 *
	 * @param isBlackTurn 黒の手のターン
	 */
	public void setBlackTurn(boolean isBlackTurn) {
		this.isBlackTurn = isBlackTurn;
	}

	/**
	 * 黒のコマを返します
	 *
	 * @return 黒のコマ
	 */
	public String getBlackStone() {
		return blackStone;
	}

	/**
	 * 黒のコマを設定します
	 *
	 * @param blackStone 黒のコマ
	 */
	public void setBlackStone(String blackStone) {
		this.blackStone = blackStone;
	}

	/**
	 *白のコマを返します
	 *
	 * @return 白のコマ
	 */
	public String getWhiteStone() {
		return whiteStone;
	}

	/**
	 * 白のコマを設定します
	 *
	 * @param whiteStone 白のコマ
	 */
	public void setWhiteStone(String whiteStone) {
		this.whiteStone = whiteStone;
	}

	/**
	 * 空白を返します
	 *
	 * @return 空白
	 */
	public String getBlank() {
		return blank;
	}

	/**
	 * 空白を設定します
	 *
	 * @param blank 空白
	 */
	public void setBlank(String blank) {
		this.blank = blank;
	}
}