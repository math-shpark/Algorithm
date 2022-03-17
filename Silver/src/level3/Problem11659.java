package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11659 {

	// 11659. 구간 합 구하기 4
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 숫자 개수
		int N = Integer.parseInt(st.nextToken());
		// 덧셈 횟수
		int M = Integer.parseInt(st.nextToken());

		// 숫자 누적합 배열
		int[] numArr = new int[N];

		st = new StringTokenizer(br.readLine());
		// 숫자 정보를 입력받아 누적합
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
			if (i > 0) {
				numArr[i] += numArr[i - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			// 시작 인덱스
			int start = Integer.parseInt(st.nextToken()) - 1;
			// 종료 인덱스
			int end = Integer.parseInt(st.nextToken()) - 1;
			// 덧셈 값
			int sum = 0;

			// 종료 인덱스까지 누적합을 더한 후
			sum += numArr[end];
			// 시작점이 1번이 아니면 시작점 이전의 누적합을 빼기
			if (start != 0) {
				sum -= numArr[start - 1];
			}

			sb.append(sum).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

}
