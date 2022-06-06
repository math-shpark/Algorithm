package silver.level2;

import java.util.Scanner;

public class Problem1012 {

	// 델타 탐색
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 배추밭 정보
	static int[][] space;
	// 탐색 여부 저장 배열
	static boolean[][] isVisted;
	// 배추밭 높이
	static int N;
	// 배추밭 너비
	static int M;

	// 1012. 유기농 배추
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		for (int i = 0; i < testCase; i++) {
			// 가로, 세로 입력
			M = scan.nextInt();
			N = scan.nextInt();
			// 배추 개수 입력
			int K = scan.nextInt();
			// 필요한 지렁이의 개수
			int count = 0;

			// 입력한 크기에 맞춰 배열 생성
			space = new int[N][M];
			isVisted = new boolean[N][M];

			// 지형 정보 입력
			for (int j = 0; j < K; j++) {
				int X = scan.nextInt();
				int Y = scan.nextInt();
				space[Y][X] = 1;
			}

			// 지렁이의 개수를 세는 반복문
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					// 배추가 존재하고 처음 탐색하는 땅이면
					if (space[j][k] == 1 && isVisted[j][k] == false) {
						// 탐색 메소드를 실행하고
						search(j, k);
						// 지렁이 개수 1 추가
						count++;
					}
				}
			}
			// 지렁이 개수 출력
			System.out.println(count);
		}
		scan.close();

	}

	// 델타 탐색 메소드
	public static void search(int x, int y) {

		// 현재 위치는 이제 탐색했으므로 true 표시
		isVisted[x][y] = true;

		// 델타 탐색
		for (int i = 0; i < 4; i++) {
			int newX = x + dr[i];
			int newY = y + dc[i];

			// 새로운 좌표가 범위 내이고
			if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
				// 해당 좌표에 배추가 있으면서
				// 아직 탐색하지 않은 위치면
				// 해당 위치를 기준으로 새로 탐색 메소드 실행함으로써
				// 처음 위치와 연결된 모든 배추를 true로 표시하는 재귀함수
				if (space[newX][newY] == 1 && isVisted[newX][newY] == false) {
					search(newX, newY);
				}
			}
		}

	}

}
