package oshima.ex0360;

/**
 * Ex0360はメインクラスで、オセロゲームの流れを管理します。
 *
 * @author 大島
 */
public class Ex0360 {

	public static void main(String[] args) {

		Board board = new Board();
		PutOthelloDisc disc = new PutOthelloDisc();
		// オセロの勝敗が付くまでループ処理
		while (!board.isGameEnd()) {
			board.outputBoard();
			board.progressGame(disc);
			switch (disc.inputNumber()) {
			case 1:
				disc.changeTurn();
				continue;
			case 2:
				if (disc.isPutDisc(board)) {
					disc.changeTurn();
				} else {
					System.out.println("裏返せる駒がないか、不正な位置を指定したため駒を置けません。");
				}
				continue;
			default:
				System.out.println("パスの場合は 9 を駒を打つ場合は 行,列 を入力してください。");
			}
		}
		board.outputBoard();
		board.gameResult();
	}
}