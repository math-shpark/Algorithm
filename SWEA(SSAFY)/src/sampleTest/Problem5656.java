package sampleTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5656 {

	static int N, W, H; // 매개변수
	static int score, maxScore, block; // 결과 값
	static int space[][]; // 공간 배열
	// 델타 탐색
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	// 5656. 벽돌 깨기
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 매개변수 입력
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			space = new int[H][W]; // 공간 배열
			score = 0; // 임시 누적 점수
			maxScore = 0; // 최대 점수
			block = 0; // 전체 블록 수

			// 블록 정보 입력
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					space[i][j] = Integer.parseInt(st.nextToken());
					if (space[i][j] != 0)
						block++;
				}
			} // 블록 정보 입력 완료

			game(0);

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(block - maxScore).append('\n');
		}
		// 결과 출력
		System.out.println(sb);
	}

	// 게임
	// 매개변수 : 던진 공의 개수
	private static void game(int ballCount) {
		// 경계
		// N개의 공을 모두 던지면 종료
		if (ballCount == N) {
			// 최대 폭발 개수 최신화
			if (maxScore < score)
				maxScore = score;
			return;
		}

		// 재귀
		// 벽돌 정보 복사
		int copy[][] = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = space[i][j];
			}
		} // 복사 완료

		// 누적 폭발 개수 복사
		int copyScore = score;
		// 1개의 열씩 공 던지기 시작
		for (int i = 0; i < W; i++) {
			dropBall(i);
			game(ballCount + 1);

			// 원상 복구
			score = copyScore;
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					space[j][k] = copy[j][k];
				}
			}
		}

	}

	// 공 던지기
	private static void dropBall(int col) {

		for (int i = 0; i < H; i++) {
			// 블록이 아니면
			if (space[i][col] != 0) {
				// 폭발하고
				bomb(i, col);
				// 벽돌 낙하
				drop();
				break;
			}
		}
	}

	// 폭발
	private static void bomb(int x, int y) {
		// 폭발 범위
		int range = space[x][y];
		// 명중한 블록 소멸
		space[x][y] = 0;
		// 누적 소멸 개수 추가
		score++;

		// 델타 탐색하여 범위 내 블록 소멸
		for (int i = 0; i < 4; i++) {
			// 이동할 좌표
			int newX = x;
			int newY = y;
			// 입력된 범위까지만 소멸
			for (int j = 1; j < range; j++) {
				newX = newX + dr[i];
				newY = newY + dc[i];

				// 공간 범위 내 소멸 가능한 블록이 없으면 해당 방향 종료
				if (newX < 0 || newY < 0 || newX >= H || newY >= W)
					break;

				// 이동한 좌표에 블록이 없으면 패스
				if (space[newX][newY] == 0)
					continue;

				// 이동한 좌표에 범위가 1보다 큰 블록이 있으면 연쇄 폭발
				if (space[newX][newY] > 1) {
					bomb(newX, newY);
					continue;
				}

				// 이동한 좌표에 범위가 1인 블록이 있으면 해당 블록만 소멸
				score++;
				space[newX][newY] = 0;
			}
		}
	}

	// 낙하
	private static void drop() {
		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 0; j--) {
				if (space[j][i] == 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (space[k][i] != 0) {
							space[j][i] = space[k][i];
							space[k][i] = 0;
							break;
						}
					}
				}
			}
		}
	}

}
