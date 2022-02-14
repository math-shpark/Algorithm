package level1;

import java.util.Scanner;

public class Problem2563 {

	// 2563. 색종이
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 좌표평면 공간 정보를 저장할 배열
		int[][] space = new int[100][100];
		// 덮을 색종이의 수
		int papers = scan.nextInt();
		// 덮힌 부분의 넓이를 저장할 변수
		int area = 0;

		// 색종이로 덮힌 부분의 위치를 1로 표시하는 반복문
		for (int i = 0; i < papers; i++) {

			int x = scan.nextInt();
			int y = scan.nextInt();

			for (int j = y; j < y + 10; j++) {
				for (int k = x; k < x + 10; k++) {
					space[j][k] = 1;
				}
			}

		}

		// 1로 표시된 곳의 개수가 넓이이므로
		// 1로 표시된 곳의 개수를 세는 반복문
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (space[i][j] == 1) {
					area++;
				}
			}
		}

		// 결과 출력
		System.out.println(area);

		// Scanner 종료
		scan.close();

	}

}
