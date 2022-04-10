package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1247 {

	// 고객 위치 정보
	static int[][] location;
	// 선택한 고객 순서
	static int[] order;
	// 회사 좌표
	static int compX;
	static int compY;
	// 집 좌표
	static int homeX;
	static int homeY;
	// 고객 수
	static int custNum;
	// 최단 경로 길이
	static int minDis;

	// 1247. 최적 경로
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			// 고객의 수
			custNum = Integer.parseInt(br.readLine());

			// 위치 정보 배열 크기 입력
			location = new int[custNum][2];

			// 최단 경로 길이 초기화
			minDis = Integer.MAX_VALUE;

			// 선택 고객 배열 크기 입력
			order = new int[custNum];

			// 초기 순서 입력
			for (int i = 0; i < custNum; i++) {
				order[i] = i;
			}

			// 좌표 정보 읽기
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 회사 좌표
			compX = Integer.parseInt(st.nextToken());
			compY = Integer.parseInt(st.nextToken());

			// 집 좌표
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());

			// 고객 좌표 입력
			for (int i = 0; i < custNum; i++) {
				location[i][0] = Integer.parseInt(st.nextToken());
				location[i][1] = Integer.parseInt(st.nextToken());
			}

			// 순열
			permutation(0);

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(minDis).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// 순열
	private static void permutation(int count) {
		// 경계
		if (count == custNum) {
			// 현재 순서로 경로를 설정할 때 총 이동 거리
			int totalDis = 0;

			// 회사에서 첫 번째 고객에게 갈 때 이동 거리
			totalDis += Math.abs(compX - location[order[0]][0]) + Math.abs(compY - location[order[0]][1]);

			// 고객 간 이동할 때 거리
			for (int i = 1; i < custNum; i++) {
				totalDis += Math.abs(location[order[i]][0] - location[order[i - 1]][0])
						+ Math.abs(location[order[i]][1] - location[order[i - 1]][1]);
			}

			// 마지막 고객에서 집으로 이동 거리
			totalDis += Math.abs(homeX - location[order[custNum - 1]][0])
					+ Math.abs(homeY - location[order[custNum - 1]][1]);

			// 최솟값으로 최신화
			if (totalDis < minDis) {
				minDis = totalDis;
			}

			return;
		}

		// 재귀
		for (int i = count; i < custNum; i++) {
			int temp = order[count];
			order[count] = order[i];
			order[i] = temp;

			permutation(count + 1);

			order[i] = order[count];
			order[count] = temp;
		}

	}

}
