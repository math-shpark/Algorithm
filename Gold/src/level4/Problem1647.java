package level4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1647 {

	private static int n, m;
	private static PriorityQueue<Node> q;
	private static int[] parent;

	private static class Node implements Comparable<Node> {
		int s;
		int e;
		int val;

		public Node(int s, int e, int val) {
			this.s = s;
			this.e = e;
			this.val = val;
		}

		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		m = scan.nextInt();

		q = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			int cost = scan.nextInt();
			q.offer(new Node(s, e, cost));
		}

		parent = new int[n + 1];
		System.out.println(kruskal());
	}

	private static int kruskal() {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int count = 0;
		int dist = 0;
		while (count < n - 2) {
			Node node = q.poll();
			int p1 = find(node.s);
			int p2 = find(node.e);

			if (p1 != p2) {
				union(p1, p2);
				dist += node.val;
				count++;
			}
		}
		return dist;
	}

	private static void union(int a, int b) {
		parent[a] = b;
	}

	private static int find(int a) {
		if (parent[a] == a)
			return a;
		else
			return parent[a] = find(parent[a]);
	}

}
