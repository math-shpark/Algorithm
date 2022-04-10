package d2;

import java.util.Scanner;

public class Problem2005 {

	// 2005. 파스칼 삼각형
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 테스트 케이스 반복
		for (int test = 1; test <= testCase; test++) {
			// 범위 입력
			int N = scan.nextInt();

			// 범위에 맞춰 정사각형 배열 생성
			int[][] space = new int[N][N];

			// 맨 앞자리 1 입력
			for (int i = 0; i < N; i++) {
				space[i][0] = 1;
			}

			// 파스칼 삼각형 규칙에 맞춰 데이터 입력
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < N; j++) {
					space[i][j] = space[i - 1][j] + space[i - 1][j - 1];
				}
			}

			// 출력 양식
			sb.append("#").append(test).append('\n');

			// 0이 아닌 실제 데이터가 입력된 경우만 출력하는 반복문
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (space[i][j] == 0) {
						break;
					} else {
						sb.append(space[i][j]).append(" ");
					}
				}
				sb.append('\n');
			}

		}

		// 결과 출력
		System.out.println(sb);

		scan.close();

	}

}
