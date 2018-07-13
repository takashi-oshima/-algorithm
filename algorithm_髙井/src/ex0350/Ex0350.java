package ex0350;

/**
 * ゴールからスタートまでの経路を総当たりで探索するダイクストラ法のクラスです。
 *
 * @author 高井勇輝
 *
 */
public class Ex0350 {

	public static void main(String[] args) {
		//各ノードを生成します
		Node dummy = new Node('X');
		Node node0 = new Node('0', dummy);
		Node node1 = new Node('1');
		Node node2 = new Node('2');
		Node node3 = new Node('3');
		Node node4 = new Node('4');
		Node node5 = new Node('5');
		Node node6 = new Node('6');

		//各ノードを繋ぐ経路を作成します
		Route[] routes = {
				new Route(node0, node1, 4),
				new Route(node0, node2, 5),
				new Route(node0, node4, 2),
				new Route(node1, node2, 6),
				new Route(node1, node3, 4),
				new Route(node1, node4, 3),
				new Route(node2, node3, 6),
				new Route(node2, node6, 10),
				new Route(node3, node6, 6),
				new Route(node3, node4, 6),
				new Route(node3, node5, 2),
				new Route(node4, node5, 9),
				new Route(node5, node6, 3) };

		//breakするまでループ処理を続けます
		while (true) {
			boolean cont = false;
			for (Route route : routes) {
				/** 接続元ノード */
				Node src = route.getSrcNode();
				/** 接続先ノード */
				Node dst = route.getDstNode();
				if (src.getFrom() == null) {
					continue;
				}
				//接続先ノードへの距離が、接続元への距離と接続先までの距離の和より小さければ
				if (dst.getFrom() == null || src.getTotalCost() + route.getCost() < dst.getTotalCost()) {
					dst.setFrom(src);
					dst.setTotalCost(src.getTotalCost() + route.getCost());
					cont = true;
				}
			}
			if (!cont) {
				break;
			}
		}
		Node node = node6;
		//経路を出力します。
		while (node != dummy) {
			System.out.println("頂点 " + node.getLabel() + "確定。　　距離 = " + node.getTotalCost());
			node = node.getFrom();
		}
	}
}