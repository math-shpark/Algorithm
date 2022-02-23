package level1;

import java.util.Scanner;

public class Problem2669 {

	// 2669. 직사각형의 네개의 합집합의 면적 구하기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 좌표평면 생성
		int[][] coordinate = new int[101][101];

		// 4개의 직사각형이 위치한 곳에 1을 표시하는 반복문
		for (int i = 0; i < 4; i++) {
			int startX = scan.nextInt();
			int startY = scan.nextInt();
			int endX = scan.nextInt();
			int endY = scan.nextInt();

			for (int j = startY; j < endY; j++) {
				for (int k = startX; k < endX; k++) {
					coordinate[j][k] = 1;
				}
			}
		}

		// 넓이를 저장할 변수
		int area = 0;

		// 1로 표시된 곳의 개수가 넓이
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (coordinate[i][j] == 1) {
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
