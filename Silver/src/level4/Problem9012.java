package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem9012 {

	// 9012. 괄호
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			// VPS여부 저장 변수
			boolean isVPS = true;
			// 괄호를 저장할 스택
			Stack<Character> list = new Stack<>();
			// 한 문장 읽음
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				// 한 글자씩 확인하며
				char ch = str.charAt(j);

				if (ch == '(') {
					// 개괄호면 스택에 추가하고
					list.push(ch);
				} else {
					// 폐괄호면
					// top이 개괄호면 해당 괄호를 pop
					if (!list.isEmpty() && list.peek() == '(') {
						list.pop();
					} else {
						// 나머지 경우는 모두 VPS가 아님
						isVPS = false;
						break;
					}
				}
			}

			// 폐괄호를 사용하여 개괄호를 모두 pop했는데도
			// 아직 개괄호가 남은 것도 VPS가 아님
			if (!list.isEmpty()) {
				isVPS = false;
			}

			// VPS 여부에 따라 결과 출력
			if (isVPS) {
				sb.append("YES").append('\n');
			} else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb);

	}

}
