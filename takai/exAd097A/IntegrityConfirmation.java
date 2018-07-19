package takai.exAd097A;

import takai.exAd097A.ExAd097A.Number;
import takai.exAdInput.Input;

/**
 * 入力された値が適切な文字列かを判定するクラスです。
 *
 * @author 高井勇輝
 *
 */
public class IntegrityConfirmation {
	/** 1つ目の入力値 */
	int pointA = 0;
	/** 2つ目の入力値 */
	int pointB = 0;
	/** 3つ目の入力値 */
	int pointC = 0;
	/** 4つ目の入力値 */
	int speakArea = 0;

	/**
	 * @return pointA
	 */
	public int getPointA() {
		return pointA;
	}

	/**
	 * @return pointB
	 */
	public int getPointB() {
		return pointB;
	}

	/**
	 * @return pointC
	 */
	public int getPointC() {
		return pointC;
	}

	/**
	 * @return speakArea
	 */
	public int getSpeakArea() {
		return speakArea;
	}

	/**
	 * @param pointA セットする pointA
	 */
	public void setPointA(int pointA) {
		this.pointA = pointA;
	}

	/**
	 * @param pointB セットする pointB
	 */
	public void setPointB(int pointB) {
		this.pointB = pointB;
	}

	/**
	 * @param pointC セットする pointC
	 */
	public void setPointC(int pointC) {
		this.pointC = pointC;
	}

	/**
	 * @param speakArea セットする speakArea
	 */
	public void setSpeakArea(int speakArea) {
		this.speakArea = speakArea;
	}

	/**
	 * 入力値を受け取り、判定したのちに値を各変数に格納します。
	 */
	public void scanString() {
		//キーボードから入力値を取得できるようにします。

		Input input = new Input();
		String[] inputTxt = input.scan();

		//数値が2つ入力されているかを確認します。
		if (inputTxt.length != 4) {
			System.out.println("入力された文字列が不正です。");
			System.out.println("1以上、100以下の4つの正数を、半角空白区切りで入力してください。");
			return;
		}

		//入力された配列を数値に変換できるか試し、変換できた場合に値が適切なものか判定します。
		if (!isIntNumber(inputTxt[0]) || !isIntNumber(inputTxt[1]) || !isIntNumber(inputTxt[2])
				|| !isIntNumber(inputTxt[3])) {
			System.out.println("不適な文字列です。");
			System.out.println("1以上、100以下の整数を4つ入力してください。");
			return;
		}

		setPointA(Integer.parseInt(inputTxt[0]));
		setPointB(Integer.parseInt(inputTxt[1]));
		setPointC(Integer.parseInt(inputTxt[2]));
		setSpeakArea(Integer.parseInt(inputTxt[3]));
	}

	/**
	 * 入力値を整数に変換できるか判定します。
	 * 変換できた際には1～100の数値であるかも判定します。
	 *
	 * @param inputTxt 入力文字列
	 * @return isInt 判定結果
	 */
	private boolean isIntNumber(String inputTxt) {
		boolean isInt = false;
		int i = 0;
		try {
			i = Integer.parseInt(inputTxt);
		} catch (NumberFormatException e) {
			return isInt;
		}
		if (Number.Start.getNum() <= i && Number.End.getNum() >= i) {
			isInt = true;
		}
		return isInt;
	}
}