package level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물건 수
		int K = Integer.parseInt(st.nextToken()); // 최대 용량

		int[][] dp = new int[N + 1][K + 1]; // 다이나믹 프로그래밍 배열

		int w, v;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 무게
			v = Integer.parseInt(st.nextToken()); // 가치
			
			for (int j = 1; j <= K; j++) {
				dp[i][j] = j < w ? dp[i - 1][j] : Math.max(v + dp[i - 1][j - w], dp[i - 1][j]);
			}
		}
		System.out.println(dp[N][K]);
	}
}
