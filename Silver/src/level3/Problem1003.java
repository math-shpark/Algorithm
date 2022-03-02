package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1003 {

	// n별로 출력되는 0과 1의 개수를 저장하는 배열
	// n의 범위는 0이상 40이하
	// 각 인덱스 내 배열은 0번 인덱스에 0의 개수
	// 1번 인덱스에 1의 개수를 저장
	static Integer[][] count = new Integer[41][2];

	// 1003. 피보나치 함수
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		// n이 0일 때와 1일 때 0과 1의 개수 입력
		count[0][0] = 1;
		count[0][1] = 0;
		count[1][0] = 0;
		count[1][1] = 1;
		// 사전에 n이 40일 때까지 다 계산
		fibonacci(40);

		// 입력한 숫자에 저장된 개수를 출력하는 반복문
		for (int test = 1; test <= testCase; test++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(count[n][0]).append(" ").append(count[n][1]).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// 0과 1의 개수를 찾는 재귀함수
	public static Integer[] fibonacci(int n) {
		// 탐색하지 못한 수면 재귀함수를 호출하고
		if (count[n][0] == null || count[n][1] == null) {
			count[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
			count[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
		}
		// 결과 배열을 반환
		return count[n];
	}

}
