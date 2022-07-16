package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1197 {

	private static class Node implements Comparable<Node> {
		int s, e, v;

		public Node(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return this.v - o.v;
		}

	}

	private static int E, V, sum;
	private static int[] parent;
	private static List<Node> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		parent = new int[E + 1];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new Node(s, e, v));
		}

		Collections.sort(list);

		int size = list.size();
		for (int i = 0; i < size; i++) {
			Node n = list.get(i);
			if (!check(n.s, n.e)) {
				sum += n.v;
				union(n.s, n.e);
			}

		}

		System.out.println(sum);

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static boolean check(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return true;
		else
			return false;
	}

}
