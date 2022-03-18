package level3;

import java.util.Scanner;

public class Problem11727 {

	// 11727. 2xn 타일링 2
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 가로 길이 입력
		int n = scan.nextInt();

		// 다이나믹 프로그래밍 배열
		int[] dp = new int[n + 2];

		// 초기값 입력
		dp[1] = 1;
		dp[2] = 3;

		// 점화식 반복
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}

		// 결과 출력
		System.out.println(dp[n]);

		scan.close();

	}

}
