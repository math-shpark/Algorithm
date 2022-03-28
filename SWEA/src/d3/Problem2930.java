package d3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem2930 {

	// 2930. 힙
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int testCase = scan.nextInt();

		for (int test = 1; test <= testCase; test++) {
			// 연산 개수 입력
			int N = scan.nextInt();

			// 우선 순위 큐 생성
			PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o2 - o1);
			sb.append("#").append(test).append(" ");

			// 입력받은 수를 규칙에 맞춰 작업 수행
			for (int i = 0; i < N; i++) {
				int num = scan.nextInt();
				

				switch (num) {
				case 2:
					if (que.isEmpty()) {
						sb.append(-1).append(" ");
					} else {
						sb.append(que.poll()).append(" ");
					}
					break;
				default:
					que.add(scan.nextInt());
					break;
				}
			}
			
			sb.append('\n');

		}

		// 결과 출력
		System.out.println(sb);

		scan.close();

	}

}
