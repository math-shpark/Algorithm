package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1920 {

	// 1920. 수 찾기
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// N 입력
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N개의 숫자를 저장할 배열
		int[] numArr = new int[N];

		// 배열에 숫자 저장
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			numArr[i] = num;
		}

		// 이분 탐색을 위해 정렬
		Arrays.sort(numArr);

		// 찾을 숫자의 개수
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			// 숫자 입력
			int num = Integer.parseInt(st.nextToken());
			// 탐색 시작 인덱스
			int start = 0;
			// 탐색 종료 인덱스
			int end = numArr.length - 1;
			// 존재 여부 저장
			boolean isExist = false;

			// 정상 범위일 때 반복
			while (start <= end) {
				// 중간점
				int mid = (start + end) / 2;

				// 이분 탐색
				if (numArr[mid] > num) {
					end = mid - 1;
				} else if (numArr[mid] < num) {
					start = mid + 1;
				} else {
					isExist = true;
					break;
				}
			}

			// 존재 여부에 따라 결과 출력
			if (isExist) {
				sb.append('1').append('\n');
			} else {
				sb.append('0').append('\n');
			}

		}

		// 출력
		System.out.println(sb);

	}

}
