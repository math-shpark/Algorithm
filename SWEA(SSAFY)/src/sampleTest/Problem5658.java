package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem5658 {

	// 5638. 보물상자 비밀번호
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 매개변수 입력
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 문자열 입력
			String str = br.readLine();

			// 만들어지는 숫자를 저장할 HashSet
			HashSet<String> numSet = new HashSet<String>();

			// N을 4로 나는 몫만큼 반복
			for (int i = 0; i < N / 4; i++) {
				// 맨 마지막 글자
				String temp = str.substring(str.length() - 1);

				// 맨 마지막 글자를 맨 앞으로 이동시킨 문자열로 변경
				str = temp + str.substring(0, str.length() - 1);

				// 이동시킨 문자열을 앞에서부터 N/4개씩 잘라서 set에 추가
				for (int j = 0; j < 4; j++) {
					numSet.add(str.substring(j * (N / 4), (j + 1) * (N / 4)));
				}
			}

			// set을 배열로 변환
			String[] numArr = numSet.toArray(new String[0]);

			// 16진수로 저장된 숫자를 10진수로 변환
			int[] numArr2 = new int[numArr.length];
			for (int i = 0; i < numArr.length; i++) {
				numArr2[i] = Integer.parseInt(numArr[i], 16);
			}

			// 10진수로 저장된 배열을 정렬
			Arrays.sort(numArr2);

			// 오름차순으로 정렬되어 있으므로
			// 뒤에서 K번째인 수를 결과 문자열에 연결
			sb.append("#").append(test).append(" ").append(numArr2[numArr2.length - K]).append('\n');

		}

		// 결과 출력
		System.out.println(sb);

	}

}
