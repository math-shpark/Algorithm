package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem7568 {

	// 7568. 덩치
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람 수 입력
		int N = Integer.parseInt(br.readLine());
		// 사람의 키와 몸무게를 저장할 배열
		int[][] person = new int[N][2];

		// 사람 신체 정보를 배열에 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
		}

		// 사람별 등수를 저장할 리스트
		ArrayList<Integer> order = new ArrayList<>();
		// 비교 기준 인덱스
		int index = 0;

		// 비교 기준 인덱스가 마지막 사람이 될 때까지 반복
		while (index < N) {

			// 기준 사람보다 더 덩치인 사람의 수
			int count = 0;

			// 덩치 조건을 만족하면 count에 추가
			for (int i = 0; i < N; i++) {
				if (person[index][0] < person[i][0] && person[index][1] < person[i][1]) {
					count++;
				}
			}

			// count+1이 등수
			order.add(count + 1);
			// 기준 사람 다음으로
			index++;
		}

		// 결과 문자열
		StringBuilder sb = new StringBuilder();

		// 결과 붙이기
		for (int i = 0; i < N; i++) {
			sb.append(order.get(i));
			sb.append(" ");
		}

		// 출력
		System.out.println(sb);

	}

}
