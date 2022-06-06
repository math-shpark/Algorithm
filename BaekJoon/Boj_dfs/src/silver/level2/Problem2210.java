package silver.level2;

import java.util.HashSet;
import java.util.Scanner;

public class Problem2210 {

	static int[][] board;
	static HashSet<Integer> set;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		board = new int[5][5];
		set = new HashSet<>();

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				board[r][c] = scan.nextInt();
			}
		}

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				dfs(r, c, 1, board[r][c]);
			}
		}

		System.out.println(set.size());
	}

	private static void dfs(int r, int c, int count, int num) {
		if (count == 6) {
			set.add(num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];

			if (newR < 0 || newR >= 5 || newC < 0 || newC >= 5)
				continue;

			dfs(newR, newC, count + 1, num * 10 + board[newR][newC]);
		}

	}

}
