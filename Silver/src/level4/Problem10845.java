package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem10845 {

	// 10845. 큐
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 명령 개수
		int N = Integer.parseInt(br.readLine());
		// 큐 생성
		Queue<Integer> intQue = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 명령 입력
			String command = st.nextToken();

			// 입력한 명령에 맞춰 동작
			switch (command) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				intQue.add(x);
				break;
			case "pop":
				if (intQue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(intQue.poll()).append('\n');
				}
				break;
			case "size":
				sb.append(intQue.size()).append('\n');
				break;
			case "empty":
				if (intQue.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "front":
				if (intQue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(intQue.peek()).append('\n');
				}
				break;
			case "back":
				if (intQue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					for (int j = 0; j < intQue.size(); j++) {
						if (j == intQue.size() - 1) {
							int front = intQue.poll();
							sb.append(front).append('\n');
							intQue.add(front);
						} else {
							int front = intQue.poll();
							intQue.add(front);
						}
					}
				}
				break;
			}
		}

		// 결과 출력
		System.out.println(sb);

	}

}
