package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1966 {

	// 1966. 프린터 큐
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 0; test < testCase; test++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			// 숫자 개수 입력
			int N = Integer.parseInt(st.nextToken());
			// 목표 숫자의 인덱스
			int target = Integer.parseInt(st.nextToken());
			// 숫자를 저장할 큐
			Queue<Integer> numQue = new LinkedList<Integer>();
			// 우선순위를 저장할 배열
			int[] priority = new int[N];
			// 우선순위를 확인할 인덱스
			int index = priority.length - 1;
			st = new StringTokenizer(br.readLine());

			// 큐에 숫자를 넣고
			// 우선순위 배열에 우선순위 저장
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				numQue.add(num);
				priority[i] = num;
			}

			// 배열 정렬
			Arrays.sort(priority);

			while (true) {

				// front 숫자가 제일 높은 우선순위면
				if (numQue.peek() == priority[index]) {
					// 해당 숫자를 내보내고
					numQue.poll();
					// 기준 우선순위 인덱스를 다음으로 넘기고
					index--;
					// 방금 내보낸 숫자가 목표 숫자면
					if (target == 0) {
						// 전체 숫자 개수에서 남은 숫자의 개수를 뺀 것이 해당 숫자의 순서
						System.out.println(N - numQue.size());
						break;
					} else {
						// 목표 숫자가 아니면
						// 목표 숫자는 뒤에서 당겨지므로 인덱스 1 감소
						target--;
					}
				} else {
					// 나갈 순서의 숫자가 아니면
					// 빼서
					int front = numQue.poll();
					// 뒤로 다시 넣음
					numQue.add(front);
					// 해당 숫자가 목표 숫자가 아니면
					if (target > 0) {
						// 목표 숫자는 당겨지므로 인덱스 1 감소
						target--;
					} else {
						// 목표 숫자였으면
						// 뒤에 다시 추가되므로 해당 인덱스 저장
						target = numQue.size() - 1;
					}
				}

			}

		}

	}

}
