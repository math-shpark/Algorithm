package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1249 {

	// 정점 클래스
	static class Node {
		int x, y, w;

		Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}

	// 공간 크기
	static int N;
	// 공간 배열
	static int[][] space;
	// 탐색 여부 배열
	static boolean[][] isVisited;
	// 인접 리스트
	static List<Node>[][] adjList;
	// 가중치 배열
	static int[][] time;
	// 초기 시간값
	static final int TIME = Integer.MAX_VALUE;

	// 1249. 보급로
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			// N
			N = Integer.parseInt(br.readLine());

			// 공간 배열
			space = new int[N][N];
			// 탐색 여부 배열
			isVisited = new boolean[N][N];
			// 인접 리스트
			adjList = new ArrayList[N][N];
			// 가중치 배열
			time = new int[N][N];

			// 가중치 배열 초기화
			for (int[] row : time)
				Arrays.fill(row, TIME);

			// 공간 정보 입력
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					space[i][j] = str.charAt(j) - '0';
				}
			} // 공간 정보 입력 완료

			// 리스트 객체 생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjList[i][j] = new ArrayList<>();
				}
			}

			// 델타 탐색(시계방향)
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };

			// 간선 정보 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < 4; k++) {
						int nextX = i + dr[k];
						int nextY = j + dc[k];

						// 범위 밖이면 건너뛰기
						if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
							continue;

						// 연결된 정점 리스트에 추가
						adjList[i][j].add(new Node(nextX, nextY, space[nextX][nextY]));
					}
				}
			} // 간선 정보 입력 완료

			// Dijkstra 실행
			dijkstra(0, 0);

			// 현재 위치까지 온 것은 출발점을 기준으로 각 정점까지의 최소 복구 시간이 입력된 것
			// 도착지 좌표인 (N-1, N-1)의 최소 복구 시간을 결과 문자열에 연결
			sb.append("#").append(test).append(" ").append(time[N - 1][N - 1]).append('\n');

		}

		// 결과 출력
		System.out.println(sb);

	}

	// Dijkstra 알고리즘
	private static void dijkstra(int startX, int startY) {
		// 시작점은 거리가 시간 없음
		time[startX][startY] = 0;

		for (int op = 0; op < N * N - 1; op++) {
			// 방문하지 않은 정점 중 복구 시간 최소 위치
			int minX = -1;
			int minY = -1;
			// 최소 복구 시간을 저장할 변수
			int minTime = TIME;

			// (0,0)부터 도착 정점까지 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 이미 탐색한 정점은 패스
					if (isVisited[i][j])
						continue;

					// 아직 탐색하지 않은 정점 중 최소 시간 위치 선택
					if (minTime > time[i][j]) {
						minTime = time[i][j];
						minX = i;
						minY = j;
					}
				}
			} // 출발 정점 탐색 완료

			// 출발 정점 탐색 여부 표시
			isVisited[minX][minY] = true;

			// 출발 정점과 연결된 정점을 확인하여 누적 시간 값 갱신
			for (int i = 0; i < adjList[minX][minY].size(); i++) {
				Node node = adjList[minX][minY].get(i);

				// 이미 탐색한 연결 정점은 패스
				if (isVisited[node.x][node.y])
					continue;

				// 탐색 전 연결 정점 중
				// 현재 출발 정점에서 가는 누적 시간이 더 적으면 갱신
				if (time[node.x][node.y] > time[minX][minY] + node.w)
					time[node.x][node.y] = time[minX][minY] + node.w;
			}
		}
	}

}
