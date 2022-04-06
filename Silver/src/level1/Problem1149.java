package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1149 {

	// 색별로 상수 지정
	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;

	// 비용
	static int[][] Cost;
	// 다이나믹 프로그래밍
	static int[][] DP;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 집의 개수 입력
		int N = Integer.parseInt(br.readLine());

		// 집의 개수에 맞춰 배열 크기 지정
		Cost = new int[N][3];
		DP = new int[N][3];

		// 각 집별, 색깔별 비용 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			Cost[i][Red] = Integer.parseInt(st.nextToken());
			Cost[i][Green] = Integer.parseInt(st.nextToken());
			Cost[i][Blue] = Integer.parseInt(st.nextToken());
		}

		// 첫 번째 집 비용을 다이나믹 프로그래밍 배열에 입력(경계로 사용)
		DP[0][Red] = Cost[0][Red];
		DP[0][Green] = Cost[0][Green];
		DP[0][Blue] = Cost[0][Blue];

		// 결과 출력
		System.out.println(Math.min(costCal(N - 1, Red), Math.min(costCal(N - 1, Green), costCal(N - 1, Blue))));
	}

	// 선택한 색으로 칠할 경우 비용 계산
	// 매개변수 : 칠할 집 인덱스, 칠할 색
	private static int costCal(int N, int color) {

		// 아직 계산하지 않은 색이면
		if (DP[N][color] == 0) {

			// 칠하려는 색을 이전 집이 칠하지 않을 경우의 최소 비용에
			// 지금 칠하려는 색의 비용을 추가한 값을 저장
			switch (color) {
			case Red:
				DP[N][Red] = Math.min(costCal(N - 1, Green), costCal(N - 1, Blue)) + Cost[N][Red];
				break;
			case Green:
				DP[N][Green] = Math.min(costCal(N - 1, Red), costCal(N - 1, Blue)) + Cost[N][Green];
				break;
			case Blue:
				DP[N][Blue] = Math.min(costCal(N - 1, Red), costCal(N - 1, Green)) + Cost[N][Blue];
				break;
			}

		}

		// 칠한 결과 비용을 반환
		return DP[N][color];
	}

}
