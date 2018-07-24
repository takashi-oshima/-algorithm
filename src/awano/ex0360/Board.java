package awano.ex0360;

/**
 * オセロ盤の情報を管理するクラスです。
 * 盤面の情報を元に試合の終了、勝敗結果を判定する機能を持ちます。
 *
 * @author 粟野真司
 */
public class Board {

	/**オセロ盤の初期表示を二次元配列に格納します*/
	private String ocelloboard[][] = {
			{ "  ", "１", "２", "３", "４", "５", "６", "７", "８" },
			{ "１", "□", "□", "□", "□", "□", "□", "□", "□" },
			{ "２", "□", "□", "□", "□", "□", "□", "□", "□" },
			{ "３", "□", "□", "□", "□", "□", "□", "□", "□" },
			{ "４", "□", "□", "□", "●", "○", "□", "□", "□" },
			{ "５", "□", "□", "□", "○", "●", "□", "□", "□" },
			{ "６", "□", "□", "□", "□", "□", "□", "□", "□" },
			{ "７", "□", "□", "□", "□", "□", "□", "□", "□" },
			{ "８", "□", "□", "□", "□", "□", "□", "□", "□" },
	};

	/**
	 * ゲーム進行中のオセロ盤を表示します
	 *
	 * @param putDisc PutDiscクラス
	 */
	public void showBoard(PutOthelloPiece putDisc) {
		System.out.print("  ");
		for (int i = 1; i < ocelloboard.length; i++) {
			System.out.print(i + "  ");
		}
		for (int i = 1; i < ocelloboard.length; i++) {
			System.out.print("\n" + i + " ");
			for (int j = 1; j < ocelloboard[0].length; j++) {
				if (ocelloboard[i][j] == putDisc.getBlank()) {
					System.out.print("□ ");
				}
				if (ocelloboard[i][j] == putDisc.getBlackStone()) {
					System.out.print("● ");
				}
				if (ocelloboard[i][j] == putDisc.getWhiteStone()) {
					System.out.print("○ ");
				}
			}
		}
	}

	/**
	 * オセロ盤上の黒コマ、白コマの数を表示し、
	 * ターンによって入力フォームを表示します
	 *
	 *@param putDisc PutDiscクラス
	 */
	public void showGameSituation(PutOthelloPiece putDisc) {
		//黒の手のターンの時
		if (putDisc.isBlackTurn()) {
			System.out.println("\r\n●:" + countBlackPiece() + "○:" + countWhitePiece());
			System.out.println("黒の手(行、列) >");
			//白の手のターンの時
		} else {
			System.out.println("\r\n●:" + countBlackPiece() + "○:" + countWhitePiece());
			System.out.println("白の手(行、列) >");
		}
	}

	/**
	 * オセロ盤上の黒コマの個数をカウントします
	 *
	 * @return 黒コマの個数
	 */
	public int countBlackPiece() {
		int blackCount = 0;
		for (int i = 1; i < ocelloboard.length; i++) {
			for (int j = 1; j < ocelloboard[0].length; j++) {
				if (ocelloboard[i][j] == "●") {
					blackCount++;
				}
			}
		}
		return blackCount;
	}

	/**
	 * オセロ盤上の白コマの個数をカウントします
	 *
	 * @return 白コマの個数
	 */
	public int countWhitePiece() {
		int whiteCount = 0;
		for (int i = 1; i < ocelloboard.length; i++) {
			for (int j = 1; j < ocelloboard[0].length; j++) {
				if (ocelloboard[i][j] == "○") {
					whiteCount++;
				}
			}
		}
		return whiteCount;
	}

	/**
	 * オセロの試合が終了したかの判定を行います
	 *
	 * @return 試合終了かの判定
	 */
	public boolean endGame() {
		//試合終了かの判定変数
		boolean isEndGame = false;

		if (countBlackPiece() + countWhitePiece() == 64 || countBlackPiece() == 0 || countWhitePiece() == 0) {
			isEndGame = true;
		}
		return isEndGame;
	}

	/**
	 * オセロゲームの勝敗結果を表示します
	 */
	public void showGameResult() {
		if (countBlackPiece() > countWhitePiece()) {
			System.out.println("\n●:" + countBlackPiece() + "○:" + countWhitePiece() + "で黒の勝利");
		}
		if (countBlackPiece() < countWhitePiece()) {
			System.out.println("\n●:" + countBlackPiece() + "○:" + countWhitePiece() + "で白の勝利");
		}
		if (countBlackPiece() == countWhitePiece()) {
			System.out.println("\n●:" + countBlackPiece() + "○:" + countWhitePiece() + "で引き分けです");
		}
	}

	/**
	 * オセロ盤を返します
	 *
	 * @return オセロ盤
	 */
	public String[][] getOcelloban() {
		return ocelloboard;
	}

	/**
	 * オセロ盤を設定します
	 *
	 * @param ocelloban オセロ盤
	 */
	public void setOcelloban(String[][] ocelloban) {
		this.ocelloboard = ocelloban;
	}
}