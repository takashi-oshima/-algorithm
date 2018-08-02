package ex0360;

/**
 * オセロの進行を管理します。
 *
 * @author 鶴田竜也
 */
public class Ex0360 {
	public static void main(String[] args) {

		Player player1 = new Player("●", "○", "黒");
		Player player2 = new Player("○", "●", "白");
		Judge judge = new Judge();
		Player currentPlayer = player1;
		Board board = new Board();

		// オセロが終了するまでの間、player同士の入力を繰り返します
		while (!judge.judgeEndOthello(board)) {

			// オセロ盤を表示し、 現時点でオセロ盤に置かれている黒コマ、白コマの数を表示します
			board.showPieceCount();

			// 入力内容に応じた数字を格納します
			int result = judge.inputNumber(board, judge, player1);
			boolean putJudge = false;

			if (result == 1) {
				putJudge = judge.flip(board, currentPlayer);

				if (putJudge) {
					currentPlayer = judge.turnChange(currentPlayer, player1, player2);
				} else {
					System.out.println("ここには置けません。再度入力してください");
				}
			} else if (result == 9) {
				currentPlayer = judge.turnChange(currentPlayer, player1, player2);
			}
		}
	}
}
