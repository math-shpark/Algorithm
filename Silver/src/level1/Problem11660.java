package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11660 {

	// 11660. 구간 합 구하기 5
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 매개변수 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 점수 배열
		int[][] scores = new int[N + 1][N + 1];
		// 다이나믹 프로그래밍 배열(누적합)
		int[][] dp = new int[N + 1][N + 1];

		// 점수 정보 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] += dp[i][j - 1] + scores[i][j] + dp[i - 1][j] - dp[i - 1][j - 1];
			}
		}

		// 결과 계산
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int sum = dp[x2][y2];

			sum -= dp[x2][y1 - 1];
			sum -= dp[x1 - 1][y2];
			sum += dp[x1 - 1][y1 - 1];

			sb.append(sum).append('\n');
		}

		System.out.println(sb);

	}

}
