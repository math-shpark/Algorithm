package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15657 {

	// 숫자 데이터
	static int[] numArr;
	// 뽑은 숫자 데이터
	static int[] select;
	// 문자열 작성
	static StringBuilder sb = new StringBuilder();

	// 15657. N과 M(8)
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 배열 크기 입력
		numArr = new int[N];
		select = new int[M];

		// 숫자 데이터 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순으로 정렬
		Arrays.sort(numArr);

		// 뽑기 실행
		dfs(0, 0);

		// 결과 출력
		System.out.println(sb);

	}

	private static void dfs(int start, int count) {

		// 경계
		// 뽑은 숫자의 개수가 원하는 숫자의 개수면 재귀 종료
		if (count == select.length) {
			for (int num : select) {
				sb.append(num).append(" ");
			}
			sb.append('\n');
			return;
		}

		// 재귀
		// 중복이 허용되므로 뽑을 수 있는 숫자의 범위는
		// 0번 인덱스부터 N-1번 인덱스까지로 고정
		for (int i = start; i < numArr.length; i++) {
			select[count] = numArr[i];
			// 중복 선택
			dfs(i, count + 1);
		}

	}

}
