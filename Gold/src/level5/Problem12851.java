package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem12851 {

	static int N, K; // 입력값
	static boolean[] isVisited = new boolean[100001]; // 방문 여부
	static int time; // 최소 시간
	static int count; // 경우의 수

	// 12851. 숨바꼭질
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 매개변수
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		time = 0;
		count = 0;

		// 수빈이가 오른쪽에 있으면 왼쪽 이동만이 최소
		if (N >= K) {
			System.out.println(N - K);
			System.out.println(1);
			return;
		} else
			bfs(N);

		System.out.println(time);
		System.out.println(count);

	}

	// bfs
	private static void bfs(int start) {
		Queue<Integer> bfsQue = new LinkedList<Integer>();
		bfsQue.add(start);

		while (!bfsQue.isEmpty() && count == 0) {
			int range = bfsQue.size(); // 동시간대 기준 좌표
			for (int i = 0; i < range; i++) {
				int front = bfsQue.poll(); // 기준 좌표 하나 꺼내기
				isVisited[front] = true;
				int next;

				// 1. 왼쪽
				next = front - 1;
				if (next == K)
					count++;
				else if (next >= 0 && !isVisited[next])
					bfsQue.add(next);

				// 2. 오른쪽
				next = front + 1;
				if (next == K)
					count++;
				else if (next <= 100000 && !isVisited[next])
					bfsQue.add(next);

				// 3. 순간이동
				next = front * 2;
				if (next == K)
					count++;
				else if (next <= 100000 && !isVisited[next])
					bfsQue.add(next);

			} // 1초 작업 종료
			time++; // 시간 반영
		} // 반복 종료
	} // bfs 종료
}
