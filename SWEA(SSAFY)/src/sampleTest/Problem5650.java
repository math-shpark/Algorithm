package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem5650 {

	// 핀볼 클래스
	static class Pinball {
		int x, y, dir; // 출발 좌표, 방향

		public Pinball(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}

	static int[][] space; // 공간 배열
	static int[][] blockDir = { { 0, 0, 0, 0 }, { 2, 3, 1, 0 }, { 1, 3, 0, 2 }, { 3, 2, 0, 1 }, { 2, 0, 3, 1 },
			{ 2, 3, 0, 1 } }; // 블록별 전환 방향(1-상, 2-우, 3-하, 4-좌)
	static int[][] wormhole; // 웜홀 좌표 배열
	// 델타 탐색
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 565.. 핀볼 게임
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int test = 1; test <= testCase; test++) {
			int N = Integer.parseInt(br.readLine()); // N

			space = new int[N][N]; // 공간 배열 생성
			wormhole = new int[5][4]; // 웜홀 좌표 배열
			int maxScore = 0; // 최대 점수

			// 웜홀 좌표 초기화
			for (int[] hole : wormhole)
				Arrays.fill(hole, -1);

			// 공간 배열 정보 입력
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					space[i][j] = Integer.parseInt(st.nextToken());
					// 웜홀 좌표 입력
					if (space[i][j] >= 6) {
						int idx = space[i][j] - 6;
						// 이미 입력된 쌍이 있으면 다음 인덱스에 입력
						if (wormhole[idx][0] != -1) {
							wormhole[idx][2] = i;
							wormhole[idx][3] = j;
						} else {
							wormhole[idx][0] = i;
							wormhole[idx][1] = j;
						}
					} // 웜홀 좌표 입력 완료
				}
			} // 공간 정보 입력 완료

			// 각 좌표를 돌며 최대 점수 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 블록, 웜홀, 블랙홀 위치는 패스
					if (space[i][j] != 0)
						continue;
					// 방향별로 진행
					for (int k = 0; k < 4; k++) {
						Pinball ball = new Pinball(i, j, k);
						int score = game(ball);
						if (score > maxScore)
							maxScore = score;
					}
				}
			} // 점수 탐색 완료

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(maxScore).append('\n');
		}
		// 결과 출력
		System.out.println(sb);
	}

	// 게임
	// 매개변수 : 출발 좌표, 현재 좌표, 누적 점수
	private static int game(Pinball ball) {

		int score = 0; // 입력받은 공으로 얻는 점수
		// 다음 이동할 좌표
		int newX = ball.x;
		int newY = ball.y;
		int dir = ball.dir;

		while (true) {
			newX += dr[dir];
			newY += dc[dir];

			// 1. 벽에 튕기는 경우
			if (newX < 0 || newY < 0 || newX >= space.length || newY >= space.length) {
				score++; // 1점 추가
				dir = (dir + 2) % 4; // 반대 방향으로 변경
				continue;
			}

			// 2. 출발점이거나 블랙홀일 경우
			if ((newX == ball.x && newY == ball.y) || space[newX][newY] == -1) {
				break; // 게임 종료
			}

			// 3. 이동할 좌표가 블록인 경우
			if (space[newX][newY] >= 1 && space[newX][newY] <= 5) {
				score++; // 1점 추가
				dir = blockDir[space[newX][newY]][dir]; // 변경된 방향
				continue;
			}

			// 4. 웜홀을 만나는 경우
			if (space[newX][newY] >= 6) {
				int num = space[newX][newY] - 6; // 웜홀 인덱스

				// 웜홀 좌표로 순간 이동
				if (wormhole[num][0] == newX && wormhole[num][1] == newY) {
					newX = wormhole[num][2];
					newY = wormhole[num][3];
				} else {
					newX = wormhole[num][0];
					newY = wormhole[num][1];
				}
				continue;
			}
		}
		return score;
	}

}
