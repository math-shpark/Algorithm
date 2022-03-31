package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem5430 {

	// 5430. AC
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		// 입력한 개수만큼 반복
		Outer: for (int test = 1; test <= testCase; test++) {
			// 함수를 읽어 char 타입의 배열로 변환
			char[] function = br.readLine().toCharArray();
			// 숫자의 개수 입력
			int count = Integer.parseInt(br.readLine());

			// 덱 생성
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			// 숫자를 제외한 문자는 읽지 않도록 설정
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

			// 숫자 값을 가지는 문자열을 정수로 변환한 후
			// 덱에 추가
			for (int i = 0; i < count; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			// 시작 방향을 저장할 변수
			boolean rightDir = true;

			// 입력한 함수의 개수만큼 반복
			for (int i = 0; i < function.length; i++) {
				// 함수 하나를 읽어서
				char command = function[i];

				// 해당 함수에 맞춰 동작
				switch (command) {
				// R 함수일 경우
				case 'R':
					// 시작 방향을 반대로 뒤집기
					rightDir = !rightDir;
					break;
				// D 함수일 경우
				case 'D':
					// 덱에 숫자가 없으면
					// error를 출력한 후 다음 테스트 케이스로 이동
					if (deque.size() == 0) {
						sb.append("error").append('\n');
						continue Outer;
					}

					// 덱에 숫자가 있으면
					// 시작 방향에 맞춰 숫자 제거
					if (rightDir) {
						deque.pollFirst();
					} else {
						deque.pollLast();
					}
					break;
				}
			}

			// 결과 문자열 양식
			sb.append('[');

			// 덱에 숫자가 남아있으면
			// 시작 방향에 따라 해당 방향으로 숫자를 꺼낸 후
			// 결과 문자열에 붙이기
			if (deque.size() != 0) {
				if (rightDir) {
					sb.append(deque.pollFirst());
					while (!deque.isEmpty()) {
						sb.append(',').append(deque.pollFirst());
					}
				} else {
					sb.append(deque.pollLast());
					while (!deque.isEmpty()) {
						sb.append(',').append(deque.pollLast());
					}
				}
			}

			// 결과 문자열 양식
			sb.append(']').append('\n');

		}
		// 결과 출력
		System.out.println(sb);

	}

}
