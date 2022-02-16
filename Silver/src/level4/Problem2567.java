package level4;

import java.util.Scanner;

public class Problem2567 {

	// 2567. 색종이 - 2
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 색종이 수 입력
		int papers = scan.nextInt();
		// 좌표평면
		int[][] space = new int[100][100];

		// 색종이의 수만큼 반복
		for (int i = 0; i < papers; i++) {
			// 색종이 출발점 좌표
			int x = scan.nextInt();
			int y = scan.nextInt();

			// 색종이가 덮는 부분을 1로 표시
			for (int j = y; j < y + 10; j++) {
				for (int k = x; k < x + 10; k++) {
					space[j][k] = 1;
				}
			}

		}

		// 델타 탐색
		// 상하좌우 순
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		// 둘레를 저장할 변수
		int side = 0;

		// 색종이가 덮어서 1로 채워진 칸을 델타 탐색 했을 때
		// 상하좌우 방향에 0이 있는 1이 둘레
		// 0의 개수가 해당 칸이 꼭지점인지 모서리인지 알 수 있고
		// 0의 개수가 곧 둘레의 길이
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (space[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int newX = i + dx[k];
						int newY = j + dy[k];

						// 벽에 닿아서 둘레이거나
						// 주변에 0이 있어서 둘레인 경우
						if (newX < 0 || newX >= 100 || newY < 0 || newY >= 100 || space[newX][newY] == 0) {
							side++; // 둘레에 1을 더함
						}
					}
				}
			}
		}

		// 결과 출력
		System.out.println(side);

		// Scanner 종료
		scan.close();

	}

}
