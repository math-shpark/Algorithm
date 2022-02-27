package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem1874 {

	// 1874. 스택 수열
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// n 입력
		int n = Integer.parseInt(br.readLine());
		// 스택에 추가할 다음 숫자
		int nextPush = 1;
		// 가능 여부 저장
		boolean isPossible = true;
		// 스택
		Stack<Integer> numStack = new Stack<>();

		for (int i = 0; i < n; i++) {
			// 수열 다음 숫자 읽기
			int nextNum = Integer.parseInt(br.readLine());

			// 스택에 숫자가 없거나
			// top의 숫자가 수열 숫자보다 작으면
			// 해당 숫자가 top이 될 때까지 push하고
			// 해당 숫자를 pop
			// 수열 숫자와 top 숫자가 동일하면
			// 해당 숫자를 pop
			// 수열 숫자가 top 숫자보다 작으면 불가능
			if (numStack.isEmpty() || numStack.peek() < nextNum) {
				while (numStack.isEmpty() || numStack.peek() != nextNum) {
					numStack.push(nextPush++);
					sb.append("+").append('\n');
				}
				numStack.pop();
				sb.append("-").append('\n');
			} else if (numStack.peek() == nextNum) {
				numStack.pop();
				sb.append("-").append('\n');
			} else {
				isPossible = false;
			}
		}

		// 가능 여부에 따라 출력
		if (isPossible) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}

	}

}
