package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem10828 {

	// 10828. 스택
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 명령 개수
		int N = Integer.parseInt(br.readLine());
		// 스택 생성
		Stack<Integer> intStack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 명령 입력
			String command = st.nextToken();

			// 입력한 명령에 맞춰 동작
			switch (command) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				intStack.push(x);
				break;
			case "pop":
				if (intStack.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(intStack.pop()).append('\n');
				}
				break;
			case "size":
				sb.append(intStack.size()).append('\n');
				break;
			case "empty":
				if (intStack.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "top":
				if (intStack.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(intStack.peek()).append('\n');
				}
				break;
			}
		}
		// 결과 출력
		System.out.println(sb);

	}
}
