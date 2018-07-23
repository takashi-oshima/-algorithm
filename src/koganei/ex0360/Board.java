package koganei.ex0360;

import koganei.ex0360.Ex0360.FlipPattern;

/**
 * ボードクラス
 * ボードの盤面を管理します
 *
 * @author 小金井 広輝
 */
public class Board {

	//ボードの盤面
	private String[][] boardStatus;

	/**
	 * 初期値として設定します
	 */
	public Board() {
		//盤面の初期値の状態
		String[][] boardStatus = {
				{ "＼", "１", "２", "３", "４", "５", "６", "７", "８", "　" },
				{ "１", "□", "□", "□", "□", "□", "□", "□", "□", "　" },
				{ "２", "□", "□", "□", "□", "□", "□", "□", "□", "　" },
				{ "３", "□", "□", "□", "□", "□", "□", "□", "□", "　" },
				{ "４", "□", "□", "□", "○", "●", "□", "□", "□", "　" },
				{ "５", "□", "□", "□", "●", "○", "□", "□", "□", "　" },
				{ "６", "□", "□", "□", "□", "□", "□", "□", "□", "　" },
				{ "７", "□", "□", "□", "□", "□", "□", "□", "□", "　" },
				{ "８", "□", "□", "□", "□", "□", "□", "□", "□", "　" },
				{ "　", "　", "　", "　", "　", "　", "　", "　", "　", "　" }, };
		this.boardStatus = boardStatus;
	}

	/**
	 * 現在のボードの盤面を表示します
	 */
	public void getBoardStatus() {
		String stringBoardStatus = "";
		for (int i = 0; i < boardStatus.length; i++) {
			for (int j = 0; j < boardStatus[i].length; j++) {
				stringBoardStatus = stringBoardStatus + boardStatus[i][j];
			}
			stringBoardStatus = stringBoardStatus + "\n";
		}
		System.out.println(stringBoardStatus);
	}

	/**
	 * ボードの盤面を設定します
	 *
	 * @param boardStatus ボードの盤面
	 */
	public void setBoardStatus(String[][] boardStatus) {
		this.boardStatus = boardStatus;
	}

	/**
	 * ボードの盤面に指定された記号がいくつあるかを取得し結果を返します
	 *
	 * @param searchMark 検索記号
	 * @return 指定された記号の個数
	 */
	public int getStoneCount(String searchMark) {
		int markCount = 0;
		for (int i = 0; i < boardStatus.length; i++) {
			for (int j = 0; j < boardStatus[i].length; j++) {
				if (boardStatus[i][j].equals(searchMark)) {
					markCount++;
				}
			}
		}
		return markCount;
	}

	/**
	 * 裏返しの動作を行い、結果を返します
	 *
	 * @param player プレイヤー
	 * @return 裏返しを行ったか否か
	 */
	public FlipPattern flipAction(Player player) {
		//裏返しの動作を行った回数
		int checkCount = 0;
		//入力された行数、列数
		int row = player.getRow();
		int column = player.getColumn();
		if (boardStatus[row][column] == "●" || boardStatus[row][column] == "○") {
			//入力された場所がすでに埋まっていた場合
			return FlipPattern.AlreadyPut;
		}
		//入力された場所から８方向に伸びるマスを裏返す処理それぞれ行います
		//左上
		checkCount += flip(player, -1, -1);
		//上
		checkCount += flip(player, -1, 0);
		//右上
		checkCount += flip(player, -1, +1);
		//左
		checkCount += flip(player, 0, -1);
		//右
		checkCount += flip(player, 0, +1);
		//左下
		checkCount += flip(player, +1, -1);
		//下
		checkCount += flip(player, +1, 0);
		//右下
		checkCount += flip(player, +1, +1);

		if (checkCount == 0) {
			//裏返しを行わなかった場合
			return FlipPattern.FlipNG;
		} else {
			//裏返しを行った場合
			return FlipPattern.FlipOK;
		}
	}

	/**
	 * 裏返しの処理を行います
	 * 裏返しを行った場合１、行わなかった場合０を返します
	 *
	 * @param player プレイヤー
	 * @param rowMove 次にいくつ横にずれるかの数
	 * @param columnMove 次にいくつ縦にずれるかの数
	 * @return 動作結果
	 */
	public int flip(Player player, int rowMove, int columnMove) {
		//指定された行、列を設定します
		int row = player.getRow();
		int column = player.getColumn();
		//自分の石、相手の石を設定します
		String myStone = player.getMyStone();
		String opponentStone = player.getOpponentStone();
		//ひとつ先の行、列を設定します
		int targetRow = row + rowMove;
		int targetColumn = column + columnMove;

		if (boardStatus[targetRow][targetColumn] == myStone) {
			//石を置いた隣に自分の石がある場合
			return 0;
		}

		//ひとマスずつ先を見ていき裏返すかどうかの判定を行います
		while (true) {
			if (boardStatus[targetRow][targetColumn] == opponentStone) {
				targetRow = targetRow + rowMove;
				targetColumn = targetColumn + columnMove;
			} else if (boardStatus[targetRow][targetColumn] == myStone) {
				//裏返しの処理を行います
				while (targetRow != row || targetColumn != column) {
					this.boardStatus[row][column] = myStone;
					row = row + rowMove;
					column = column + columnMove;
				}
				return 1;
			} else {
				//ひとつ先のマスが「●」もしくは「○」でない場合
				return 0;
			}
		}
	}
}
