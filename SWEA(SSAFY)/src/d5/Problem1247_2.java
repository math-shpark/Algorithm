package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1247_2 {

	// 고객 위치 정보
	static int[][] location;
	// 고객의 수
	static int custNum;
	// 선택 여부 배열
	static boolean[] isSelected;
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
			location = new int[custNum + 2][2];

			// 선택 여부 저장 배열 크기 입력
			isSelected = new boolean[custNum];

			// 최단 경로 길이 초기화
			minDis = Integer.MAX_VALUE;

			// 좌표 정보 읽기
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 고객 좌표 입력
			// 0번 좌표는 회사
			// 1번 좌표는 집
			for (int i = 0; i < custNum + 2; i++) {
				location[i][0] = Integer.parseInt(st.nextToken());
				location[i][1] = Integer.parseInt(st.nextToken());
			}

			// 순열
			permutation(location[0][0], location[0][1], 0, 0);

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(minDis).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// 순열
	// 매개변수 : 출발점 좌표(X), 출발점 좌표(Y), 현재까지 선택한 숫자의 개수, 현재까지 이동거리
	private static void permutation(int startX, int startY, int count, int tempDis) {
		// 경계1
		// 이미 최단 거리가 아니면 종료
		if (tempDis >= minDis) {
			return;
		}

		// 경계 2
		// 집을 다 돈 경우
		if (count == custNum) {

			// 마지막 손님으로부터 집까지 오는 경로만 더해줌
			tempDis += Math.abs(startX - location[1][0]) + Math.abs(startY - location[1][1]);
			
			if(tempDis < minDis) {
				minDis = tempDis;
			}

			return;
		}

		// 재귀
		for (int i = 0; i < custNum; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				int temp = tempDis + Math.abs(startX - location[i + 2][0]) + Math.abs(startY - location[i + 2][1]);
				permutation(location[i + 2][0], location[i + 2][1], count + 1, temp);
				isSelected[i] = false;
			}
		}

	}

}
