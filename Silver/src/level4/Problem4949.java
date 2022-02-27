package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem4949 {

	// 4949. 균형잡힌 세상
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = null;

		// 입력한 문자열이 .이 아닐 때까지 반복
		while (!(str = br.readLine()).equals(".")) {
			// 괄호를 저장할 스택 생성
			Stack<Character> list = new Stack<>();
			// 균형잡혀 있는지 여부를 저장할 변수
			boolean isOkay = true;

			// 한 글자씩 확인하며 균형 여부 확인
			for (int i = 0; i < str.length(); i++) {
				// 한 글자 입력
				char literal = str.charAt(i);

				// 개괄호면 스택에 추가
				// 폐괄호면 마지막에 나온 괄호와 쌍인지 여부를 확인하여
				// 해당 괄호를 스택에서 지우고
				// 아니면 isOkay에 false를 저장하여 반복문 종료
				if (literal == '(' || literal == '[') {
					list.push(literal);
				} else if (literal == ')') {
					if (list.isEmpty() || list.peek() != '(') {
						isOkay = false;
						break;
					} else {
						list.pop();
					}
				} else if (literal == ']') {
					if (list.isEmpty() || list.peek() != '[') {
						isOkay = false;
						break;
					} else {
						list.pop();
					}
				}

			}

			// isOkay가 true 이고
			// 모든 괄호를 사용하여 스택이 비어 있어야 yes
			// 아니면 모두 no
			if (list.isEmpty() && isOkay) {
				sb.append("yes").append('\n');
			} else {
				sb.append("no").append('\n');
			}
		}

		// 결과 출력
		System.out.println(sb);

	}

}
