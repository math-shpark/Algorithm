package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem10866 {

	// 10866. 덱
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 정수를 저장할 덱
		Deque<Integer> intDeq = new LinkedList<>();

		// 명령 개수
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 명령을 입력받아
			String command = st.nextToken();

			// 입력받은 명령에 맞춰 동작
			switch (command) {
			case "push_front":
				int num = Integer.parseInt(st.nextToken());
				intDeq.addFirst(num);
				break;
			case "push_back":
				int num2 = Integer.parseInt(st.nextToken());
				intDeq.add(num2);
				break;
			case "pop_front":
				if (intDeq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(intDeq.pollFirst()).append('\n');
				}
				break;
			case "pop_back":
				if (intDeq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(intDeq.pollLast()).append('\n');
				}
				break;
			case "size":
				sb.append(intDeq.size()).append('\n');
				break;
			case "empty":
				if (intDeq.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "front":
				if (intDeq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(intDeq.peekFirst()).append('\n');
				}
				break;
			case "back":
				if (intDeq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(intDeq.peekLast()).append('\n');
				}
				break;
			}
		}

		// 결과 출력
		System.out.println(sb);

	}

}
