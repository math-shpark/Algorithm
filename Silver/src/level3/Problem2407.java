package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem2407 {

	// 2407. 조합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// n과 m 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 분자
		BigInteger num = BigInteger.ONE;
		// 분모
		BigInteger den = BigInteger.ONE;

		// 분자와 분모 계산
		for (int i = 0; i < m; i++) {
			num = num.multiply(new BigInteger(String.valueOf(n - i)));
			den = den.multiply(new BigInteger(String.valueOf(i + 1)));
		}

		// 결과 계산
		BigInteger answer = num.divide(den);

		// 결과 출력
		System.out.println(answer);
	}

}
