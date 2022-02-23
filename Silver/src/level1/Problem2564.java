package level1;

import java.util.Scanner;

public class Problem2564 {

	// 2564. 경비원
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 가로 길이
		int col = scan.nextInt();
		// 세로 길이
		int row = scan.nextInt();
		// 상점 수
		int stores = scan.nextInt();
		// 상점 좌표를 저장할 배열
		int[][] position = new int[stores][2];

		// 상점별 좌표를 저장하는 배열
		for (int store = 0; store < stores; store++) {
			int direction = scan.nextInt();
			int distance = scan.nextInt();

			switch (direction) {
			case 1:
				position[store][0] = 0;
				position[store][1] = distance;
				break;
			case 2:
				position[store][0] = row;
				position[store][1] = distance;
				break;
			case 3:
				position[store][0] = distance;
				position[store][1] = 0;
				break;
			case 4:
				position[store][0] = distance;
				position[store][1] = col;
				break;
			}

		}

		// 경비원의 방향
		int Xdirection = scan.nextInt();
		// 경비원의 기준점으로부터 거리
		int Xdistance = scan.nextInt();
		// 경비원의 위치를 저장할 변수
		int X = 0;
		int Y = 0;

		// 방향에 따른 경비원의 위치를 변환
		switch (Xdirection) {
		case 1:
			X = 0;
			Y = Xdistance;
			break;
		case 2:
			X = row;
			Y = Xdistance;
			break;
		case 3:
			X = Xdistance;
			Y = 0;
			break;
		case 4:
			X = Xdistance;
			Y = col;
			break;
		}

		// 최소합을 저장할 변수
		int minSum = 0;

		// 경우에 따라 최소합을 구해 minSum에 더하는 반복문
		for (int i = 0; i < stores; i++) {

			// 경비원과 상점이 같은 가로 줄에 위치한 경우(맨 위나 맨 아래만)
			if ((X == 0 && position[i][0] == 0) || (X == row && position[i][0] == row)) {
				minSum += Math.abs(Y - position[i][1]);
			} else if ((Y == 0 && position[i][1] == 0) || (Y == col && position[i][1] == col)) {
				// 경비원과 상점이 같은 세로 줄에 위치한 경우(맨 왼쪽이나 맨 오른쪽만)
				minSum += Math.abs(X - position[i][0]);
			} else {
				// 나머지 경우 모두
				int hSum = Math.min(position[i][1] + Y, 2 * col - position[i][1] - Y);
				int vSum = Math.min(position[i][0] + X, 2 * row - position[i][0] - X);

				minSum += hSum + vSum;
			}

		}

		// 결과 출력
		System.out.println(minSum);

		// Scanner 종료
		scan.close();

	}

}
