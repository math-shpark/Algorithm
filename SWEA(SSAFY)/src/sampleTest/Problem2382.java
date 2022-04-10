package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem2382 {

	static class Micro implements Comparable<Micro> {
		// 좌표
		int x, y;
		// 미생물 수
		int count;
		// 방향
		int direction;

		public Micro(int x, int y, int count, int direction) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.direction = direction;
		}

		@Override
		// 내림차순 정렬
		public int compareTo(Micro o) {
			return o.count - this.count;
		}
	}

	// 매개변수
	static int N, M, K;
	// 공간 정보
	static Micro space[][];
	// 델타 탐색
	// 인덱스 통일을 위해 0번 인덱스는 비움
	// 상하좌우
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };
	// 미생물 군집을 담을 우선순위 큐
	static PriorityQueue<Micro> queue;

	// 2382. 미생물 격리
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 공간 크기
			N = Integer.parseInt(st.nextToken());
			// 격리 시간
			M = Integer.parseInt(st.nextToken());
			// 군집 개수
			K = Integer.parseInt(st.nextToken());
			// 공간 크기 입력
			space = new Micro[N][N];
			// 우선순위 큐 초기화
			queue = new PriorityQueue<Micro>();

			// 미생물 정보 입력
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				// 미생물 군집 정보
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());

				// 미생물 객체 생성
				Micro newMicro = new Micro(x, y, count, direction);

				// 입력되는 값으로 미생물 객체를 생성하여 우선순위 큐에 입력
				// 미생물 클래스 내부에 오버라이딩한 compareTo 메서드에 의해 내림차순으로 정렬된다.
				queue.add(newMicro);
			}

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(process()).append('\n');
		}

		// 결과 출력
		System.out.println(sb);
	}

	// 제한 시간동안 미생물이 움직인 결과를 계산
	private static int process() {
		// 남은 시간
		int time = M;
		// 남은 미생물 개수 총합
		int result = 0;

		// 1시간씩 감소하면서
		// 시간이 0이 될 때까지 반복
		while (time-- > 0) {
			while (!queue.isEmpty()) {
				// 큐에서 미생물 군집을 하나 꺼냄
				Micro now = queue.poll();

				// 이동할 좌표로 좌표 변경
				// 현재 방향을 인덱스로 취해 좌표 계산
				now.x += dr[now.direction];
				now.y += dc[now.direction];

				// 1. 약품 칸에 도달할 경우
				if (now.x == 0 || now.x == N - 1 || now.y == 0 || now.y == N - 1) {
					// 미생물 개수를 절반으로 줄임
					now.count /= 2;

					// 절반으로 줄인 개수가 0이면 소멸
					// 큐에 추가 안됨
					if (now.count == 0)
						continue;

					// 1마리라도 남아있으면 방향 전환
					// 1, 3번 인덱스면 2, 4번 인덱스가 반대방향이므로 더하고
					if (now.direction % 2 == 1)
						now.direction++;
					else
						// 2, 4번 인덱스면 1, 3번 인덱스가 반대방향이므로 뺀다.
						now.direction--;
				}

				// 2. 약품 칸 내부에서 이동할 경우
				// 2-1. 이동할 칸에 미생물 군집이 없는 경우
				if (space[now.x][now.y] == null) {
					// 지금 미생물 군집을 해당 좌표로 이동
					space[now.x][now.y] = now;
				} else {
					// 2-2. 이미 해당 좌표에 군집이 있는 경우
					// 이미 있는 미생물 수와 현재 군집 내 미생물 수를 더함
					// 이미 있다는 것은 더 큰 군집이 해당 위치에 있으므로 현재 군집의 방향은 무시된다.
					space[now.x][now.y].count += now.count;
				}
			}
			// 남아있는 미생물 군집을 다시 큐에 넣고
			// 현재까지 남아있는 미생물 수 최신화
			result = reset();
		}
		return result;
	}

	// 1시간 작업 후 결과를 다시 반영하는 메서드
	private static int reset() {
		// 현재 남아있는 미생물 수
		int result = 0;

		// 각 좌표를 돌면서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 미생물 군집이 있으면
				if (space[i][j] != null) {
					// 큐에 해당 군집 정보를 넣음
					queue.add(space[i][j]);
					// 미생물 수 누적
					result += space[i][j].count;
					// 큐에 넣었으므로 공간에는 제거한다.(이동하기 때문)
					space[i][j] = null;
				}
			}
		}

		// 현재까지 남아있는 미생물 수 반환
		return result;
	}

}
