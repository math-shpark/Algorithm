package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra2 {
	static class Node implements Comparable<Node> {
		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		dist = new int[V];
		Arrays.fill(dist, INF);

		// 간선 입력
		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			adjList[st].add(new Node(ed, w));
		}

		dijkstra(0);

		System.out.println(Arrays.toString(dist));

	}

	static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V];

		pq.add(new Node(st, 0));
		// 시작 노드까지의 거리는 0
		dist[st] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.v])
				continue;
			visited[curr.v] = true;

			for (Node node : adjList[curr.v]) {
				if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.weight) {
					dist[node.v] = dist[curr.v] + node.weight;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}

		}

	}

}
