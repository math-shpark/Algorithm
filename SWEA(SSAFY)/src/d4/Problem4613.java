package d4;

import java.util.Scanner;

public class Problem4613 {

	// 4613. 러시아 국기 같은 깃발
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {
			// 행 길이 입력
			int N = scan.nextInt();
			// 열 길이 입력
			int M = scan.nextInt();
			// 최소 교환 개수 저장
			int minCount = N * M;

			// 깃발 정보를 저장할 배열
			char[][] flag = new char[N][M];

			// 깃발 정보를 배열에 저장
			for (int i = 0; i < N; i++) {
				String str = scan.next();
				flag[i] = str.toCharArray();
			}

			// 흰색 줄과 파란색 줄의 개수를 하나씩 늘려가며
			// 해당 개수의 줄만큼 칠하는데 필요한 교환 개수를 계산한 후
			// 최솟값을 반환하는 반복문
			for (int white = 0; white < N - 2; white++) {
				for (int blue = white + 1; blue < N - 1; blue++) {

					int count = 0;

					for (int i = 0; i <= white; i++) {
						for (int j = 0; j < M; j++) {
							if (flag[i][j] != 'W') {
								count++;
							}
						}
					}

					for (int i = white + 1; i <= blue; i++) {
						for (int j = 0; j < M; j++) {
							if (flag[i][j] != 'B') {
								count++;
							}
						}
					}

					for (int i = blue + 1; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (flag[i][j] != 'R') {
								count++;
							}
						}
					}

					if (count < minCount) {
						minCount = count;
					}

				}
			}

			// 결과 출력
			System.out.println("#" + test + " " + minCount);

		}

		// Scanner 종료
		scan.close();

	}

}
