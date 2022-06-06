package silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11724 {

	static int[][] space;
	static boolean[] isVisited;

	// 11724. 연결 요소의 개수
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 노드 개수 입력
		int N = Integer.parseInt(st.nextToken());
		// 간선 개수 입력
		int M = Integer.parseInt(st.nextToken());
		// 연결 개수
		int count = 0;

		// 공간 정보 크기 지정
		space = new int[N + 1][N + 1];
		// 방문 정보 크기 지정
		isVisited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			// 연결 정보를 배열에 저장할 위치
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			// 연결 정보 저장
			space[num1][num2] = 1;
			space[num2][num1] = 1;
		}

		// 출발 노드가 아직 탐색 전이면 dfs를 탐색하는 반복문
		for (int i = 1; i <= N; i++) {
			if (isVisited[i] == false) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);

	}

	private static void dfs(int startNode) {

		// 탐색했음을 표시하고
		isVisited[startNode] = true;

		// 다음 이동 가능한 노드를 탐색한 후 재귀 실행
		for (int node = 1; node < space.length; node++) {
			if (space[startNode][node] == 1 && isVisited[node] == false) {
				dfs(node);
			}
		}

	}

}
