package takizawa.ex0360;

/**
 * 駒に関する情報を持ちます
 *
 * @author 瀧澤
 */
public class Disk {
	private int color = 1; // (黒: 1, 白: 2)

	/**
	 * 色の取得
	 *
	 * @return color 色
	 */
	public int getColor() {
		return color;
	}

	/**
	 * 色の設定
	 *
	 * @param color セットする color
	 */
	public void setColor(int color) {
		this.color = color;
	}

	// 現在の色に合わせて今がどの手のターンかを表示します
	public void colorName() {

		if (color == 1) {
			System.out.print("黒の手:(行、列) ＞");
		} else if (color == 2) {
			System.out.println("白の手:(行、列) ＞");
		}
	}

	// ターンを切替えた時に色を変えます
	public void turnSwitching() {

		if (color == 1) {
			setColor(2);
		} else {
			setColor(1);
		}
	}
}
