package takai.ex0380;

/**
 * マインスイーパーを行うクラスです
 *
 * @author 高井勇輝
 *
 */
public class Ex0380 {

	public static void main(String[] args) {
		/** ゲームが終わったかのフラグ */
		boolean isGameFinish = false;
		Board board = new Board();
		board.setMine();

		//ゲームクリア、もしくはゲームオーバーまでループ
		while (!(board.finishCheck(isGameFinish))) {
			board.callBoard();
			if(board.inputDiskPosition()) {
				//2文字で駒を置く
				board.putDisk(board.getRow(), board.getColumn());
			}
			if(board.checkMines()) {
				board.callBoard();
				System.out.println("ゲームオーバーです。");
				return;
			}
		}
		board.callBoard();
		System.out.println("ゲームクリアです。");
	}
}