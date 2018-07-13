package ex0360;

/**
 * オセロを行うクラスです
 *
 * @author 高井勇輝
 *
 */
public class Ex0360 {

	public static void main(String[] args) {
		/** ゲームが終わったかのフラグ */
		boolean isGameFinish = false;
		Board board = new Board();

		//オセロ盤が埋まるまでループ
		while (!(board.finishCheck(isGameFinish))) {
			Disk disk = new Disk();
			board.callBoard();
			System.out.println(disk.turnCheck(board.isIsWhiteTurn()));
			String[] inputNumber = disk.inputDiskPosition(board);
			switch (inputNumber.length) {
			case 1:
				if ("9".equals(inputNumber[0])) {
					//9のみ入力されたらパス
					System.out.println("パスします。");
					board.turnSwitch();
				} else {
					//それ以外の1文字は何もしない
					System.out.println("駒を置くときは(行,列)を半角数字で、パスは半角で9を入力してください。");
				}
				break;
			case 2:
				//2文字で駒を置く
				board.putDisk(disk);
				break;
			default:
				System.out.println("駒を置くときは(行,列)を半角数字で、パスは半角で9を入力してください。");
			}
		}
		board.callBoard();
		board.gameResult();
	}
}