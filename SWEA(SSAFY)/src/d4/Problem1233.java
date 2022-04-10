package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1233 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 10번의 테스트 케이스 반복
		for (int test = 1; test <= 10; test++) {
			// 정점 개수 입력
			int N = Integer.parseInt(br.readLine());
			// 계산 가능 여부 저장
			boolean isPossible = true;

			// 노드별 정보 판별
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 노드 번호 입력(사용 X)
				st.nextToken();
				// 노드 번호 다음 데이터 입력
				char data = st.nextToken().charAt(0);

				// 노드 번호 안의 데이터가 입력되고
				// 추가 입력이 있는 경우
				if (st.hasMoreTokens()) {
					// 노드 안의 데이터가 연산자가 아니면
					if (data >= '0' && data <= '9') {
						// 계산 불가 표시
						isPossible = false;
					}
				} else {
					// 추가 입력이 없는데
					// 노드 안의 데이터가 연산자였으면
					if (data < '0' || data > '9') {
						// 계산 불가 표시
						isPossible = false;
					}
				}
			}

			// 출력 양식
			sb.append("#").append(test).append(" ");

			// 계산 가능 여부에 맞춰 결과 출력
			if (isPossible) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}

		// 결과 출력
		System.out.println(sb);
	}

}
