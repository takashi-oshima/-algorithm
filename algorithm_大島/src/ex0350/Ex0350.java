package ex0350;

import java.util.ArrayList;
import java.util.List;

/**
 * ノード 0 からノード 6 までの最短経路の長さを求めます。 ノードの接続関係は二元配列NODE_MAPに記しています。
 *
 * @author 大島
 */
public class Ex0350 {
	/** ノードの接続関係のマップ */
	public final static int[][] NODE_MAP = { { 0, 4, 5, -1, 2, -1, -1 }, { 4, 0, 6, 4, 3, -1, -1 },
			{ 5, 6, 0, 6, -1, -1, 10 }, { -1, 4, 6, 0, 6, 2, 6 }, { 2, 3, -1, 6, 0, 9, -1 }, { -1, -1, -1, 2, 9, 0, 3 },
			{ -1, -1, 10, 6, -1, 3, 0 } };
	/** 出発地点 */
	public final static int START_NODE = 0;
	/** 到着地点 */
	public final static int GOAL_NODE = 6;

	public static void main(String[] args) {
		// 結果出力用の文字列
		List<String> outputTxt = new ArrayList<>();
		// 各ノードまでの最短距離
		int[] nodeDistance = new int[NODE_MAP.length];
		// 出発地点から到着地点までの最短の経由地
		int[] viaNode = new int[NODE_MAP.length];

		// 各ノードまでの最短距離と出発地点から到着地点までの経由地を算出して配列に代入します。
		assignDistanceAndVia(nodeDistance, viaNode);

		// 指定地点への到達方法が存在するかどうかで表示を分けます。
		if (nodeDistance[GOAL_NODE] == Integer.MAX_VALUE) {
			System.out.println("指定した地点に到達することは不可能です。");
		} else {
			// ゴールから経由地を辿っていくループ処理
			for (int i = GOAL_NODE; i != START_NODE; i = viaNode[i]) {
				outputTxt.add("頂点 " + i + " 確定。         距離=" + nodeDistance[i]);
			}
			outputTxt.add("頂点 " + START_NODE + " 確定。         距離=" + nodeDistance[0]);
		}
		for (int i = outputTxt.size() - 1; i >= 0; i--) {
			System.out.println(outputTxt.get(i));
		}
	}

	/**
	 * 各ノードまでの最短距離と出発地点から到着地点までの経由地を算出して配列に代入します。
	 *
	 * @param nodeDistance 各ノードまでの最短距離が代入される配列
	 * @param viaNode 出発地点から到着地点までの最短の経由地が代入される配列
	 */
	public static void assignDistanceAndVia(int[] nodeDistance, int[] viaNode) {
		// 最短距離が確定したかの判定
		boolean[] fixed = new boolean[NODE_MAP.length];
		// 各ノードについて最短距離を無限、最短距離を未確定、経由地を通過なしに初期化します。
		for (int i = 0; i < NODE_MAP.length; i++) {
			nodeDistance[i] = Integer.MAX_VALUE;
			fixed[i] = false;
			viaNode[i] = -1;
		}
		nodeDistance[START_NODE] = 0;
		while (true) {
			// 距離が未確定のノードがあると、その中で、最も距離が近いノードを探します。
			int nearNode = findNearNode(nodeDistance, fixed);

			if (nearNode < 0 || nodeDistance[nearNode] == Integer.MAX_VALUE) {
				return;
			}
			fixed[nearNode] = true;
			// 隣接したノードについて距離が未確定の場合、そのノードを経由した距離を求め、最短距離を格納します。
			for (int j = 0; j < NODE_MAP.length; j++) {

				if (NODE_MAP[nearNode][j] > 0 && fixed[j] == false) {
					int shortDistance = nodeDistance[nearNode] + NODE_MAP[nearNode][j];

					if (shortDistance < nodeDistance[j]) {
						nodeDistance[j] = shortDistance;
						viaNode[j] = nearNode;
					}
				}
			}
		}
	}

	/**
	 * 最短距離が未確定のノードの中で、最も距離が近いノードを探します。
	 *
	 * @param nodeDistance 各ノードまでの最短距離が代入される配列
	 * @param fixed 最短距離が確定したかの判定
	 * @return 距離が確定したノード
	 */
	public static int findNearNode(int[] nodeDistance, boolean[] fixed) {
		int unfixedNode = 0;
		// 距離が未確定のノードを一つ探し、全て確定していれば処理を抜けます。
		for (unfixedNode = 0; unfixedNode < fixed.length; unfixedNode++) {

			if (fixed[unfixedNode] == false) {
				break;
			}
		}

		if (unfixedNode == fixed.length) {
			return -1;
		}
		// 距離が最も近いノードを探します。
		for (int i = unfixedNode + 1; i < fixed.length; i++) {

			if (fixed[i] == false && nodeDistance[i] < nodeDistance[unfixedNode]) {
				unfixedNode = i;
			}
		}
		return unfixedNode;
	}
}