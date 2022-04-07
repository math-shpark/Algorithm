package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1949 {

	// 공간 배열
	static int[][] space;
	// 크기
	static int N;
	// 공사 가능 깊이
	static int K;
	// 델타 탐색(시계방향)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 탐색 여부 저장 배열
	static boolean[][] isVisited;
	// 최대 경로 길이
	static int maxDis;

	// 1949. 등산로 조성
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 크기 입력
			N = Integer.parseInt(st.nextToken());
			// 공사 가능 깊이
			K = Integer.parseInt(st.nextToken());

			// 공간 배열
			space = new int[N][N];

			// 최대 높이
			int maxHeight = 0;

			// 최대 경로 길이 초기화
			maxDis = 0;

			// 공간 정보 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					// 높이 정보 입력
					space[i][j] = Integer.parseInt(st.nextToken());
					// 최대 높이 최신화
					if (maxHeight < space[i][j]) {
						maxHeight = space[i][j];
					}
				}
			}

			// 각 위치를 돌면서 최대 봉우리에 도달하면 dfs 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (space[i][j] == maxHeight) {
						isVisited = new boolean[N][N];
						dfs(i, j, 0, 1);
					}
				}
			}

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(maxDis).append('\n');

		}

		// 결과 출력
		System.out.println(sb);

	}

	// dfs
	// 매개변수 : 출발점 좌표, 공사 횟수, 누적 거리
	private static void dfs(int startX, int startY, int process, int count) {

		// 탐색 여부 표시
		isVisited[startX][startY] = true;

		// 출발점 기준 델타 탐색
		for (int i = 0; i < 4; i++) {
			int newX = startX + dr[i];
			int newY = startY + dc[i];

			// 범위 내 이동 가능한 칸이면
			if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
				// 현재 높이보다 작으면 이동
				if (space[startX][startY] > space[newX][newY] && isVisited[newX][newY] == false) {
					dfs(newX, newY, process, count + 1);
				} else if (space[startX][startY] <= space[newX][newY] && isVisited[newX][newY] == false) {
					// 현재 높이보다 크거나 같으면
					// 공사가 가능하면
					if (process < 1) {
						int temp = space[newX][newY];
						// 최대 공사 가능 높이까지 1씩 늘려가며 재귀 호출
						for (int j = 1; j <= K; j++) {
							space[newX][newY] -= j;
							// 여전히 이동 불가하면
							if (space[startX][startY] <= space[newX][newY]) {
								// 원상복구하고 건너뛰기
								space[newX][newY] = temp;
								continue;
							} else {
								// 이동 가능하면
								// 공사 횟수 반영하고 재귀 호출
								dfs(newX, newY, process + 1, count + 1);
								// 원상복구
								space[newX][newY] = temp;
							}
						}
					}

				}

			}
		}

		// 탐색 여부 복구
		isVisited[startX][startY] = false;
		// 최장 거리면 반영
		if (count > maxDis) {
			maxDis = count;
		}

	}

}
