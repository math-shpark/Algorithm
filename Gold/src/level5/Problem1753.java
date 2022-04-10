package level5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1753 {

	static class Node implements Comparable<Node> {
		int endNode, value;

		public Node(int end, int weight) {
			this.endNode = end;
			this.value = weight;
		}

		@Override
		// 오름차순 정렬
		public int compareTo(Node o) {
			return value - o.value;
		}
	}

	private static final int INF = 100_000_000;
	static int V, E;
	static int startNode;
	static List<Node>[] list;
	static int[] dist;

	// 1753. 최단 경로
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 매개변수 입력
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		startNode = Integer.parseInt(br.readLine());

		// 배열 크기 입력
		list = new ArrayList[V + 1];
		dist = new int[V + 1];

		Arrays.fill(dist, INF);

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		// 리스트에 그래프 정보를 초기화
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 연결 노드 리스트에 추가
			list[start].add(new Node(end, weight));
		}

		// 다익스트라 알고리즘
		dijkstra(startNode);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	// 다익스트라
	private static void dijkstra(int start) {
		// 우선순위 큐 생성
		PriorityQueue<Node> que = new PriorityQueue<>();
		
		// 탐색 여부 배열
		boolean[] isVisited = new boolean[V + 1];
		// 출발 노드 추가
		que.add(new Node(start, 0));
		// 출발 노드 비용 0 입력
		dist[start] = 0;

		while (!que.isEmpty()) {
			Node now = que.poll();
			int next = now.endNode;

			if (isVisited[next] == true)
				continue;
			isVisited[next] = true;

			for (Node node : list[next]) {
				if (dist[node.endNode] > dist[next] + node.value) {
					dist[node.endNode] = dist[next] + node.value;
					que.add(new Node(node.endNode, dist[node.endNode]));
				}
			}
		}
	}

}
