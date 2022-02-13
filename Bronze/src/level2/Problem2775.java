package level2;

import java.util.Scanner;

public class Problem2775 {

	// 2775. 부녀회장이 될테야
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입주 규칙에 맞춰 배열에 아파트 입주 정보를 저장하는 반복문
		for (int i = 0; i < testCase; i++) {
			// 층
			int k = scan.nextInt();
			// 호
			int n = scan.nextInt();

			// 아파트 입주민 수를 저장할 배열
			int[][] apt = new int[k + 1][n + 1];

			// 0층 입주민 입력
			for (int j = 1; j <= n; j++) {
				apt[0][j] = j;
			}

			// 1층부터 k층까지 입주민 수 입력
			for (int floor = 1; floor <= k; floor++) {
				for (int room = 1; room <= n; room++) {
					for (int j = 1; j <= room; j++) {
						apt[floor][room] += apt[floor - 1][j];
					}
				}
			}

			// 원하는 호수의 입주민 수 출력
			System.out.println(apt[k][n]);

		}

		// Scanner 종료
		scan.close();

	}

}
