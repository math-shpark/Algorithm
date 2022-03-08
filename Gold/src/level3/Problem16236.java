package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 상어 클래스 생성
class Shark {
	public int x;
	public int y;

	public Shark(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Problem16236 {

	// 델타 탐색 배열
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 공간 정보 배열
	static int[][] space;
	// 상어 위치 기준 거리를 저장할 배열
	static int[][] distance;
	// 상어 크기
	static int sharkSize = 2;
	// 상어 좌표
	static int sharkX = 0;
	static int sharkY = 0;
	// 먹을 생선의 좌표
	static int targetX;
	static int targetY;
	// 먹을 생선과의 거리
	static int minDistance;

	// 16236. 아기 상어
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		space = new int[N][N];

		// 공간 정보를 배열에 저장하고 상어의 좌표를 찾는 반복문
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// 공간 정보 입력
				space[i][j] = Integer.parseInt(st.nextToken());
				// 상어 위치 확인
				if (space[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					space[i][j] = 0;
				}
			}
		}

		// 이동 시간
		int time = 0;
		// 먹은 생선의 개수
		int count = 0;

		while (true) {
			// 거리 배열 생성
			distance = new int[N][N];
			// 먹을 생선의 좌표 초기화
			targetX = N;
			targetY = N;
			// 먹을 생선과의 거리 초기화
			minDistance = N * N;

			// 탐색 메소드
			search(sharkX, sharkY);

			// 탐색 결과로 구한 먹을 생선의 좌표가
			// 초기값과 다르면 실제 먹을 생선이 존재하는 것이므로
			if (targetX < N && targetY < N) {
				// 먹은 생선의 개수에 1을 추가하고
				count++;
				// 해당 위치에는 생선이 이제 없어지고
				space[targetX][targetY] = 0;
				// 상어의 위치는 방금 먹은 생선의 위치로 이동
				sharkX = targetX;
				sharkY = targetY;
				// 1칸에 1초가 걸리므로
				// 해당 위치까지의 거리가 곧 시간
				time += distance[targetX][targetY];

				// 방금 먹은 생선까지의 개수가 상어의 크기와 동일하면
				if (count == sharkSize) {
					// 상어의 크기는 1 커지고
					sharkSize++;
					// 먹은 생선의 개수 초기화
					count = 0;
				}
			} else {
				// 먹을 생선의 좌표가 여전히 초기값이면
				// 먹을 수 있는 생선이 없는 것이므로 반복문 종료
				break;
			}
		}

		// 결과 출력
		System.out.println(time);

	}

	// 탐색 메소드
	private static void search(int x, int y) {

		// 상어들을 저장하는 큐
		Queue<Shark> sharkList = new LinkedList<>();
		// 처음 상어 1마리 추가
		sharkList.add(new Shark(x, y));

		// 이동 가능한 상어가 1마리도 남아있지 않으면 큐 종료
		while (sharkList.isEmpty() == false) {
			// 상어가 저장된 큐에서 1마리를 꺼낸 후
			Shark shark = sharkList.poll();

			// 델타 탐색을 진행하고
			for (int i = 0; i < 4; i++) {
				int newX = shark.x + dr[i];
				int newY = shark.y + dc[i];

				// 새로운 좌표가 공간 안에 있고
				// 이동 가능한 좌표이고
				// 아직 거리 값을 입력하지 않은 좌표이면
				if (newX >= 0 && newX < space.length && newY >= 0 && newY < space.length
						&& space[newX][newY] <= sharkSize && distance[newX][newY] == 0) {
					// 이전 좌표까지 이동한 거리에 1을 더해 새로운 좌표로 위치를 옮기고
					distance[newX][newY] = distance[shark.x][shark.y] + 1;

					// 해당 좌표에 먹을 수 있는 생선이 있으면
					if (space[newX][newY] > 0 && space[newX][newY] < sharkSize) {
						// 해당 생선의 좌표가 최소 거리인지 판별하고
						if (minDistance > distance[newX][newY]) {
							// 최소 거리면 해당 위치와 거리를 저장
							minDistance = distance[newX][newY];
							targetX = newX;
							targetY = newY;
						} else if (minDistance == distance[newX][newY]) {
							// 최소 거리가 같은 경우
							// 높이가 같은데
							if (targetX == newX) {
								// 더 좌측에 있으면
								if (targetY > newY) {
									// 좌표 최신화
									targetX = newX;
									targetY = newY;
								}
							} else if (targetX > newX) {
								// 높이가 더 높으면 바로 최신화
								targetX = newX;
								targetY = newY;
							}
						}
					}
					// 먹은지 여부와 상관없이 이동이 가능했으면
					// 아직 해당 방향의 상어가 살아 있으므로 다시 큐에 추가
					sharkList.add(new Shark(newX, newY));
				}
			}
		}

	}

}
