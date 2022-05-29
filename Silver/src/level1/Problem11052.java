package level1;

import java.util.Scanner;

public class Problem11052 {

	// 11052. 카드 구매하기
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		int dp[] = new int[n + 1];
		int price[] = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			price[i] = scan.nextInt();
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], price[j] + dp[i - j]);
			}
		}

		System.out.println(dp[n]);

	}

}
