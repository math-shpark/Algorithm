package d3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Problem1860 {

	// 1860. 진기의 최고급 붕어빵
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {
			// 사람 수
			int N = scan.nextInt();
			// 붕어빵 제조 시간
			int M = scan.nextInt();
			// 붕어빵 제조 개수
			int K = scan.nextInt();

			// 가능 여부를 저장할 변수
			boolean isPossible = true;

			// 붕어빵이 만들어지면 저장할 스택
			Stack<Integer> food = new Stack<>();
			// 사람별 도착 정보를 저장할 맵
			Map<Integer, Integer> time = new HashMap<>();
			// 제일 늦게 도착하는 시간을 저장할 변수
			int maxTime = 0;

			// 사람별 도착 정보를 맵에 저장하고
			// 제일 늦게 도착하는 시간을 찾는 반복문
			for (int i = 0; i < N; i++) {
				int person = scan.nextInt();

				if (maxTime < person) {
					maxTime = person;
				}

				if (time.get(person) != null) {
					time.put(person, time.get(person) + 1);
				} else {
					time.put(person, 1);
				}
			}

			// 0초에 도착하는 사람이 있으면
			// 무조건 불가
			if (time.get(0) != null) {
				isPossible = false;
			} else {
				// 0초 이후에 도착하면
				for (int sec = 1; sec <= maxTime; sec++) {
					// M의 배수 시간마다 K개의 붕어빵 제조
					if (sec % M == 0) {
						for (int i = 0; i < K; i++) {
							food.push(1);
						}
					}

					// 해당 시간에 도착하는 사람이 있으면
					if (time.get(sec) != null) {
						// 도착한 사람 수가 남은 개수보다 많으면 불가능
						if (time.get(sec) > food.size()) {
							isPossible = false;
							break;
						} else {
							// 아니면 해당 인원 수만큼 붕어빵 제거
							for (int i = 0; i < time.get(sec); i++) {
								food.pop();
							}
						}
					}
				}

			}

			// 반복문을 무사히 거치면 가능한 것
			if (isPossible) {
				System.out.println("#" + test + " Possible");
			} else {
				System.out.println("#" + test + " Impossible");
			}

		}

		// Scanner 종료
		scan.close();

	}

}
