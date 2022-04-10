package d2;

import java.util.Scanner;

public class Problem1940 {

	// 1940. 가랏! RC카!
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {

			// 명령 개수 입력
			int N = scan.nextInt();

			// 속도
			int velocity = 0;
			// 이동 거리
			int distance = 0;

			// 명령 개수만큼 반복
			for (int i = 0; i < N; i++) {
				// 명령 입력
				int command = scan.nextInt();
				// 가속도
				int acc = 0;

				// 0이 아닌 경우 가속도 입력
				if (command != 0) {
					acc = scan.nextInt();
				} else {
					// 0이면 거리 계산 후 건너뛰기
					distance += velocity;
					continue;
				}

				// 가속
				if (command == 1) {
					velocity += acc;
				} else {
					// 감속
					velocity -= acc;

					// 감속한 속도가 음수면 0 반환
					if (velocity < 0) {
						velocity = 0;
					}
				}

				// 거리 계산
				distance += velocity;
			}

			// 결과 출력
			System.out.println("#" + test + " " + distance);

		}

		// Scanner 종료
		scan.close();

	}

}
