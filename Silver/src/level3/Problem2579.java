package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2579 {

	// 2579. 계단 오르기
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 계단 수
		int stair = Integer.parseInt(br.readLine());
		// 계단별 점수를 저장할 배열
		int[] scores = new int[stair + 1];

		// 배열에 계단별 점수를 입력하는 반복문
		for (int i = 1; i <= stair; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}

		// 다이나믹 프로그래밍 배열
		int[] dp = new int[stair + 1];

		// 1층일 경우
		dp[1] = scores[1];
		// 계단이 2층이상일 경우
		// 2층까지는 최대 값이 고정값
		if (stair > 1) {
			dp[2] = dp[1] + scores[2];
		}

		// 낮은 층부터 최대 합을 dp 배열에 저장하는 반복문
		for (int i = 3; i <= stair; i++) {

			// 마지막 층은 꼭 밟아야 하므로
			// 가능한 경우는 2가지
			// 1. 마지막 전 층을 밟거나
			// 마지막 전 층을 밟으면 연속 3층은 밟지 못하고, 최대 1개층만 건너뛸 수 있으므로 마지막 층에서 3개층 밑은 꼭 밟아야 함
			// 따라서 마지막 전 층을 밟으면 마지막 - 3 층 최대 합에서 마지막 전 층 점수와 마지막층 점수를 더한 것이 1번 경우 결과
			// 2. 마지막 전 층을 밟지 않거나
			// 마지막 전 층을 밟지 않으면 최대 1개층만 건너뛸 수 있으므로
			// 마지막 - 2층은 꼭 밟아야 하므로 마지막 - 2층의 최대합에 마지막 층 점수를 더한 것이 2번 경우의 결과
			// 최대합이 필요하므로 1번 경우와 2번 경우의 결과 중 더 큰 값을 취함
			dp[i] = Math.max(dp[i - 3] + scores[i - 1] + scores[i], dp[i - 2] + scores[i]);

		}

		// 결과 출력
		System.out.println(dp[stair]);

	}

}
