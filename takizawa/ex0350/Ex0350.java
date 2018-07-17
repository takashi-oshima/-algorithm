package takizawa.ex0350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex0350 {

	public static void main(String[] args) {
		new Ex0350();
	}
	public Ex0350() {
		int node = 7;	 // 全ての頂点を用意
		int start = 0;  // スタート地点を用意
		int goal = 6;   // ゴール地点を用意
		int[] visit = {};

		// マップ情報を取得（接続元ノード、接続先ノード、距離）
		int [][] map = {{0,1,4},
					     {0,2,5},
					     {0,4,2},
					     {1,2,6},
					     {1,3,4},
					     {1,4,3},
					     {2,3,6},
					     {2,6,10},
					     {3,4,6},
					     {3,5,2},
					     {3,6,6},
					     {4,5,9},
					     {5,6,3}};
		@SuppressWarnings("unchecked")
		List<Edge>[] edges = new List[node]; // 要素7つ格納できるリストの作成
		for(int i = 0; i < node; i++) {
			edges[i] = new ArrayList<Edge>(); // リストの初期化
		}
		for(int i = 0; i < visit.length; i++) {
			visit[i] = 0;	//一度訪れたノードを格納するvisitの初期化
		}
		for(int i = 0;i < map.length; i++) {
			edges[map[i][0]].add(new Edge(map[i][0],map[i][1],map[i][2]));
			edges[map[i][1]].add(new Edge(map[i][1],map[i][0],map[i][2]));
		}

		int result = dijkstra(node, edges, start, goal);

	}

	static final int INF = 100100100;

	int dijkstra(int node, List<Edge>[] edges, int start, int goal) {
		int[] shortDistance = new int[node];

		Arrays.fill(shortDistance, INF);
		shortDistance[start] = 0;

		Queue<Edge> q = new PriorityQueue<Edge>();
		q.add(new Edge(start, start, 0));

		while(!q.isEmpty()) {
			Edge e = q.poll();
			if(shortDistance[e.target] < e.cost) {
				continue;
			}
			for(Edge v : edges[e.target]) {
				if(shortDistance[v.target] > shortDistance[e.target] + v.cost) {
				//List<Integer> visit = new ArrayList<>();
				//visit.add(shortDistance[e.target]);
				   shortDistance[v.target] = shortDistance[e.target] + v.cost;
				   q.add(new Edge(e.target, v.target, shortDistance[v.target]));
				}
			}
		}
		return shortDistance[goal];
	}

	class Edge implements Comparable<Edge> {
		public int source = 0;		// 接続元ノード
		public int target = 0;		// 接続先ノード
		public int cost = 0;		// 距離

		public Edge(int source, int target, int cost) {
			this.source = source;
			this.target = target;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge edge) {
			return this.cost - edge.cost;
		}

		@Override
		public String toString() {
			return "score =" + source + ",target =" + target + ", cost =" + cost;
		}
	}
}