package takizawa.ex0360;

/**
 * Diskクラス、Boardクラスの情報を読み込み、
 * プレーヤーにリバーシをさせます
 *
 * @author 瀧澤
 */
public class Ex0360 {

	public static void main(String[] args) {
		// Boardクラス、Diskクラスをインスタンス化
		Board board = new Board();
		Disk disk = new Disk();

		//GameSetメソッドが呼び出されるまで続けます
		while (!(board.GameSet())) {
			board.board();
			disk.colorName();
			String[] putDiskStr = board.vaildNumber();
			switch (putDiskStr.length) {
			case 1:
				// 9を入力した時にパスをさせます
				if ("9".equals(putDiskStr[0])) {
					System.out.println("パスします");
					disk.turnSwitching();
				} else {
					System.out.println("入力ミス");
				}
				break;
			case 2:
				// 駒を置いて裏返します
				board.locateDisk(disk);
				break;
			default:
				System.out.println("入力値エラー");
				break;
			}
		}
		// ゲームが終わった際のボードの状態を読み込みます
		board.board();
	}
}