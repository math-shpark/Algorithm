package silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3187 {

	static char[][] map;
	static boolean[][] isVisited;
	static int s, w;
	static int[] dr = { -1, 0, 1, 0 }; // delta
	static int[] dc = { 0, 1, 0, -1 };

	private static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row, col;
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new char[row][col]; // map
		isVisited = new boolean[row][col]; // check

		s = 0; // sheep
		w = 0; // wolf

		for (int r = 0; r < row; r++) {
			String data = br.readLine();
			for (int c = 0; c < col; c++) {
				char input = data.charAt(c);
				map[r][c] = input;
				if (input == 'k')
					s++;
				else if (input == 'v')
					w++;
			}
		} // data input

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (isVisited[r][c])
					continue;
				if (map[r][c] == '#')
					continue;
				bfs(r, c);
			}
		}

		System.out.println(s + " " + w); // print

	}

	private static void bfs(int row, int col) {
		Queue<Node> bfsQue = new LinkedList<>();
		bfsQue.add(new Node(row, col));

		int sheep = 0;
		int wolf = 0;

		isVisited[row][col] = true;

		while (!bfsQue.isEmpty()) {
			Node now = bfsQue.poll();

			if (map[now.r][now.c] == 'v')
				wolf++;

			if (map[now.r][now.c] == 'k')
				sheep++;

			for (int i = 0; i < 4; i++) {
				int newR = now.r + dr[i];
				int newC = now.c + dc[i];

				if (newR < 0 || newC < 0 || newR >= map.length || newC >= map[0].length)
					continue; // range check

				if (isVisited[newR][newC])
					continue; // backtracking

				if (map[newR][newC] == '#')
					continue;

				bfsQue.add(new Node(newR, newC));
				isVisited[newR][newC] = true;
			}
		}

		if (wolf >= sheep)
			s -= sheep;
		else
			w -= wolf;
	}

}
