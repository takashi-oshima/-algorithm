package koganei.ex0360;

/**
 * メインクラス
 * オセロ盤を初期表示する。黒白交互に打つ場所を入力し、打った後の盤面を
 * 表示することを繰り返す。最後まで打ち終えたら終了する
 * ただし、打てる場所がなくなくパスする場合は１として「9」を入力する
 *
 * @author 小金井 広輝
 */
public class Ex0360 {

	/**
	 * 入力された文字のパターンを設定します
	 *
	 * @author 小金井 広輝
	 */
	public enum InputPattern {
		InputOK, Pass, Error;
	}

	/**
	 * 裏返せるかどうかのパターンを設定します
	 *
	 * @author 小金井 広輝
	 */
	public enum FlipPattern {
		AlreadyPut, FlipNG, FlipOK
	}

	/** パスする場合の入力値*/
	public static final String PASS = "9";
	/**ターン数の初期値を設定します*/
	public static final int START_TURN = 1;

	public static void main(String[] args) {

		//ボードを生成します
		Board board = new Board();

		//プレイヤー２人を生成します
		Player player1 = new Player("黒", "●", "○", board);
		Player player2 = new Player("白", "○", "●", board);

		//プレイヤーリストを生成します
		Player[] playerList = { player2, player1 };

		//プレイヤーを1ターンごとに切り替えるためのもの
		int turn = START_TURN;
		//試合開始
		//１ループごとに交互に石を置いていきます
		while (true) {
			//現在の石を置くプレイヤーを設定します
			int change = turn % 2;
			Player nowPlayer = playerList[change];

			//盤面を表示します
			board.getBoardStatus();

			//各プレイヤーの持つ石の合計を表示します
			player1.showStoneCount();
			player2.showStoneCount();

			//どのような入力がされたか判定し、読み込めた場合裏返し処理を行います
			InputPattern inputResult = nowPlayer.setRowColumn();
			switch (inputResult) {
			case InputOK:
				//裏返し処理の結果を取得し、それに応じてその後の処理を行います
				FlipPattern flipResult = board.flipAction(nowPlayer);
				switch (flipResult) {
				case FlipOK:
					//裏返しができた場合
					//各プレイヤーの持つ石の合計を更新する
					player1.setStoneCount(board);
					player2.setStoneCount(board);
					turn++;
					break;
				case FlipNG:
					System.out.println("その位置は裏返すことができません");
					break;
				case AlreadyPut:
					System.out.println("すでにその位置に置かれています");
					break;
				default:
					break;
				}
				break;
			case Pass:
				System.out.println("パスしました");
				turn++;
				break;
			case Error:
				System.out.println("正しく入力されていません");
				break;
			default:
				break;
			}

			if (board.getStoneCount("□") == 0 ||
					player1.getStoneCount() == 0 || player2.getStoneCount() == 0) {
				//すべてのマスが埋まった、または石の色が一色になった場合
				break;
			}
		}

		//試合結果を表示します
		board.getBoardStatus();
		player1.showStoneCount();
		player2.showStoneCount();
		showWinner(player1, player2);
	}

	/**
	 * 試合結果を表示します
	 *
	 * @param player1 プレイヤー１
	 * @param player2 プレイヤー２
	 */
	public static void showWinner(Player player1, Player player2) {
		if (player1.getStoneCount() > player2.getStoneCount()) {
			System.out.println("\n" + player1.getColorName() + "の勝ち！");
		} else if (player1.getStoneCount() < player2.getStoneCount()) {
			System.out.println("\n" + player2.getColorName() + "の勝ち！");
		} else {
			System.out.println("\n" + "引き分け");
		}
	}
}
