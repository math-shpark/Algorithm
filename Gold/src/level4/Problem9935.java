package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));

			if (stack.size() >= bomb.length()) {
				boolean isBomb = true;

				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						isBomb = false;
						break;
					}
				}

				if (isBomb) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Character c : stack) {
				sb.append(c);
			}
			System.out.println(sb);
		}
	}

}
