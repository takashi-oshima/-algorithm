package takai.ex0350;

/**
 * 経路の情報を持つクラスです
 *
 * @author 高井勇輝
 *
 */
public class Route {
	/** 接続元ノード,接続先ノード */
	private Node connectFrom, destination;
	/** 距離 */
	private int cost;

	public Route(Node srcNode, Node dstNode, int cost) {
		this.connectFrom = srcNode;
		this.destination = dstNode;
		this.cost = cost;
	}

	/**
	 * @return srcNode
	 */
	public Node getSrcNode() {
		return connectFrom;
	}

	/**
	 * @return dstNode
	 */
	public Node getDstNode() {
		return destination;
	}

	/**
	 * @return cost
	 */
	public int getCost() {
		return cost;
	}
}
