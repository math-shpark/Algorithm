package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1953 {

	// 매개변수
	static int N, M, R, C, L;
	// 지하 터널 지도
	static int[][] space;
	// 이동 기록
	static boolean[][] isPossible;
	// 탐색 여부 저장 배열
	static boolean[][] isVisited;
	// 델타 탐색
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 연결정보 방향
	static int[][] connect = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 0 },
			{ 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 } };

	// 1953. 탈주범 검거
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 세로 크기
			N = Integer.parseInt(st.nextToken());
			// 가로 크기
			M = Integer.parseInt(st.nextToken());
			// 맨홀 위치(x)
			R = Integer.parseInt(st.nextToken());
			// 맨홀 위치(y)
			C = Integer.parseInt(st.nextToken());
			// 탈출 후 소요 시간
			L = Integer.parseInt(st.nextToken());

			// 지하 터널 지도
			space = new int[N][M];
			// 탐색 여부 배열 초기화
			isPossible = new boolean[N][M];
			isVisited = new boolean[N][M];

			// 지하 터널 정보 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					space[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// dfs 진행
			dfs(R, C, 1);

			// 장소 개수
			int count = 0;
			// 방문 여부 기록이 탈주범이 위치할 수 있는 장소의 개수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (isPossible[i][j]) {
						count++;
					}
				}
			}

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(count).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	private static void dfs(int startX, int startY, int time) {

		// 현재 칸에 존재 가능함을 표시
		isPossible[startX][startY] = true;

		// 경계
		// 제한 시간이 경과하면 결과 재귀 종료
		if (time == L) {
			return;
		}

		// 재귀
		// 연결된 터널을 따라 이동
		// 현재 위치의 터널 정보
		int tunnel = space[startX][startY];

		// 현재 위치의 터널로 갈 수 있는 방향을 저장한 배열
		int[] direction = connect[tunnel];

		// 델타 탐색
		for (int i = 0; i < 4; i++) {
			// 이동 가능하지 않은 방향이면 건너뛰기
			if (direction[i] == 0)
				continue;

			// 새로운 좌표
			int newX = startX + dr[i];
			int newY = startY + dc[i];

			// 범위 밖이면 건너뛰기
			if (newX < 0 || newX >= N || newY < 0 || newY >= M)
				continue;

			// 이동할 칸이 터널이 없는 칸이면 건너뛰기
			if (space[newX][newY] == 0)
				continue;

			// 이미 방문한 칸이면 건너뛰기
			if (isVisited[newX][newY])
				continue;

			// 위의 조건을 모두 통과한 경우
			// 이동하려는 칸이 현재 칸과 연결된 터널이면 이동한다.
			if (connect[space[newX][newY]][(i + 2) % 4] == 1) {
				isVisited[newX][newY] = true;
				dfs(newX, newY, time + 1);
				isVisited[newX][newY] = false;
			}
		}

	}

}
