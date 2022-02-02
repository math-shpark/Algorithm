package level1;

import java.util.Scanner;

public class Problem1236 {

	// 1236. 성 지키기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 높이 입력
		int height = scan.nextInt();
		// 가로 입력
		int width = scan.nextInt();

		// 주어진 입력값을 기반으로 공간 생성
		String[][] place = new String[height][width];

		// 지형정보 입력
		for (int i = 0; i < height; i++) {
			place[i] = scan.next().split("");
		}

		// 비어있는 행의 수를 저장할 변수
		int rowCount = 0;

		// 행이 비어있으면 rowCount 1 추가하는 반복문
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (place[i][j].equals("X")) {
					break;
				} else if (j == width - 1) {
					rowCount++;
				}
			}
		}

		// 비어있는 열의 수를 저장할 변수
		int columnCount = 0;

		// 열이 비어있으면 columnCount 1 추가하는 반복문
		for (int j = 0; j < width; j++) {
			for (int i = 0; i < height; i++) {
				if (place[i][j].equals("X")) {
					break;
				} else if (i == height - 1) {
					columnCount++;
				}
			}
		}

		// 비어있는 행의 수와 열의 수 중 큰 값이 정답
		// 더 많이 비어있는 행 또는 열을 채워 자동으로 더 적은 비어있는 열을 해결하면 됨
		System.out.println(Math.max(rowCount, columnCount));

		// 끝내기
		scan.close();

	}

}
