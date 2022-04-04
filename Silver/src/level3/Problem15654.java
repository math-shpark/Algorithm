package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15654 {

	// 뽑힐 숫자 모음
	static int[] numArr;
	// 뽑은 숫자 모음
	static int[] select;
	// 뽑은 숫자인지 여부를 저장할 배열
	static boolean[] isSelected;
	// 문자열 생성
	static StringBuilder sb = new StringBuilder();

	// 15654. N과 M(5)
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 배열 크기 입력
		numArr = new int[N];
		select = new int[M];
		isSelected = new boolean[N];

		// 뽑힐 숫자 정보 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순으로 정렬
		Arrays.sort(numArr);

		// 뽑는 재귀함수 실행
		dfs(0);

		// 결과 출력
		System.out.println(sb);

	}

	private static void dfs(int count) {

		// 경계
		// 뽑은 숫자가 원하는 숫자 개수면 재귀 종료
		if (count == select.length) {
			for (int num : select) {
				sb.append(num).append(" ");
			}
			sb.append('\n');

			return;
		}

		// 재귀
		for (int i = 0; i < numArr.length; i++) {
			// 아직 선택한 값이 아니면
			// 선택한 값을 저장
			if (isSelected[i] == false) {
				select[count] = numArr[i];
				// 선택 여부 저장
				isSelected[i] = true;
				// 다음 수로 재귀
				dfs(count + 1);
				// 다시 선택하지 않은 상태로 복원
				isSelected[i] = false;
			}
		}

	}

}
