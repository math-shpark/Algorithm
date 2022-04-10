package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1952 {

	// 최소 비용
	static int minVal;
	// 이용권 가격
	static int[] price;
	// 월별 이용 계획
	static int[] plan;

	// 1952. 수영장
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			// 가격 정보
			price = new int[4];

			// 가격 정보 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			// 월별 이용 계획
			plan = new int[12];
			// 월별 계획 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			// 최소 비용 초기화(1년 이용권 금액)
			minVal = price[3];

			// 최소 비용을 찾는 재귀함수 실행
			findPrice(0, 0);

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(minVal).append('\n');

		}

		// 결과 출력
		System.out.println(sb);

	}

	// 최소 비용 찾는 메서드
	private static void findPrice(int month, int val) {

		// 경계 1
		// 이미 최소 금액이 아니면 건너뛰기
		if (val >= minVal) {
			return;
		}

		// 경계 2
		// 12월까지 탐색이 완료된 경우
		if (month >= 12) {
			// 누적 금액이 최소 비용이면 최신화
			if (val < minVal) {
				minVal = val;
			}
			return;
		}

		// 재귀
		// 탐색하는 달에 이용 계획이 없으면
		// 이용권을 구매할 필요 없음
		if (plan[month] == 0) {
			// 다음달로 이동
			// 누적 금액 동일
			findPrice(month + 1, val);
		} else {
			// 이용 계획이 있을 경우
			// 1. 해당 월을 1일 이용권으로 모두 구매
			findPrice(month + 1, val + plan[month] * price[0]);
			// 2. 해당 월을 1달 이용권으로 구매
			findPrice(month + 1, val + price[1]);
			// 3. 해당 월을 시작으로 하는 3개월 이용권 구매
			findPrice(month + 3, val + price[2]);
		}

	}

}
