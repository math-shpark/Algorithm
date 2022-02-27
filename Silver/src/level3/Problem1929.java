package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1929 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 시작 범위
		int M = Integer.parseInt(st.nextToken());
		// 종료 범위
		int N = Integer.parseInt(st.nextToken());

		// 종료 범위까지의 수 중 소수 여부를 저장할 배열
		// false 가 소수
		boolean[] isPrime = new boolean[N + 1];
		// 0과 1은 소수가 아님
		isPrime[0] = true;
		isPrime[1] = true;

		// 에라토스테네스 체 적용
		for (int i = 2; i < Math.sqrt(N + 1); i++) {
			for (int j = i * i; j < N + 1; j += i) {
				isPrime[j] = true;
			}
		}

		// 적용 범위에 해당하는 수만 출력
		for (int i = M; i < N + 1; i++) {
			if (isPrime[i] == false) {
				sb.append(i).append('\n');
			}
		}

		// 출력
		System.out.println(sb);

	}

}
