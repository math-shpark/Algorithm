package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int n, m;
		n = Integer.parseInt(br.readLine()); // City
		m = Integer.parseInt(br.readLine()); // Bus

		int[][] connect = new int[n][n];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (r == c)
					continue;
				connect[r][c] = 999999999;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int s, e, v;
			s = Integer.parseInt(st.nextToken()) - 1;
			e = Integer.parseInt(st.nextToken()) - 1;
			v = Integer.parseInt(st.nextToken());

			connect[s][e] = Math.min(connect[s][e], v);
		}

		for (int c = 0; c < n; c++) {
			for (int s = 0; s < n; s++) {
				for (int e = 0; e < n; e++) {
					if (connect[s][e] > connect[s][c] + connect[c][e])
						connect[s][e] = connect[s][c] + connect[c][e];
				}
			}
		} // Floyd Warshall

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (connect[r][c] == 999999999)
					System.out.print(0);
				else
					System.out.print(connect[r][c]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
