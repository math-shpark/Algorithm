package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem15663 {

	// 뽑을 숫자 배열
	static int[] numArr;
	// 뽑은 숫자 배열
	static int[] selected;
	// 숫자 선택 여부 저장 배열
	static boolean[] isSelected;
	// 결과 수열 집합
	static HashSet<String> resultSet = new HashSet<>();
	// 결과 문자열 생성
	static StringBuilder sb = new StringBuilder();

	// 15663. N과 M (9)
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 배열 크기 입력
		numArr = new int[N];
		selected = new int[M];
		isSelected = new boolean[N];

		// 배열에 뽑을 숫자 목록 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 출력을 위해 배열 정렬
		Arrays.sort(numArr);

		// 순열
		permutation(0);

		// 결과 출력
		System.out.println(sb);

	}

	// 순열
	private static void permutation(int count) {

		// 경계
		if (count == selected.length) {
			// 임시 문자열
			StringBuilder temp = new StringBuilder();

			// 현재 만든 수열로 문자열 생성
			for (int num : selected) {
				temp.append(num).append(" ");
			}

			// 해당 문자열이 아직 만든 적이 없으면
			// 결과 문자열과 집합에 해당 문자열 추가 및 연결
			if (!resultSet.contains(temp.toString())) {
				sb.append(temp.toString()).append('\n');
				resultSet.add(temp.toString());
			}

			// 재귀 종료
			return;
		}

		// 재귀(순열)
		// 방문 배열을 활용하여 오름차순으로 순열을 생성하도록 재귀 실행
		for (int i = 0; i < numArr.length; i++) {
			if (isSelected[i] == false) {
				selected[count] = numArr[i];
				isSelected[i] = true;
				permutation(count + 1);
				isSelected[i] = false;
			}
		}

	}

}
