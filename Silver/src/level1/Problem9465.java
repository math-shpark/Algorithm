package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 0; test < testCase; test++) {
			// 배열 크기 입력
			int n = Integer.parseInt(br.readLine());

			// 점수 배열
			int[][] scores = new int[2][n + 1];
			// 다이나믹 프로그래밍 배열
			int[][] dp = new int[2][n + 1];

			// 점수 정보 입력
			StringTokenizer st;
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= n; k++) {
					scores[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = scores[0][1];
			dp[1][1] = scores[1][1];

			// 다이나믹 프로그래밍
			for (int j = 2; j <= n; j++) {
				// 윗 줄의 스티커를 선택한 경우
				// 반대편 행의 이전 열과, 그 이전 열의 값 중 큰 값 하나만 선택할 수 있다.
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + scores[0][j];
				// 아래 줄의 스티커를 선택한 경우도 마찬가지
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + scores[1][j];
			}

			// 위 줄로 도착한 경우와 아래 줄로 도착한 경우 중 최대값을 출력
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}

}
