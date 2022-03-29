package level1;

import java.util.Scanner;

public class Problem6064 {

	// 6064. 카잉 달력
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		for (int test = 1; test <= testCase; test++) {
			// 주어진 데이터 입력
			int M = scan.nextInt();
			int N = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();

			// 가능 여부 저장 변수
			boolean isPossible = false;
			// 가능할 경우 연도를 저장할 변수
			int year = 0;

			// 나머지를 취할 것이기 때문에 N과 y가 같으면 0으로 취함
			if (y == N) {
				y = 0;
			}

			// x년부터 M*N년까지 M년씩 증가하면서
			// 해당 연도를 N으로 나눈 나머지가 y와 동일하면
			// 해당 연도를 취함
			for (int i = x; i < (M * N); i += M) {
				if (i % N == y) {
					year = i;
					isPossible = true;
					break;
				}
			}

			// 가능 여부에 따라 결과 출력
			if (isPossible) {
				System.out.println(year);
			} else {
				System.out.println(-1);
			}

		}

		scan.close();
	}

}
