package awano.exAd084A;

import java.util.Scanner;

/**
 * 入力値が1～23の範囲内か調べ、
 * 入力値Mを受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputTime {
	/**入力値の時間*/
	private int time = 0;

	/**
	 * 入力値Mが正しく入力されているかどうか調べます。
	 *
	 * @param inputTime InputTimeクラス
	 * @return 正しく入力されているかどうか
	 */
	public boolean checkInputTime(InputTime inputTime) {
		boolean correctTime = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">M");

		try {
			String inputN = scanner.nextLine();
			time = Integer.parseInt(inputN);
		} catch (NumberFormatException e) {
			System.out.println("半角数値で入力してください。");
			return correctTime;
		}

		//入力値が正しい範囲内かを判定します。
		if (time < 1 || time > 23) {
			System.out.println("Mの入力値を1～23の範囲で入力してください。");
			return correctTime;
		}
		correctTime = true;
		return correctTime;
	}

	/**
	 * 入力値の時間を返します。
	 *
	 * @return 入力値の時間
	 */
	public int getTime() {
		return time;
	}

	/**
	 * 入力値の時間を設定します。
	 *
	 * @param time 入力値の時間
	 */
	public void setTime(int time) {
		this.time = time;
	}
}