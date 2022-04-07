package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2105 {

	// 공간 정보
	static int[][] space;
	// 델타 탐색(시계방향, 대각선)
	static int[] dr = { -1, -1, 1, 1 };
	static int[] dc = { -1, 1, 1, -1 };
	// 최장 경로
	static int maxDis;
	// 탐색 여부 저장 배열
	static boolean[][] isVisited;
	// 디저트 먹은 여부
	static boolean[] isEated;
	// 공간 크기
	static int N;

	// 2105. 디저트 카페
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			// N 입력
			N = Integer.parseInt(br.readLine());

			// 배열 크기 입력
			space = new int[N][N];

			// 최장 경로 초기화
			maxDis = -1;

			// 디저트 번호 최댓값
			int maxVal = 0;

			// 디저트 정보 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					space[i][j] = Integer.parseInt(st.nextToken());
					if (maxVal < space[i][j]) {
						maxVal = space[i][j];
					}
				}
			}

			// 각 좌표를 출발점으로 하여
			// 최대 경로를 찾는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					isVisited = new boolean[N][N];
					isEated = new boolean[maxVal + 1];

					isVisited[i][j] = true;
					isEated[space[i][j]] = true;
					dfs(i, j, i, j, 1, 0);
				}
			}

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(maxDis).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// dfs
	// 매개변수 : 출발점 좌표, 현재 좌표, 누적 경로 길이, 이전 방향 인덱스
	private static void dfs(int startX, int startY, int nowX, int nowY, int count, int prev) {

		// 재귀
		for (int i = prev; i < 4; i++) {
			int newX = nowX + dr[i];
			int newY = nowY + dc[i];

			// 범위 내 이동 가능하면
			if (newX >= 0 && newX < N && newY >= 0 && newY < N) {

				if (newX == startX && newY == startY && count > 2) {
					if (count > maxDis) {
						maxDis = count;
					}
					return;
				}

				if (!isVisited[newX][newY] && !isEated[space[newX][newY]]) {
					isVisited[newX][newY] = true;
					isEated[space[newX][newY]] = true;

					dfs(startX, startY, newX, newY, count + 1, i);

					isVisited[newX][newY] = false;
					isEated[space[newX][newY]] = false;
				}

			}
		}

	}

}
