package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1654 {

	// 1654. 랜선 자르기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 갖고 있는 케이블 수
		int K = Integer.parseInt(st.nextToken());
		// 필요한 케이블 수
		int N = Integer.parseInt(st.nextToken());
		// 갖고 있는 케이블의 길이를 저장할 배열
		int[] cable = new int[K];

		// 갖고 있는 케이블의 최대 길이
		long maxLength = 0;
		// 이분 탐색에 활용할 최소 길이
		long minLength = 1;
		// 이분 탐색에 활용할 중간점
		long middleLength = 0;

		// 케이블 길이를 배열에 저장하고
		// 최대 길이를 찾는 반복문
		for (int i = 0; i < K; i++) {
			int length = Integer.parseInt(br.readLine());
			cable[i] = length;
			if (maxLength < length) {
				maxLength = length;
			}
		}

		// 이분 탐색
		while (minLength <= maxLength) {
			middleLength = (maxLength + minLength) / 2;

			long count = 0;

			for (int i = 0; i < K; i++) {
				count += cable[i] / middleLength;
			}

			if (count < N) {
				maxLength = middleLength - 1;
			} else {
				minLength = middleLength + 1;
			}
		}

		// 결과 출력
		System.out.println(maxLength);
	}

}
