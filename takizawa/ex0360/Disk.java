package takizawa.ex0360;

/**
 * 駒の色やターンの切り替えの設定をします
 *
 * @author 瀧澤
 *
 */
public class Disk {
	private int color = 1; //(黒: 1 白:2)

	/**
	 * 駒の色を取得します
	 *
	 * @return color 駒の色
	 */
	public int getColor() {
		return color;
	}

	/**
	 * 駒の色を設定します
	 *
	 * @param color セットする color
	 */
	public void setColor(int color) {
		this.color = color;
	}

	// 各駒のターンの時に表示する文を設定します
	public void colorName() {
		if(color == 1) {
			System.out.println("黒の手(行、列)＞");
		}else if(color == 2){
			System.out.println("白の手(行、列)＞");
		}
		return;
	}

	// ターンを切り替えます
	public void turnSwitching() {

		if (color == 1) {
			setColor(2);
		} else {
			setColor(1);
		}
	}
}
