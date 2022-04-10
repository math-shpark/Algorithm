package d2;

import java.util.Scanner;

public class Problem2001 {

	// 2001. 파리 퇴치
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCaseNum = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCaseNum; test++) {

			// 크기 및 파리채 크기 입력
			int N = scan.nextInt();
			int M = scan.nextInt();

			// 크기에 맞게 공간 배열 생성
			int[][] space = new int[N][N];

			// 공간 내 파리의 개수 정보 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					space[i][j] = scan.nextInt();
				}
			}

			// 최대 합을 저장할 변수
			int max = 0;
			// 이동 가능 범위
			int move = N - M + 1;

			// 0,0부터 시작해서 한 칸씩 이동하며 최대 합을 찾는 반복문
			for (int row = 0; row < move; row++) {
				for (int col = 0; col < move; col++) {

					// 임시 합을 저장할 변수
					int temp = 0;

					// 임시 합을 구하는 반복문
					for (int i = row; i < row + M; i++) {
						for (int j = col; j < col + M; j++) {
							temp += space[i][j];
						}
					}

					// 임시 합이 현재 최대값보다 크면 대체
					if (max < temp) {
						max = temp;
					}

				}
			}

			// 결과 출력
			System.out.println("#" + test + " " + max);

		}

		// Scanner 종료
		scan.close();

	}

}
