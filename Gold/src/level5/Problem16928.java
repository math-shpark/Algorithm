package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16928 {

	// 각 칸별로 주사위 최소 횟수 저장 배열
	static int count[] = new int[101];
	// 사다리 또는 뱀을 통해 이동하는 칸 정보
	static int move[] = new int[101];
	// 이미 다른 경로를 통해 거쳤는지 여부를 저장할 배열
	static boolean isVisited[] = new boolean[101];

	// 16928. 뱀과 사다리 게임
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 사다리 개수
		int ladder = Integer.parseInt(st.nextToken());
		// 뱀 개수
		int snake = Integer.parseInt(st.nextToken());

		// 사다리 또는 뱀으로 연결된 정보 저장
		for (int i = 0; i < ladder + snake; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			move[start] = end;
		}

		// bfs 탐색 실행
		bfs();
	}

	// bfs
	static void bfs() {
		// 큐 생성
		Queue<Integer> bfsQue = new LinkedList<Integer>();
		// 1번 칸 추가
		bfsQue.offer(1);
		// 1번 칸 방문 여부 표시
		isVisited[1] = true;

		while (!bfsQue.isEmpty()) {
			// 큐에서 말 하나 꺼내서
			int front = bfsQue.poll();

			// 말이 이미 도착지에 도착하면 결과 출력
			if (front == 100) {
				System.out.println(count[front]);
				return;
			}

			// 아직 도착지에 도착 전이면
			for (int i = 1; i <= 6; i++) {
				// 다음 이동 칸
				int next = front + i;

				// 다음 칸이 이미 범위 밖이면 반복문 종료
				if (100 < next) {
					break;
				}

				// 다음 칸이 이미 다른 경로를 통해 거쳐간 적이 있는 경우
				if (isVisited[next]) {
					// 건너뛰기
					continue;
				}

				// 다음 칸으로 갈 수 있으면
				// 방문 여부 표시
				isVisited[next] = true;

				// 다음 칸에 사다리 또는 뱀이 있는 경우
				if (move[next] != 0) {
					// 사다리나 뱀으로 이동한 칸이 아직 방문 전이면
					if (!isVisited[move[next]]) {
						// 이동한 칸을 넣고
						bfsQue.offer(move[next]);
						// 이동한 칸 방문여부 표시
						isVisited[move[next]] = true;
						// 주사위 던진 횟수 1 추가
						count[move[next]] = count[front] + 1;
					}
				} else {
					// 사다리와 뱀이 없으면
					// 주사위를 던져서 이동한 칸을 추가하고
					bfsQue.offer(next);
					// 주사위 던진 횟수 1 추가
					count[next] = count[front] + 1;
				}
			}
		}
	}

}
