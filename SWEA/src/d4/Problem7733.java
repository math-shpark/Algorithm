package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7733 {

	// 공간 배열
	static int[][] space;
	// 공간 크기
	static int N;
	// 델타 탐색(상하좌우)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 탐색 여부 저장 배열
	static boolean[][] isVisited;
	// 최대 덩어리 개수
	static int maxCount;

	// 7733. 치즈 도둑
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {

			// N 입력
			N = Integer.parseInt(br.readLine());

			// 공간 배열 크기 입력
			space = new int[N][N];

			// 최대 덩어리 개수 초기화
			// 1일차에 다 먹을 수 있으므로 최솟값은 1로 초기화
			maxCount = 1;

			// 맛있는 정도 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					space[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 맛있는 정도 입력 완료

			// 1일부터 100일까지 지나면서 최대 덩어리 개수를 구함
			for (int day = 1; day <= 100; day++) {
				// 요정이 치즈를 먹는 것을 표시
				eat(day);

				// 해당일의 덩어리 개수
				int temp = 0;

				// 방문 배열 초기화
				isVisited = new boolean[N][N];

				// 먹고 남은 치즈에서 덩어리 개수 탐색
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (space[i][j] != 0 && !isVisited[i][j]) {
							// 먹지 않은 칸을 발견한 경우
							// 덩어리 개수에 1 추가하고
							temp++;
							// 해당 좌표와 연결된 덩어리 범위를 탐색
							bfs(i, j);
						}
					}
				}

				// 최대 덩어리 개수면 최신화
				if (temp > maxCount) {
					maxCount = temp;
				}
			} // 최대 덩어리 개수 계산 완료

			// 결과 문자열에 연결
			sb.append("#").append(test).append(" ").append(maxCount).append('\n');

		}

		// 결과 출력
		System.out.println(sb);

	}

	// 치즈 먹기
	private static void eat(int day) {

		// 각 칸을 돌면서 먹은 칸은 0으로 표시
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (space[i][j] == day) {
					space[i][j] = 0;
				}
			}
		}

	} // 치즈 먹기 끝

	// 덩어리 개수 세기(BFS)
	private static void bfs(int startX, int startY) {
		// queue 생성
		Queue<int[]> bfsQue = new LinkedList<>();
		// 출발점 추가
		int[] start = { startX, startY };
		bfsQue.add(start);

		// 출발점 방문 여부 표시
		isVisited[startX][startY] = true;

		while (!bfsQue.isEmpty()) {
			int[] temp = bfsQue.poll();

			// 현재 커낸 칸의 좌표
			int nowX = temp[0];
			int nowY = temp[1];

			// 델타 탐색
			for (int i = 0; i < 4; i++) {
				int newX = nowX + dr[i];
				int newY = nowY + dc[i];

				// 이동할 좌표가 범위 내이면서
				// 요정이 먹지 않은 칸이면
				if (newX >= 0 && newX < N && newY >= 0 && newY < N && space[newX][newY] != 0
						&& !isVisited[newX][newY]) {
					// 탐색 여부를 표시하고
					isVisited[newX][newY] = true;
					// 큐에 추가
					int[] next = { newX, newY };
					bfsQue.add(next);
				}
			}
		}
	}

}
