package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 위치 정보
class Tomato {
	int x;
	int y;

	Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Problem7569 {

	// 7569. 토마토
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 박스 너비
		int M = Integer.parseInt(st.nextToken());
		// 박스 높이
		int N = Integer.parseInt(st.nextToken());
		// 박스 개수
		int H = Integer.parseInt(st.nextToken());

		// 박스 공간 크기 지정
		int[][] space = new int[N * H][M];
		Queue<Tomato> bfsQue = new LinkedList<>();

		// 익지 않은 토마토의 개수
		int tomatoCount = 0;

		// 토마토 정보 입력
		for (int i = 0; i < N * H; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				// 익은 토마토면 큐에 추가
				if (space[i][j] == 1) {
					bfsQue.add(new Tomato(i, j));
				} else if (space[i][j] == 0) {
					// 익지 않은 토마토면 개수에 추가
					tomatoCount++;
				}
			}
		}

		// 소요 날짜
		int dayCount = 0;

		// 델타 탐색
		int[] dr = { -1, 0, 1, 0, N, -N };
		int[] dc = { 0, 1, 0, -1, 0, 0 };

		// bfs
		while (!bfsQue.isEmpty()) {

			// 이미 토마토가 다 익으면 반복문 종료
			if (tomatoCount == 0) {
				break;
			}

			// 출발점이 되는 토마토의 개수
			int startTomato = bfsQue.size();

			// 해당 토마토 개수만큼 반복
			for (int start = 0; start < startTomato; start++) {
				// 토마토 1개를 꺼낸 후
				Tomato tomato = bfsQue.poll();
				// 해당 토마토의 위치를 입력받고
				int x = tomato.x;
				int y = tomato.y;

				// 6방향의 델타탐색을 진행해서
				for (int i = 0; i < 6; i++) {
					int newX = x + dr[i];
					int newY = y + dc[i];

					// 상 방향 이동이 층 수 이동이면 건너뛰기
					if (i == 0 && newX % N == N - 1) {
						continue;
					} else if (i == 2 && newX % N == 0) {
						// 하 방향 이동이 층 수 이동이면 건너뛰기
						continue;
					}

					// 이동 가능 거리에서 익지 않은 토마토가 있으면
					// 익은 토마토로 바꾸고 해당 좌표를 큐에 추가
					// 익지 않은 토마토 개수 1 차감
					if (newX >= 0 && newX < N * H && newY >= 0 && newY < M) {
						if (space[newX][newY] == 0) {
							space[newX][newY] = 1;
							bfsQue.add(new Tomato(newX, newY));
							tomatoCount--;
						}
					}
				}
			}
			// 하루 종료
			dayCount++;
		}

		// 익지 않은 토마토가 남아있는지 여부에 따라 결과 출력
		if (tomatoCount == 0) {
			System.out.println(dayCount);
		} else {
			System.out.println(-1);
		}

	}

}
