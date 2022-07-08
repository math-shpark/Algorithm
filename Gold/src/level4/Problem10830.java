package level4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem10830 {

	public static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken()); // N

		int[][] origin = new int[n][n];
		int[][] result = new int[n][n];

		long b = Long.parseLong(st.nextToken()); // B

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
			result[i][i] = 1; // I_n
		}

		while (b > 0) {
			if (b % 2 == 1) {
				result = multiply(result, origin);
			}
			origin = multiply(origin, origin);

			b /= 2;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb); // print
	}

	public static int[][] multiply(int[][] m1, int[][] m2) {

		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
					result[i][j] %= 1000;
				}
			}
		}
		return result;
	}

}
