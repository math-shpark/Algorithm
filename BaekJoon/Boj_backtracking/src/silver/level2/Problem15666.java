package silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem15666 {

	// 뽑을 숫자 배열
	static int[] numArr;
	// 뽑은 숫자의 배열
	static int[] selected;
	// 결과 문자열 집합
	static HashSet<String> resultSet = new HashSet<>();
	// 뽑을 숫자의 개수
	static int N;
	// 뽑은 숫자의 개수
	static int M;
	// 결과 문자열 생성
	static StringBuilder sb = new StringBuilder();

	// 15666. N과 M(12)
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N과 M 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 배열 크기 입력
		numArr = new int[N];
		selected = new int[M];

		// 뽑을 수 있는 숫자 정보 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		// 비내림차순 출력을 위해 오름차순으로 정렬
		Arrays.sort(numArr);

		// 중복 조합
		combination(0, 0);

		// 결과 출력
		System.out.println(sb);

	}

	// 중복 조합
	private static void combination(int start, int count) {

		// 경계
		// 원하는 개수의 숫자를 뽑은 경우 재귀 종료
		if (count == M) {
			// 현재 수열로 문자열 생성
			StringBuilder sb2 = new StringBuilder();
			for (int num : selected) {
				sb2.append(num).append(" ");
			}

			// 수열로 만든 문자열이 처음 나온 결과면
			if (!resultSet.contains(sb2.toString())) {
				// 결과 문자열에 연결
				sb.append(sb2.toString()).append('\n');
				// 결과 문자열 집합에 추가
				resultSet.add(sb2.toString());
			}

			// 재귀 종료
			return;
		}

		// 재귀
		for (int i = start; i < N; i++) {
			selected[count] = numArr[i];
			combination(i, count + 1);
		}

	}

}
