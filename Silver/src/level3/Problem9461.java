package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9461 {

	// 9461. 파도반 수열
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());
		// 테스트 케이스별 n을 저장할 배열
		int[] nArr = new int[testCase];
		// 최대 n을 저장할 변수
		int max = 0;

		// 테스트 케이스별 n을 저장하고 최대 n을 찾는 반복문
		for (int i = 0; i < testCase; i++) {
			nArr[i] = Integer.parseInt(br.readLine());

			if (max < nArr[i]) {
				max = nArr[i];
			}

		}

		// 다이나믹 프로그래밍 배열
		// n이 100에 가까워지면 int 범위를 초과하므로 long으로 선언
		long[] P = new long[Math.max(7, max + 1)];

		// 1부터 5번 삼각형까지 길이 입력
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;

		// 6번부터 점화식을 사용하여 길이 저장
		for (int i = 6; i < P.length; i++) {
			P[i] = P[i - 1] + P[i - 5];
		}

		// 결과 출력
		for (int i = 0; i < testCase; i++) {
			sb.append(P[nArr[i]]).append('\n');
		}

		System.out.println(sb);

	}

}
