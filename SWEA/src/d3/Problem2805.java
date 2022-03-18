package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2805 {

	// 2805. 농작물 수확하기
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {

			// 공간 크기 입력
			int N = Integer.parseInt(br.readLine());

			// 입력한 크기에 맞춰 배열 생성
			int[][] space = new int[N][N];
			// 중심 좌표의 인덱스
			int center = N / 2;
			// 총 수익을 저장할 변수
			int sum = 0;

			// 데이터를 배열에 저장
			for (int i = 0; i < N; i++) {
				String str = br.readLine();

				for (int j = 0; j < N; j++) {
					space[i][j] = str.charAt(j) - 48; // 0의 아스키코드 값을 빼서 입력
				}
			}

			// 중심 선 기준 위의 합 (중심선 포함)
			for (int i = 0; i <= center; i++) {
				for (int j = center - i; j <= center + i; j++) {
					sum += space[i][j];
				}
			}

			// 중심 선 기준 아래 합 (중심선 제외)
			for (int i = N - 1; i > center; i--) {
				for (int j = center - (N - 1 - i); j <= center + (N - 1 - i); j++) {
					sum += space[i][j];
				}
			}

			// 결과 출력
			System.out.println("#" + test + " " + sum);
			
		}

	}

}
