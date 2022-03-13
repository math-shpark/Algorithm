package level3;

import java.util.Scanner;

public class Problem1463 {

	// 1463. 1로 만들기
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 정수 입력
		int N = scan.nextInt();
		// 다이나믹 프로그래밍 배열
		int[] dp = new int[N + 1];

		// 작은 수부터 입력한 정수까지 최소 횟수를 배열에 저장하는 반복문
		for (int i = 2; i <= N; i++) {
			// 우선 1을 빼서 바로 앞의 수의 최소 횟수를 불러온 후
			// 1을 빼는 연산 횟수가 추가되었으므로 1을 추가한
			// 이전 수의 최소 횟수에 1을 더한 값을 현재 수의 최소 횟수로 입력
			dp[i] = dp[i - 1] + 1;

			// 해당 숫자가 짝수면
			// 2로 나눈 수의 최소 횟수에 2를 나눈 연산이 추가되므로 1을 더함
			// 2로 나눈 수의 최소 횟수에 1을 더한 값이 현재 입력된 값보다 작으면 대체
			if (i % 2 == 0) {
				if (dp[i / 2] + 1 < dp[i]) {
					dp[i] = dp[i / 2] + 1;
				}
			}

			// 해당 숫자가 3의 배수면
			// 3으로 나눈 수의 최소 횟수에 3을 나눈 연산이 추가되므로 1을 더함
			// 3으로 나눈 수의 최소 횟수에 1을 더한 값이 현재 입력된 값보다 작으면 대체
			if (i % 3 == 0) {
				if (dp[i / 3] + 1 < dp[i]) {
					dp[i] = dp[i / 3] + 1;
				}
			}
		}

		// 결과 출력
		System.out.println(dp[N]);

		scan.close();

	}

}
