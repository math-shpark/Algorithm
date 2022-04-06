package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1629 {

	// 1629. 곱셈
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 밑
		long A = Long.parseLong(st.nextToken());
		// 지수
		long B = Long.parseLong(st.nextToken());
		// 나눌 수
		long C = Long.parseLong(st.nextToken());

		// 결과
		long result = pow(A, B, C);

		// 출력
		System.out.println(result);

	}

	private static long pow(long a, long b, long c) {

		// 지수가 1인 경우
		if (b == 1) {
			return a % c;
		}

		// 지수의 절반 값 구하기
		long half = pow(a, b / 2, c);

		// 지수가 홀수인 경우
		if (b % 2 == 1) {
			// 절반 값들을 곱한 값이 큰 값일 수 있으므로
			// 먼저 나머지를 취한 후 계속해서 곱함
			return half * half % c * a % c;
		} else {
			// 짝수인 경우
			return half * half % c;
		}

	}

}
