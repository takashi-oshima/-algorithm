package ex0350;

/**
 * メインクラス
 * ノード0 からノード6 までの最短経路の長さを求めます
 *
 * 参考URL:http://nw.tsuda.ac.jp/lec/dijkstra/
 *
 * @author 小金井 広輝
 */
public class Ex0350 {
	/** ノードの総数 */
	public static final int NODE_COUNT = 7;
	/** スタート地点のノード番号 */
	public static final int START_NODE = 0;
	/** ゴール地点のノード番号 */
	public static final int GOAL_NODE = 6;
	/** 未確定距離を∞に設定 */
	public static final int UNFIXED_DISTANCE = Integer.MAX_VALUE;

	public static void main(String[] args) {

		//各ノードの接続関係を設定
		int[][] edge = new int[NODE_COUNT][NODE_COUNT];
		edge[0][2] = edge[2][0] = 5;
		edge[0][1] = edge[1][0] = 4;
		edge[0][4] = edge[4][0] = 2;
		edge[1][3] = edge[3][1] = 4;
		edge[1][4] = edge[4][1] = 3;
		edge[2][1] = edge[1][2] = 6;
		edge[2][3] = edge[3][2] = 6;
		edge[2][6] = edge[6][2] = 10;
		edge[3][6] = edge[6][3] = 6;
		edge[3][5] = edge[5][3] = 2;
		edge[3][4] = edge[4][3] = 6;
		edge[5][4] = edge[4][5] = 9;
		edge[5][6] = edge[6][5] = 3;

		//ノードの配列を作成し、各地点までの距離を未確定とし、とりあえず無限大としておきます。
		//ただしノード0（始点）の距離は0とおきます。
		Node[] node = new Node[NODE_COUNT];
		node[0] = new Node(START_NODE, 0, false);
		for (int i = 1; i < NODE_COUNT; i++) {
			node[i] = new Node(i, UNFIXED_DISTANCE, false);
		}

		//ノード0からノード6までの最短経路を取得するまでループします
		Node minDistanceNode;
		while (true) {
			//未確定の中から距離が最も小さい地点を取得します
			minDistanceNode = getMinDistanceNode(node);

			//現在の各ノードの情報一覧を表示します（確認用）
			nodeInformation(node, minDistanceNode);

			if (minDistanceNode.getNodeNumber() == GOAL_NODE) {
				//ノード0からノード6までの最短経路を取得した場合
				break;
			}

			//ノードの持つ距離を設定します
			setDistance(edge, node, minDistanceNode);
		}

		//0～6までの最短距離とその経路情報表示します
		System.out.println("Ans：");
		System.out.println(node[GOAL_NODE].getAnsText());
	}

	/**
	 * 未確定の中から距離が最も小さい地点を選び、そのノードを取得します
	 *
	 * @param node ノード配列
	 * @return 距離が最も小さい地点
	 */
	public static Node getMinDistanceNode(Node[] node) {
		int minDistance = UNFIXED_DISTANCE;
		Node minDistanceNode = null;
		for (int i = 0; i < node.length; i++) {
			//距離が最も小さい地点かつ未確定である地点を求めます
			if (node[i].getDistance() < minDistance && !node[i].getEdgeCheck()) {
				minDistance = node[i].getDistance();
				minDistanceNode = node[i];
			}
		}
		//最も小さい地点を未確定から確定に変えます
		minDistanceNode.setEdgeCheck(true);
		return minDistanceNode;
	}

	/**
	 * 各ノードの持っている情報を表示します
	 *
	 * @param node ノード配列
	 * @param minDistanceNode 距離が最も小さい地点
	 */
	public static void nodeInformation(Node[] node, Node minDistanceNode) {
		for (Node n : node) {
			System.out.println("ノード番号：" + n.getNodeNumber() +
					"  距離：" + String.format("%10d", n.getDistance()) +
					"  確定か否か：" + n.getEdgeCheck());
		}
		System.out.println("ノード番号" + minDistanceNode.getNodeNumber() +
				"＝最短距離：" + minDistanceNode.getDistance() + "\n");
	}

	/**
	 * 距離が最も小さい地点から「直接つながっている」地点に関して
	 * 今確定した場所を経由した場合の距離を 計算し、
	 * 今までの距離よりも小さければ書き直します。
	 *
	 * @param edge 全エッジ
	 * @param node ノード配列
	 * @param minDistanceNode 距離が最も小さい地点
	 */
	public static void setDistance(int[][] edge, Node[] node, Node minDistanceNode) {
		int viaNode = minDistanceNode.getNodeNumber();
		int minDistance = minDistanceNode.getDistance();
		//ある地点のノードから「直接つながっている」地点すべてを抽出します
		for (int i = 0; i < edge[viaNode].length; i++) {
			if (edge[viaNode][i] != 0) {
				//今までの距離よりも小さいかどうかの判定を行います
				node[i].judgeMinDistance(edge[viaNode][i] + minDistance,
						minDistanceNode.getAnsText());
			}
		}
	}
}
