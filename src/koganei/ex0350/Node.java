package koganei.ex0350;

/**
 * ノードクラス
 * ノード情報を管理します
 *
 * 参考URL:http://nw.tsuda.ac.jp/lec/dijkstra/
 *
 * @author 小金井 広輝
 */
public class Node {
	//ノード番号
	private int nodeNumber;
	//ノード0から自身の地点までの距離 ※初期設定では値を∞に設定しています
	private int distance;
	//ノード0から自身の地点までの距離が未確定（false）か確定（true）か
	private boolean edgeCheck;
	//ノード0から自身のノードまでの経由してきた経路情報
	private String ansText;

	/**
	 * 初期値として設定します
	 *
	 * @param nodeNumber ノード番号
	 * @param distance ノード0から自身の地点までの距離
	 * @param edgeCheck 未確定の地点か否か
	 */
	public Node(int nodeNumber, int distance, boolean edgeCheck) {
		this.nodeNumber = nodeNumber;
		this.distance = distance;
		this.edgeCheck = edgeCheck;
		if (this.nodeNumber == 0) {
			this.ansText = "頂点" + nodeNumber + "確定。  距離 =" + distance + "\n";
		}
	}

	/**
	 * 現在持っているノード0から自身までの最短経路と
	 * 新たにノードを経由してきた経路のうち、どちらが短いかの判定を行い、
	 * それに応じて、自身の最短経路と経路情報を更新します
	 *
	 * @param distance ノード0から自身の地点までの距離
	 * @param ansText ノード0から自身のノードのひとつ前のノードまでの経路情報
	 */
	public void judgeMinDistance(int distance, String ansText) {
		if (distance < this.distance) {
			this.distance = distance;
			this.ansText = ansText + "頂点" + this.nodeNumber + "確定。  距離 =" + distance + "\n";
		}
	}

	/**
	 * ノード番号を返します
	 *
	 * @return ノード番号
	 */
	public int getNodeNumber() {
		return nodeNumber;
	}

	/**
	 * ノード番号を設定します
	 *
	 * @param nodeNumber ノード番号
	 */
	public void setNodeNumber(int nodeNumber) {
		this.nodeNumber = nodeNumber;
	}

	/**
	 * ノード0から自身の地点までの距離を返します
	 *
	 * @return distance ノード0から自身のノード地点までの距離
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * ノード0から自身の地点までの距離を設定します
	 *
	 * @param distance ノード0から自身のノード地点までの距離
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * 未確定の地点か否かを返します
	 *
	 * @return pathCheck 未確定の地点か否か
	 */
	public boolean getEdgeCheck() {
		return edgeCheck;
	}

	/**
	 * 未確定の地点か否かを設定します
	 *
	 * @param edgeCheck 未確定の地点か否か
	 */
	public void setEdgeCheck(boolean edgeCheck) {
		this.edgeCheck = edgeCheck;
	}

	/**
	 *ノード0から自身のノードまでの経由してきた経路情報を返します
	 *
	 * @return ansText 経路情報
	 */
	public String getAnsText() {
		return ansText;
	}

	/**
	 * ノード0から自身のノードまでの経由してきた経路情報を設定します
	 *
	 * @param ansText 経路情報
	 */
	public void setAnsText(String ansText) {
		this.ansText = ansText;
	}
}
