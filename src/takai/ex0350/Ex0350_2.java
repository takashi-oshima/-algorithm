package takai.ex0350;

import java.util.ArrayList;
import java.util.List;

/**
 * ノード0からノード6までの最短経路の長さを求めるクラスです。
 *
 * @author	高井勇輝
 */
public class Ex0350_2 {
	/** ノードの総数 */
	final int TOTAL_NODE = 7;
	/** ノードの接続関係のマップ */
	final int[][] MAP = { { 0, 4, 5, -1, 2, -1, -1 }, { 4, 0, 6, 4, 3, -1, -1 }, { 5, 6, 0, 6, -1, -1, 10 },
			{ -1, 4, 6, 0, 6, 2, 6 }, { 2, 3, -1, 6, 0, 9, -1 }, { -1, -1, -1, 2, 9, 0, 3 },
			{ -1, -1, 10, 6, 3, -1, 0 } };
	/** 出発地点 */
	final int START_NODE = 0;
	/** 到着地点 */
	final int GOAL_NODE = 6;

	public void main(String[] args) {
		/** 各ノードまでの最短距離 */
		int[] nodeDistance = new int[TOTAL_NODE];
		/** 経由地 */
		int[] viaNode = new int[TOTAL_NODE];
		/** 結果出力用の文字列 */
		List<String> outputTxt = new ArrayList<>();

		dijkstra(nodeDistance, viaNode);
		// 指定地点への到達方法が存在しない場合の表示です。
		if (nodeDistance[GOAL_NODE] == Integer.MAX_VALUE) {
			System.out.println("指定した地点に到達することは不可能です。");
		} else {
			// 指定地点への最短距離を経由地までのも含めて表示します。
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
	 * 出発地点から、経由地を含めた到着地点までの距離を算出します。
	 *
	 * @param nodeDistance 各ノードまでの最短距離
	 * @param viaNode 経由地
	 */
	public void dijkstra(int[] nodeDistance, int[] viaNode) {
		/** 最短距離が確定したかの判定 */
		boolean[] fixed = new boolean[TOTAL_NODE];
		// 各ノードについて初期化します。
		for (int i = 0; i < TOTAL_NODE; i++) {
			// 最短距離の初期値は無限遠とします。
			nodeDistance[i] = Integer.MAX_VALUE;
			// 最短距離はまだ確定していません。
			fixed[i] = false;
			// どの経由地も通過していません。
			viaNode[i] = -1;
		}
		// 出発地点までの距離を0とします。
		nodeDistance[START_NODE] = 0;
		while (true) {
			// 未確定ノードの中で最も近いノードを求めます。
			int tempDistance = minIndex(nodeDistance, fixed);
			// 全ノードが確定した場合処理を抜けます。
			if (tempDistance < 0) {
				return;
			}
			// 指定地点への到達方法が存在しない場合、処理を抜けます。
			if (nodeDistance[tempDistance] == Integer.MAX_VALUE) {
				return;
			}
			// そのノードまでの最短距離が確定します。
			fixed[tempDistance] = true;
			// 隣のノード(i)について
			for (int j = 0; j < TOTAL_NODE; j++) {
				// 未確定ならば
				if (MAP[tempDistance][j] > 0 && !fixed[j]) {
					// そのノードを経由した距離を求めます。
					int viaDistance = nodeDistance[tempDistance] + MAP[tempDistance][j];
					// 今までの距離よりも小さければ、それを格納します。
					if (viaDistance < nodeDistance[j]) {
						nodeDistance[j] = viaDistance;
						// 経由地を書き換えます。
						viaNode[j] = tempDistance;
					}
				}
			}
		}
	}

	/**
	 * まだ距離が確定していないノードの中で、最も距離が近いものを探します。
	 *
	 * @param nodeDistance 各ノードまでの距離
	 * @param fixed 最短距離が確定したかの判定
	 * @return 各ノードまでの距離
	 */
	public int minIndex(int[] nodeDistance, boolean[] fixed) {
		// 各ノードまでの距離です。
		int tempDistance = 0;
		// 未確定のノードをどれか一つ探します。
		for (tempDistance = 0; tempDistance < fixed.length; tempDistance++) {
			if (!fixed[tempDistance]) {
				break;
			}
		}
		// 未確定のノードが存在しなければ-1を返します。
		if (tempDistance == fixed.length) {
			return -1;
		}
		// 距離が小さいものを探します。
		for (int i = tempDistance + 1; i < fixed.length; i++) {
			if (!fixed[i] && nodeDistance[i] < nodeDistance[tempDistance]) {
				tempDistance = i;
			}
		}
		return tempDistance;
	}
}