package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10816 {

	// 10816. 숫자 카드 2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력할 숫자 개수
		int N = Integer.parseInt(br.readLine());
		// 숫자 개수를 저장할 배열
		int[] count = new int[20000001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력한 숫자의 최대
		int maxValue = -10000000;
		// 입력한 숫자의 최소
		int minValue = 10000000;

		// 배열에 숫자 개수를 입력하고
		// 입력한 숫자의 최대, 최소를 찾는 반복문
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			count[num + 10000000]++;
			if (num > maxValue) {
				maxValue = num;
			}
			if (num < minValue) {
				minValue = num;
			}
		}

		// 찾을 숫자 개수
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		// 찾을 숫자가 입력한 숫자 범위 안의 수이면
		// 해당 숫자를 인덱스로 갖는 곳의 데이터를 출력
		// 아니면 0 출력하는 반복문
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num > maxValue || num < minValue) {
				sb.append(0).append(" ");
				continue;
			}

			sb.append(count[num + 10000000]).append(" ");
		}

		// 결과 출력
		System.out.println(sb);

	}

}
