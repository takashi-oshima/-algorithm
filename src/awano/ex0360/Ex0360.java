package awano.ex0360;

/**
 *実行用のクラスです。
 *
 * @author 粟野真司
 */
public class Ex0360 {
	public static void main(String[] args) {
		Board board = new Board();
		PutOthelloPiece putOthelloPiece = new PutOthelloPiece();
		while (!board.endGame()) {
			//オセロ盤を表示
			board.showBoard(putOthelloPiece);
			//ゲーム状況とターンの表示
			board.showGameSituation(putOthelloPiece);
			//入力された値によって、コマが打てる場合、裏返しの処理を行います
			switch (putOthelloPiece.checkInputNum()) {
			//入力された値が9の時パスが実行されます
			case 1:
				System.out.println("パスします");
				putOthelloPiece.changeTurn();
				continue;
			//コマが打てた場合、ターンを切り替えます
			case 2:
				if (putOthelloPiece.canHit(board)) {
					putOthelloPiece.changeTurn();
				} else {
					System.out.println("指定した位置にコマを置けません");
				}
				continue;
			default:
				System.out.println("行,列を入力し直してください");
			}
		}
		//試合終了後のオセロ盤を表示します
		board.showBoard(putOthelloPiece);
		System.out.println();
		//オセロの試合結果を表示します
		board.showGameResult();
	}
}