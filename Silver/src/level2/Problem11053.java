package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11053 {

	// 11053. 가장 긴 증가하는 부분 수열
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수열 A의 크기 입력
		int N = Integer.parseInt(br.readLine());

		// 수열의 숫자 데이터를 저장할 배열
		int[] numArr = new int[N];
		// 다이나믹 프로그래밍 배열
		int[] dp = new int[N];

		dp[0] = 1;

		// 숫자 데이터 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		// 각 인덱스별로 가장 긴 증가 수열 길이 입력
		for (int i = 0; i < N; i++) {
			// 현재 숫자로만으로도 만들 수 있으므로
			// 1로 초기화
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				// 현재 숫자 데이터 기준
				// 왼쪽에 있는 숫자들을 하나씩 비교하면서
				// 해당 숫자의 dp 값 + 1보다 지금까지 입력된 dp[i]가 더 작으면 값 최신화
				if (numArr[j] < numArr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		// 수열의 길이
		int length = 0;

		for (int i = 0; i < N; i++) {
			if (length < dp[i]) {
				length = dp[i];
			}
		}

		// 결과 출력
		System.out.println(length);

	}

}
