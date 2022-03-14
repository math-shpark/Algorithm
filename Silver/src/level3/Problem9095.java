package level3;

import java.util.Scanner;

public class Problem9095 {

	// 9095. 1, 2, 3 더하기
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수
		int testCase = scan.nextInt();

		for (int test = 1; test <= testCase; test++) {
			// n 입력
			int n = scan.nextInt();
			// 다이나믹 프로그래밍 배열
			int[] dp = new int[n + 1];

			// 1부터 3까지는 고정 값
			dp[1] = 1;
			if (n > 1) {
				dp[2] = 2;
			}
			if (n > 2) {
				dp[3] = 4;
			}

			// 4부터 점화식 사용
			// n을 1, 2, 3으로 표현하는 개수
			// n = (n-1) + 1로 표현할 경우 dp[n-1] 개수만큼에 각각 1을 추가하는 것과 동일
			// n = (n-2) + 2로 표현할 경우 dp[n-2] 개수만큼에 각각 2를 추가하는 것과 동일
			// n = (n-3) + 3으로 표현할 경우 dp[n-3] 개수만큼에 각각 3을 추가하는 것과 동일
			// 따라서 점화식은 dp[n-1] + dp[n-2] + dp[n-3]
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}

			// 결과 출력
			System.out.println(dp[n]);
		}

		scan.close();

	}

}
