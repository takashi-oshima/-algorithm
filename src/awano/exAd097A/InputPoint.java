package awano.exAd097A;

import java.util.Scanner;

/**
 * 入力された数値が、1～100の整数であるかどうか調べ、
 * Aさん、Bさん、Cさんの地点、会話する距離を受け取るクラスです。
 *
 * @author 粟野真司
 */
public class InputPoint {
	/**Aさんの地点*/
	private int aPoint = 0;
	/**Bさんの地点*/
	private int bPoint = 0;
	/**Cさんの地点*/
	private int cPoint = 0;
	/**会話する距離*/
	private int converseDistance = 0;

	/**
	 * 入力された値が1～100の整数かどうか調べます。
	 *
	 * @return 正しい地点かどうか
	 */
	public boolean checkPoint() {
		boolean correctPoint = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(">a b c d");
		String number = scanner.nextLine();
		String[] inputNum = number.split(" ", 0);

		if (inputNum.length != 4) {
			System.out.println("abcdを半角数値の整数で入力してください。");
			return correctPoint;
		}

		int[] distance = new int[inputNum.length];

		try {
			for (int i = 0; i < inputNum.length; i++) {
				distance[i] = Integer.parseInt(inputNum[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("半角数値の整数を入力してください");
			return correctPoint;
		}
		//入力値が整数1～100の範囲外の場合
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] > 100 || distance[i] < 1) {
				System.out.println("入力値は0～100の数値で入力してください");
				return correctPoint;
			}
		}
		correctPoint = true;
		aPoint = distance[0];
		bPoint = distance[1];
		cPoint = distance[2];
		converseDistance = distance[3];
		return correctPoint;
	}

	/**
	 * Aさんの地点を返します。
	 *
	 * @return Aさんの地点
	 */
	public int getAPoint() {
		return aPoint;
	}

	/**
	 * Aさんの地点を設定します。
	 *
	 * @param aPoint Aさんの地点
	 */
	public void setAPoint(int aPoint) {
		this.aPoint = aPoint;
	}

	/**
	 * Bさんの地点を返します。
	 *
	 * @return Bさんの地点
	 */
	public int getBPoint() {
		return bPoint;
	}

	/**
	 * Bさんの地点を返します。
	 *
	 * @param bPoint
	 */
	public void setBPoint(int bPoint) {
		this.bPoint = bPoint;
	}

	/**
	 * Cさんの地点を返します。
	 *
	 * @return Cさんの地点
	 */
	public int getCPoint() {
		return cPoint;
	}

	/**
	 * Cさんの地点を設定します。
	 *
	 * @param cPoint Cさんの地点
	 */
	public void setCPoint(int cPoint) {
		this.cPoint = cPoint;
	}

	/**
	 * 会話する距離を返します。
	 *
	 * @return 会話する距離
	 */
	public int getConverseDistance() {
		return converseDistance;
	}

	/**
	 * 会話する距離を設定します。
	 *
	 * @param converseDistance 会話する距離
	 */
	public void setConverseDistance(int converseDistance) {
		this.converseDistance = converseDistance;
	}
}