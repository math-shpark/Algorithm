package d3;

import java.util.Scanner;

public class Problem11315 {

	// 11315. 오목 판정
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {

			// 오목판 크기 입력
			int size = scan.nextInt();
			// 오목판 정보를 저장할 배열 생성
			char[][] space = new char[size][size];
			// 오목인지 여부를 저장할 변수
			boolean isFive = false;

			// 오목판 정보를 배열에 저장
			for (int i = 0; i < size; i++) {
				String str = scan.next();
				space[i] = str.toCharArray();
			}

			// 델타 탐색
			// 상-하-좌-우-좌상-우상-좌하-우하 순
			int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
			int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

			Outer: for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					// 돌이 나오면
					if (space[i][j] == 'o') {
						// 해당 위치에서 델타 탐색을 하고
						for (int k = 0; k < 8; k++) {
							int newX = i + dr[k];
							int newY = j + dc[k];

							// 범위를 벗어나면 건너뛰고
							if (newX < 0 || newX >= size || newY < 0 || newY >= size) {
								continue;
							} else if (space[newX][newY] == 'o') {
								// 다음 자리에도 돌이 있으면
								// 방향을 유지하며 남은 3개의 돌이 있는지 여부 확인
								for (int l = 0; l < 3; l++) {
									newX = newX + dr[k];
									newY = newY + dc[k];

									// 범위를 벗어나거나 돌이 3개가 안되면 반복문 종료
									if (newX < 0 || newX >= size || newY < 0 || newY >= size
											|| space[newX][newY] != 'o') {
										break;
									} else if (l == 2) {
										// 3개 다 있으면 true를 반환하고 반복문 전체 종료
										isFive = true;
										break Outer;
									}
								}
							}
						}
					}
				}
			}

			// 오목인지 여부에 따라 결과 출력
			if (isFive) {
				System.out.println("#" + test + " YES");
			} else {
				System.out.println("#" + test + " NO");
			}

		}

		scan.close();

	}

}
