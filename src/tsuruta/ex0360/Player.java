package ex0360;

/**
 * プレイヤーの入力処理を管理します。
 *
 * @author 鶴田竜也
 */
public class Player {

	/** 自分の使用するコマ */
	private String myPiece;
	/** 相手の使用するコマ */
	private String enemyPiece;
	/** 自分が使用するコマの色 */
	private String myPieceColor;

	/**
	 * playerの使用するコマを設定します。
	 *
	 * @param myPiece 自分の使用するコマ
	 * @param enemyPiece 相手の使用するコマ
	 */
	public Player(String myPiece, String enemyPiece, String colorName) {
		this.myPiece = myPiece;
		this.enemyPiece = enemyPiece;
		this.myPieceColor = colorName;
	}

	/**
	 * 自分が使用しているコマを取得します。
	 *
	 * @return 自分の使用するコマ
	 */
	public String getMyPiece() {
		return myPiece;
	}

	/**
	 * 自分の使用するコマをセットします。
	 *
	 * @param myPiece 自分の使用するコマ
	 */
	public void setMyPiece(String myPiece) {
		this.myPiece = myPiece;
	}

	/**
	 * 相手のコマを取得します。
	 *
	 * @return 相手の使用するコマ
	 */
	public String getEnemyPiece() {
		return enemyPiece;
	}

	/**
	 * 相手の使用するコマをセットします。
	 *
	 * @param enemyPiece 相手の使用するコマ
	 */
	public void setEnemyPiece(String enemyPiece) {
		this.enemyPiece = enemyPiece;
	}

	/**
	 * 自分が使うコマの色を取得します。
	 *
	 * @return 自分が使うコマの色
	 */
	public String getMyPieceColor() {
		return myPieceColor;
	}

	/**
	 * 自分が使うコマの色をセットします。
	 *
	 * @param myPiececolor 自分が使うコマの色
	 */
	public void setMyPieceColor(String myPieceColor) {
		this.myPieceColor = myPieceColor;
	}
}
