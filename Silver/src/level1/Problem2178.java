package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인덱스를 좌표로 갖는 노드 설정
class Node {
	public int x;
	public int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Problem2178 {

	// 공간 정보 배열
	static int[][] space;
	// 탐색 여부 저장 배열
	static boolean[][] isVisited;
	// 배열 크기
	static int N;
	static int M;
	// 델타 탐색 배열
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 2178. 미로 탐색
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 크기 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 배열 크기 지정
		space = new int[N][M];
		isVisited = new boolean[N][M];

		// 배열 정보 저장 반복문
		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				space[i][j] = str.charAt(j) - '0';
			}
		}

		// bfs 탐색 결과 반환
		int count = bfs(0, 0);

		// 결과 출력
		System.out.println(count);
	}

	// bfs 탐색
	private static int bfs(int startX, int startY) {

		// bfs 탐색 전용 큐
		Queue<Node> bfsQue = new LinkedList<>();
		// 시작 노드 탐색 여부 표시
		isVisited[startX][startY] = true;

		// 출발점부터 이미 1을 세기 때문에 2로 초기화
		int count = 2;
		// 출발점을 하나의 노드로 생성
		Node startNode = new Node(startX, startY);

		// 출발점 노드를 큐에 추가
		bfsQue.add(startNode);

		// 탐색 반복문
		Outer: while (!bfsQue.isEmpty()) {
			// 동일 거리 노드 개수
			int range = bfsQue.size();

			// 동일 거리 노드 개수만큼 반복
			for (int i = 0; i < range; i++) {
				// 큐에서 노드를 꺼낸 후
				Node temp = bfsQue.poll();
				// 꺼낸 노드의 인덱스를 기준으로 델타 탐색
				for (int j = 0; j < 4; j++) {
					int newX = temp.x + dr[j];
					int newY = temp.y + dc[j];

					// 범위 내 목표 노드가 있으면 반복문 종료
					if (newX == N - 1 && newY == M - 1) {
						break Outer;
					}

					// 없고 범위 내 이동 가능한 노드면
					if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
						if (space[newX][newY] == 1 && isVisited[newX][newY] == false) {
							// 해당 위치의 인덱스로 노드를 생성하여
							Node nextNode = new Node(newX, newY);
							// 큐에 추가한 후
							bfsQue.add(nextNode);
							// 해당 노드를 탐색했음을 표시
							isVisited[newX][newY] = true;
						}
					}
				}
			}
			// 거리 추가
			count++;
		}

		// 거리 반환
		return count;

	}

}
