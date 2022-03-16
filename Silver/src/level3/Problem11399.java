package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11399 {

	// 11399. ATM
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람 수 입력
		int N = Integer.parseInt(br.readLine());

		// 사람별 소요 시간을 저장할 배열
		int[] people = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열에 시간 저장
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순으로 정렬
		Arrays.sort(people);

		// 누적합으로 데이터 수정
		for (int i = 1; i < N; i++) {
			people[i] += people[i - 1];
		}

		long sum = 0;

		// 누적합의 총합이 결과
		for (int i = 0; i < N; i++) {
			sum += people[i];
		}

		System.out.println(sum);

	}

}
