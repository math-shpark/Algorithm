package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem11286 {

	// 11286. 절댓값 힙
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 연산 개수 입력
		int N = Integer.parseInt(br.readLine());

		// 우선 순위 큐 생성
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {

			// 제시된 조건에 맞춰 정렬하도록 compare 메서드 정의
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2);
			}
		});

		// 입력받은 수를 규칙에 맞춰 작업 수행
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			switch (num) {
			case 0:
				if (que.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(que.poll()).append('\n');
				}
				break;
			default:
				que.add(num);
				break;
			}
		}

		// 결과 출력
		System.out.println(sb);

	}

}
