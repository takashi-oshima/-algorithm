package takizawa.ex0360;

/**
 * 他のクラスから呼び出したメソッドを使い、オセロをします
 *
 * @author 瀧澤
 *
 */
public class Ex0360 {
	public static void main(String[] args) {

		Board board = new Board();
		Disk disk = new Disk();
		// GameSetメソッドが呼び出されるまで続けます
		while (!(board.gameSet())) {
			board.board();
			disk.colorName();
			String[] putDiskStr = board.putDisk();
			switch (putDiskStr.length) {
			case 1:
				// パスの処理
				if ("9".equals(putDiskStr[0])) {
					System.out.println("パスします");
					disk.turnSwitching();
				} else {
					System.out.println("入力ミスです");
				}
				break;
			case 2:
				board.locateDisk(disk);
				break;
			default:
				System.out.println("入力値にエラーがあるよ");
			}
		}
		board.board();
	}
}