package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14500 {

	// 14500. 테트로미노
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] space = new int[N][M];
		int maxSum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dr = new int[5][3];
		int[][] dc = new int[5][3];

		int[] dr1 = { 0, 0, 0 };
		int[] dc1 = { 1, 1, 1 };

		int[] dr2 = { 0, 1, 0 };
		int[] dc2 = { 1, 0, -1 };

		int[] dr3 = { 1, 1, 0 };
		int[] dc3 = { 0, 0, 1 };

		int[] dr4 = { 1, 0, 1 };
		int[] dc4 = { 0, 1, 0 };

		int[] dr5 = { 0, 1, -1 };
		int[] dc5 = { 1, 0, 1 };

		dr[0] = dr1;
		dr[1] = dr2;
		dr[2] = dr3;
		dr[3] = dr4;
		dr[4] = dr5;

		dc[0] = dc1;
		dc[1] = dc2;
		dc[2] = dc3;
		dc[3] = dc4;
		dc[4] = dc5;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 5; k++) {
					int tempSum = space[i][j];
					int newX = i;
					int newY = j;
					for (int l = 0; l < 3; l++) {
						newX = newX + dr[k][l];
						newY = newY + dc[k][l];

						if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
							break;
						}

						tempSum += space[newX][newY];
					}
					if (maxSum < tempSum) {
						maxSum = tempSum;
					}
				}
			}
		}

		System.out.println(maxSum);

	}

}
