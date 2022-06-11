package silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2644 {

	static int count = -1; // relation count
	static int[][] map;
	static boolean[] isChecked = new boolean[101];

	// 2644. 촌수 계산
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int p = Integer.parseInt(br.readLine()); // people number

		StringTokenizer st = new StringTokenizer(br.readLine());
		int go = Integer.parseInt(st.nextToken()); // start
		int ed = Integer.parseInt(st.nextToken()); // end

		int r = Integer.parseInt(br.readLine()); // relation number

		map = new int[101][101]; // relation table

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());

			int one = Integer.parseInt(st.nextToken()); // related person info
			int two = Integer.parseInt(st.nextToken());

			map[one][two] = 1; // relation mark
			map[two][one] = 1;
		}

		dfs(go, ed, 0); // DFS

		System.out.println(count); // print

	}

	private static void dfs(int now, int end, int move) {
		if (now == end) {
			count = move;
			return;
		} // standard

		isChecked[now] = true;

		for (int i = 1; i <= 100; i++) {
			if (map[now][i] == 1 && !isChecked[i]) {
				dfs(i, end, move + 1);
			}
		}

	}

}
