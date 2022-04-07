package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1932 {

	// 삼각형 크기
	static int n;
	// 삼각형 정보
	static int[][] space;
	// 다이나믹 프로그래밍
	static int[][] dp;

	// 1932. 정수 삼각형
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 삼각형 크기 입력
		n = Integer.parseInt(br.readLine());

		// 삼각형 정보
		space = new int[n][n];
		dp = new int[n][n];

		// 삼각형 정보 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				space[i][j] = Integer.parseInt(st.nextToken());
				j++;

			}
		}

		// 아직 값을 계산하지 않은 칸은 -1로 표시
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}

		// 맨 밑줄 정보 복사
		for (int i = 0; i < n; i++) {
			dp[n - 1][i] = space[n - 1][i];
		}

		// 최대 합을 구하는 메서드
		int result = process(0, 0);

		// 결과 출력
		System.out.println(result);

	}

	// 최대 합을 구하는 메서드
	// 매개변수 : 행 번호, 열 번호
	private static int process(int row, int col) {

		// 경계
		// 맨 밑 줄에 도착할 경우
		if (row == n - 1) {
			return dp[row][col];
		}

		// 재귀
		if (dp[row][col] == -1) {
			// 좌측 대각선 수를 더한 결과
			int num1 = space[row][col] + process(row + 1, col);
			// 우측 대각선 수를 더한 결과
			int num2 = space[row][col] + process(row + 1, col + 1);

			// 둘 중 최대값을 저장
			dp[row][col] = Math.max(num1, num2);
		}

		return dp[row][col];

	}

}
