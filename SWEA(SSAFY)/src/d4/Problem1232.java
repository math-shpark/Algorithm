package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1232 {

	// 노드 연결 정보를 저장할 배열
	static int[][] tree;
	// 노드 안에 적힌 데이터를 문자열로 저장하는 배열
	static String[] data;
	// 후위 연산으로 사용할 스택
	static Stack<Double> number;

	// 1232. 사칙연산
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 10번의 테스트 케이스 반복
		for (int test = 1; test <= 10; test++) {
			int N = Integer.parseInt(br.readLine());

			// 노드 번호를 인덱스로 취하기 위해
			// 노드 개수보다 1 큰 크기의 배열로 지정
			tree = new int[N + 1][2];
			data = new String[N + 1];

			// 스택 생성
			number = new Stack<>();

			// 연결 정보를 입력하고
			// 노드 내 데이터를 입력하는 반복문
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int nodeNum = Integer.parseInt(st.nextToken());
				data[nodeNum] = st.nextToken();

				if (st.hasMoreTokens()) {
					tree[nodeNum][0] = Integer.parseInt(st.nextToken());
					tree[nodeNum][1] = Integer.parseInt(st.nextToken());
				}
			}

			// 1번 노드를 기준으로 후위 순회하여 스택 생성하는 메소드
			makeStack(1);

			sb.append("#").append(test).append(" ");

			// 연산 결과로 1개의 숫자만 스택에 남아있으므로 꺼낸 후
			double result = number.pop();

			// 결과로 출력
			sb.append((int) result).append('\n');

		}

		System.out.println(sb);
	}

	private static void makeStack(int nodeNum) {

		// 마지막 노드면 숫자이므로 숫자로 변환한 후 스택에 추가
		if (tree[nodeNum][0] == 0 && tree[nodeNum][1] == 0) {
			number.push(Double.parseDouble(data[nodeNum]));
		} else {
			// 마지막 노드가 아니면
			// 후위 순회를 한 후
			makeStack(tree[nodeNum][0]);
			makeStack(tree[nodeNum][1]);

			// 스택 맨 위 2개의 숫자를 꺼내
			double b = number.pop();
			double a = number.pop();

			double result = 0;

			// 현재 노드 안에 적힌 연산자에 맞춰 연산한 결과를
			switch (data[nodeNum]) {
			case "+":
				result += a + b;
				break;
			case "-":
				result += a - b;
				break;
			case "*":
				result += a * b;
				break;
			case "/":
				result += a / b;
				break;
			}
			// 다시 스택에 넣음
			number.push(result);

		}

	}

}
