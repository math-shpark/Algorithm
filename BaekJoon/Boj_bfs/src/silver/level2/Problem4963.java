package silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem4963 {

	static int[][] map;
	static boolean[][] isChecked;
	static int w, h;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // delta
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static class Location {
		int r, c; // row, column

		Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine()); // map size data

			w = Integer.parseInt(st.nextToken()); // width
			h = Integer.parseInt(st.nextToken()); // height

			if (w == 0 && h == 0)
				break; // end condition

			map = new int[h][w]; // map
			isChecked = new boolean[h][w]; // check log array

			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine()); // data read
				for (int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken()); // data input
				}
			} // map info input

			int result = 0;

			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (isChecked[r][c])
						continue; // backtracking
					if (map[r][c] == 1) {
						result++;
						bfs(r, c); // BFS
					}
				}
			}

			System.out.println(result); // print

		}
	}

	private static void bfs(int row, int col) {

		Queue<Location> bfsQue = new LinkedList<>(); // Queue

		bfsQue.add(new Location(row, col)); // start point
		isChecked[row][col] = true; // mark

		while (!bfsQue.isEmpty()) {
			Location now = bfsQue.poll();

			for (int i = 0; i < 8; i++) {
				int newR = now.r + dr[i];
				int newC = now.c + dc[i];

				if (newR < 0 || newC < 0 || newR >= h || newC >= w)
					continue; // valid range check
				if (isChecked[newR][newC])
					continue; // backtracking
				if (map[newR][newC] == 0)
					continue; // no island point

				isChecked[newR][newC] = true;
				bfsQue.add(new Location(newR, newC));
			}
		}
	}

}
