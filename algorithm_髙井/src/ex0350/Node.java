package ex0350;

/**
 * ノードの情報を持つクラスです
 *
 * @author 高井勇輝
 *
 */
public class Node {
	/** ノードの名前 */
	private char label;
	/** 合計距離 */
	private int totalCost;
	/** 接続元の情報 */
	private Node from;

	public Node(char label, Node from) {
		this.label = label;
		this.from = from;
	}

	public Node(char label) {
		this(label, null);
	}

	/**
	 * @return label
	 */
	public char getLabel() {
		return label;
	}

	/**
	 * @return totalCost
	 */
	public int getTotalCost() {
		return totalCost;
	}

	/**
	 * @return from
	 */
	public Node getFrom() {
		return from;
	}

	/**
	 * @param totalCost セットする totalCost
	 */
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @param from セットする from
	 */
	public void setFrom(Node from) {
		this.from = from;
	}
}