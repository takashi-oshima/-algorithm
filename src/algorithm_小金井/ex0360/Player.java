package ex0360;

import java.util.Scanner;

import ex0360.Ex0360.InputPattern;

/**
 * プレイヤークラス
 * プレイヤーが持つ情報を管理するクラス
 *
 * @author 小金井 広輝
 */
public class Player {

	//名前（黒 or 白）
	private String colorName;
	//石（● or ○）
	private String myStone;
	//自身にとっての相手の石（● or ○）
	private String opponentStone;
	//ボードに自身の石がいくつあるかの個数
	private int stoneCount;
	//入力した行数、列数
	private int row;
	private int column;

	/**
	 * 初期値として設定します
	 *
	 * @param name 名前
	 * @param myStone 石
	 * @param opponentStone 自身にとっての相手の石
	 * @param board ボード
	 */
	public Player(String name, String myStone, String opponentStone, Board board) {
		this.colorName = name;
		this.myStone = myStone;
		this.opponentStone = opponentStone;
		//ボードから自分の石がいくつあるか取得し、それを設定します
		setStoneCount(board);
	}

	/**
	 * 入力された文字列を取得し、どのような文字列か判定し行数と列数を設定します。
	 * その後、結果を返します
	 *
	 * @return 判定結果
	 */
	public InputPattern setRowColumn() {

		//キーボードから入力値を取得できるようにします
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n" + this.colorName + "の手（行、列）＞");
		String[] inputString = scanner.nextLine().split(",");

		if (inputString.length == 2 && inputString[0].matches("[1-8]") && inputString[1].matches("[1-8]")) {
			//入力形式が正しい場合、行数と列数を取得します
			this.row = Integer.parseInt(inputString[0]);
			this.column = Integer.parseInt(inputString[1]);
			return InputPattern.InputOK;
		} else if (inputString.length == 1 && inputString[0].equals(Ex0360.PASS)) {
			//パスの場合
			return InputPattern.Pass;
		} else {
			//入力した文字が読み込めない場合
			return InputPattern.Error;
		}
	}

	/**
	 * 入力した行数を返します
	 *
	 * @return row 自身の入力した行数
	 */
	public int getRow() {
		return row;
	}

	/**
	 * 入力した列数を返します
	 *
	 * @return column 入力した列数
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * 石を返します
	 *
	 * @return myStone 自身の石
	 */
	public String getMyStone() {
		return myStone;
	}

	/**
	 * 自身の石を設定します
	 *
	 * @param myStone 自身の石
	 */
	public void setMyStone(String myStone) {
		this.myStone = myStone;
	}

	/**
	 * 自身にとっての相手の石を返します
	 *
	 * @return opponentStone 自身にとっての相手の石
	 */
	public String getOpponentStone() {
		return opponentStone;
	}

	/**
	 * 自身にとっての相手の石を設定します
	 *
	 * @param opponentStone 自身にとっての相手の石
	 */
	public void setOpponentStone(String opponentStone) {
		this.opponentStone = opponentStone;
	}

	/**
	 * 名前を返します
	 *
	 * @return name 名前
	 */
	public String getColorName() {
		return colorName;
	}

	/**
	 * 名前を設定します
	 *
	 * @param name 名前
	 */
	public void setColerName(String colorName) {
		this.colorName = colorName;
	}

	/**
	 * 自身の持っている石の数を返します
	 *
	 * @return stoneCount 自身の持っている石の数
	 */
	public int getStoneCount() {
		return stoneCount;
	}

	/**
	 * 自身の持っている石の数を設定します
	 *
	 * @param board ボード
	 */
	public void setStoneCount(Board board) {
		this.stoneCount = board.getStoneCount(myStone);
	}

	/**
	 * 現在のプレイヤーの持つ石の数を表示します
	 */
	public void showStoneCount() {
		System.out.print(myStone + "：" + stoneCount + " ");
	}
}
