package oshima.exAd097A;

import java.util.Scanner;

/**
 * Inputクラスは、標準入力を管理するクラスです。
 *
 * @author 大島
 */
public class Input {
	/** Aのいる場所 */
	private int pointA = 0;
	/** Bのいる場所 */
	private int pointB = 0;
	/** Cのいる場所 */
	private int pointC = 0;
	/** 直接会話できる距離 */
	private int speakArea = 0;

	/**
	 * DistanceRangeは、距離間隔の最小と最大を示す列挙型です。
	 *
	 * @author 大島
	 */
	public enum DistanceRange {
		MinDistance(1), MaxDistance(100);

		final int range;

		public int getRange() {
			return range;
		}

		private DistanceRange(int range) {
			this.range = range;
		}
	}

	/**
	 * 標準入力を受け付け、入力値をチェックします。
	 *
	 * @return 入力した値が適切かどうかです。
	 */
	public boolean canInput() {
		boolean canInput = false;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String[] inputDistance = scanner.nextLine().split(" ");

		if (inputDistance.length != 4) {
			return canInput;
		}

		try {
			pointA = Integer.parseInt(inputDistance[0]);
			pointB = Integer.parseInt(inputDistance[1]);
			pointC = Integer.parseInt(inputDistance[2]);
			speakArea = Integer.parseInt(inputDistance[3]);
		} catch (NumberFormatException e) {
			return canInput;
		}

		if (pointA < DistanceRange.MinDistance.getRange() || pointA > DistanceRange.MaxDistance.getRange()
				|| pointB < DistanceRange.MinDistance.getRange() || pointB > DistanceRange.MaxDistance.getRange()
				|| pointC < DistanceRange.MinDistance.getRange() || pointC > DistanceRange.MaxDistance.getRange()
				|| speakArea < DistanceRange.MinDistance.getRange()
				|| speakArea > DistanceRange.MaxDistance.getRange()) {
			return canInput;
		}
		canInput = true;
		return canInput;
	}

	/**
	 * @return pointA
	 */
	public int getPointA() {
		return pointA;
	}

	/**
	 * @param pointA セットする pointA
	 */
	public void setPointA(int pointA) {
		this.pointA = pointA;
	}

	/**
	 * @return pointB
	 */
	public int getPointB() {
		return pointB;
	}

	/**
	 * @param pointB セットする pointB
	 */
	public void setPointB(int pointB) {
		this.pointB = pointB;
	}

	/**
	 * @return pointC
	 */
	public int getPointC() {
		return pointC;
	}

	/**
	 * @param pointC セットする pointC
	 */
	public void setPointC(int pointC) {
		this.pointC = pointC;
	}

	/**
	 * @return speakArea
	 */
	public int getSpeakArea() {
		return speakArea;
	}

	/**
	 * @param speakArea セットする speakArea
	 */
	public void setSpeakArea(int speakArea) {
		this.speakArea = speakArea;
	}
}
