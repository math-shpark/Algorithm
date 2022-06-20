package silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11123 {

	static char[][] map;
	static boolean[][] isChecked;
	static int h, w;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); // test case

		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken()); // height
			w = Integer.parseInt(st.nextToken()); // width

			map = new char[h][w]; // space info
			isChecked = new boolean[h][w]; // backtracking

			for (int r = 0; r < h; r++) {
				String str = br.readLine();
				for (int c = 0; c < w; c++) {
					map[r][c] = str.charAt(c);
				}
			} // input data

			int result = 0; // the number of sheep group
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (isChecked[r][c])
						continue;
					if (map[r][c] == '#') {
						result++;
						dfs(r, c);
					}
				}
			} // group calculation

			System.out.println(result); // print

		}

	}

	private static void dfs(int row, int col) {

		isChecked[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int newR = row + dr[i];
			int newC = col + dc[i];

			if (newR < 0 || newC < 0 || newR >= h || newC >= w)
				continue; // range check

			if (isChecked[newR][newC])
				continue; // backtracking

			if (map[newR][newC] == '#') {
				dfs(newR, newC); // stack
			}
		}
	}

}
