package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13549 {

	static class Node {
		int x, time;

		Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	// 13549. 숨바꼭질 3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 변수 입력
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int time = 100001; // 최소 시간

		Queue<Node> bfsQue = new LinkedList<Node>();
		boolean[] isVisited = new boolean[100001]; // 탐색 여부

		bfsQue.add(new Node(N, 0));

		while (!bfsQue.isEmpty()) {
			Node front = bfsQue.poll();
			isVisited[front.x] = true;

			if (front.x == K) {
				if (front.time < time)
					time = front.time;
				break;
			} // 동생을 찾은 경우

			// 순간이동
			if (front.x * 2 <= 100000 && !isVisited[front.x * 2])
				bfsQue.add(new Node(front.x * 2, front.time)); // 시간 유지
			
			// 왼쪽
			if (front.x - 1 >= 0 && !isVisited[front.x - 1])
				bfsQue.add(new Node(front.x - 1, front.time + 1));

			// 오른쪽
			if (front.x + 1 <= 100000 && !isVisited[front.x + 1])
				bfsQue.add(new Node(front.x + 1, front.time + 1));

		}

		System.out.println(time);
	}

}
