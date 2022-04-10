package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16953 {

	// 노드 클래스 생성
	static class Node {
		long data;
		long connect1;
		long connect2;

		Node(long data) {
			// 노드 번호 입력
			this.data = data;
			// 2를 곱한 수 연결
			this.connect1 = data * 2;
			// 오른쪽에 1을 추가한 수 연결
			this.connect2 = data * 10 + 1;
		}
	} // 노드 클래스 생성 완료

	// 16953. A -> B
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// A, B 입력
		// 최대 입력 가능 수가 10의 9제곱 이므로 long 타입 선언
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		// bfs에서 활용할 큐 생성
		Queue<Node> bfsQue = new LinkedList<>();
		// A 노드 생성해서 큐에 추가
		Node start = new Node(A);
		bfsQue.add(start);

		// 최소 연산 횟수
		int result = -1;

		// 최소 연산 횟수를 구할 때까지 임시 연산 횟수
		int count = 1;

		// bfs
		while (!bfsQue.isEmpty()) {

			long range = bfsQue.size();

			for (int i = 0; i < range; i++) {
				Node front = bfsQue.poll();

				// 찾으려는 숫자를 만들었으면 반복문 종료
				if (front.data == B) {
					result = count;
					break;

				}

				// 찾으려는 숫자가 아직 아니면
				// 1. 2배한 수를 큐에 추가
				// 단, 찾으려는 숫자보다 작을 때만
				Node next1 = new Node(front.connect1);
				if (next1.data <= B) {
					bfsQue.add(next1);
				}

				// 2. 1을 오른쪽에 추가한 수를 큐에 추가
				// 단, 찾으려는 숫자보다 작을 때만
				Node next2 = new Node(front.connect2);
				if (next2.data <= B) {
					bfsQue.add(next2);
				}
			}

			count++;

		}

		// 결과 출력
		System.out.println(result);

	}

}
