package silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13565 {

	private static int m, n;
	private static int[][] cloth;
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };
	private static boolean[][] isChecked;
	private static boolean isArrived = false;

	private static class Node {
		int row, col;

		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); // M(row)
		n = Integer.parseInt(st.nextToken()); // N(column)

		cloth = new int[m][n]; // cloth info
		isChecked = new boolean[m][n]; // backtracking

		for (int r = 0; r < m; r++) {
			String row = br.readLine();
			for (int c = 0; c < n; c++) {
				cloth[r][c] = (int) (row.charAt(c) - '0');
			}
		} // cloth data

		for (int c = 0; c < n; c++) {
			if (isArrived)
				break; // backtracking
			if (cloth[0][c] == 1)
				continue; // condition
			bfs(0, c); // BFS
		}

		if (isArrived)
			System.out.println("YES"); // print(success)
		else
			System.out.println("NO"); // print(fail)

	}

	private static void bfs(int row, int col) {
		Queue<Node> bfsQue = new LinkedList<>();
		bfsQue.add(new Node(row, col));
		isChecked[row][col] = true;

		while (!bfsQue.isEmpty()) {
			Node now = bfsQue.poll();

			if (now.row == m - 1) {
				isArrived = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int newR = now.row + dr[i];
				int newC = now.col + dc[i];

				if (newR < 0 || newC < 0 || newR >= m || newC >= n)
					continue;

				if (isChecked[newR][newC])
					continue;

				if (cloth[newR][newC] == 1)
					continue;

				isChecked[newR][newC] = true;
				bfsQue.add(new Node(newR, newC));
			}

		}

	}

}
