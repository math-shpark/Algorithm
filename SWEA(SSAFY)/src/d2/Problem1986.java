package d2;

import java.util.Scanner;

public class Problem1986 {

	// 1986. 지그재그 숫자
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {
			// 숫자 범위 입력
			int N = scan.nextInt();

			// 결과를 저장할 변수
			int result = 0;

			// 홀수면 더하고
			// 짝수면 빼는 반복문
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 0) {
					result -= i;
				} else {
					result += i;
				}
			}

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(result).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

		scan.close();

	}

}
