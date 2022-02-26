package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1978 {

	// 1978. 소수 찾기
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N 입력
		int N = Integer.parseInt(br.readLine());
		// 소수 개수를 저장할 변수
		int count = 0;
		// 숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 약수 개수를 저장할 변수
			int tempCount = 0;

			for (int j = 1; j <= num; j++) {
				if (num % j == 0) {
					tempCount++;
					// 약수가 3개 이상이면 소수가 아님
					if (tempCount > 2) {
						break;
					}
				}
			}

			// 약수가 정확히 2개여야 소수
			if (tempCount == 2) {
				count++;
			}
		}

		// 출력
		System.out.println(count);

	}

}
