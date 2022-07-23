package silver.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem6118 {

	private static class Node {
		int node, move;

		Node(int node, int move) {
			this.node = node;
			this.move = move;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n, m;
		int[] results = new int[3];

		Queue<Node> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> map = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<>());
		}

		int start, end;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			map.get(start).add(end);
			map.get(end).add(start);
		}

		queue.add(new Node(1, 0));
		visited[1] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.move > results[1]) {
				results[0] = now.node;
				results[1] = now.move;
				results[2] = 1;
			} else if (now.move == results[1]) {
				results[2]++;
				results[0] = Math.min(results[0], now.node);
			}

			for (int x : map.get(now.node)) {
				if (visited[x])
					continue;

				visited[x] = true;
				queue.add(new Node(x, now.move + 1));
			}
		}

		for (int x : results)
			sb.append(x).append(" ");

		System.out.println(sb);

	}

}
