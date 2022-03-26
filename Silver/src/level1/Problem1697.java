package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1697 {

	// 탐색 여부를 저장할 배열
	static boolean[] isVisited = new boolean[100001];
	// 출발 노드
	static int N;
	// 도착 노드
	static int K;

	// 1697. 숨바꼭질
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 노드 정보 입력
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 노드가 동일한 경우 0 출력 후 종료
		if (N == K) {
			System.out.println(0);
			return;
		}

		// bfs 탐색 결과 저장
		int time = bfs(N);

		// 결과 출력
		System.out.println(time);
	}

	// bfs
	private static int bfs(int startNode) {

		// bfs에서 사용할 큐 생성
		Queue<Integer> bfsQue = new LinkedList<Integer>();

		// 출발 노드 입력
		bfsQue.add(startNode);
		// 출발 노드 탐색 여부 표시
		isVisited[startNode] = true;

		// 탐색 시간
		int time = 1;

		Outer: while (!bfsQue.isEmpty()) {
			// 동일한 거리의 노드의 개수
			int range = bfsQue.size();

			// 동일한 거리의 노드 개수만큼 반복
			for (int i = 0; i < range; i++) {
				int temp = bfsQue.poll();

				// 다음 이동 가능한 범위에 목표 노드가 있으면 반복문 전체 종료
				if (temp - 1 == K || temp + 1 == K || temp * 2 == K) {
					break Outer;
				}

				// 이동 가능 범위에 도착 노드가 없으면
				// X-1, X+1, X*2 노드가 범위 내이면서 탐색 전이면 큐에 추가
				if (temp - 1 >= 0 && isVisited[temp - 1] == false) {
					bfsQue.add(temp - 1);
					isVisited[temp - 1] = true;
				}

				if (temp + 1 <= 100000 && isVisited[temp + 1] == false) {
					bfsQue.add(temp + 1);
					isVisited[temp + 1] = true;
				}

				if (temp * 2 <= 100000 && isVisited[temp * 2] == false) {
					bfsQue.add(temp * 2);
					isVisited[temp * 2] = true;
				}
			}
			
			// 동일한 거리의 노드 탐색이 종료되면 시간 추가
			time++;

		}
		// 결과 반환
		return time;

	}

}
